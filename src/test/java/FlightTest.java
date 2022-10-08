import fit5171.monash.edu.Airplane;
import fit5171.monash.edu.Flight;
import fit5171.monash.edu.FlightCollection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@DisplayName("This is test class for Flight")
public class FlightTest {

    private Flight flight;
    private Airplane airplane;

    private FlightCollection flights;



    @BeforeAll
    static void initAll(){
        FlightTest flightTest = new FlightTest();
    }

    @BeforeEach
    void init(){
        airplane = new Airplane();
        flight = new Flight();
        flights = new FlightCollection();
    }

    @Test
    void testFlightValidity()
    {
        int flightID = 123456;
        String departTo = "Melbourne" ;
        String departFrom =  "Sydney";
        String code = "123456";
        String company = "AUAirLine";
        String dateFromString = "23/09/2022";
        String dateToString = "24/09/2022";


        int expectedFlightID = 123456;
        String expectedDepartTo = "Melbourne" ;
        String expectedDepartFrom =  "Sydney";
        String expectedCode = "123456";
        String expectedCompany = "AUAirLine";

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = dateFormat.parse("23/09/2022");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        long time3 = date.getTime();
        new Timestamp(time3);
        Timestamp expectedDateFrom = new Timestamp(time3);

        try {
            date = dateFormat.parse("24/09/2022");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        long time4 = date.getTime();
        new Timestamp(time4);
        Timestamp expectedDateTo =  new Timestamp(time4);


        flight.setFlightID(flightID);
        assertEquals(expectedFlightID,flight.getFlightID());

        flight.setDepartTo(departTo);
        assertEquals(expectedDepartTo,flight.getDepartTo());

        flight.setDepartFrom(departFrom);
        assertEquals(expectedDepartFrom,flight.getDepartFrom());

        flight.setCode(code);
        assertEquals(expectedCode,flight.getCode());

        flight.setCompany(company);
        assertEquals(expectedCompany,flight.getCompany());

        flight.setDateTo(dateToString);
        assertEquals(expectedDateTo,flight.getDateTo());

        flight.setDateFrom(dateFromString);
        assertEquals(expectedDateFrom,flight.getDateFrom());

        // Just mock a class of Airplane, when flight.getAirplane = mocked class, then it's work
        flight.setAirplane(airplane);
        assertEquals(airplane,flight.getAirplane());

    }

    @Test
    void testFlightIDEmpty()
    {
        int flightID = 0;
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            flight.setFlightID(flightID);
        });
        assertEquals("FlightID can not be Zero or Empty",exception.getMessage());
    }

    @Test
    void testDepartToEmpty()
    {
        String departTo = "";
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            flight.setDepartTo(departTo);
        });
        assertEquals("DepartTo can not be Empty",exception.getMessage());
    }

    @Test
    void testDepartFromEmpty()
    {
        String departFrom = "";
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            flight.setDepartFrom(departFrom);
        });
        assertEquals("DepartFrom can not be Empty",exception.getMessage());
    }

    @Test
    void testCodeEmpty()
    {
        String code = "";
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            flight.setCode(code);
        });
        assertEquals("Code can not be Empty",exception.getMessage());
    }

    @Test
    void testCompanyEmpty()
    {
        String company = "";
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            flight.setCompany(company);
        });
        assertEquals("Company can not be Empty",exception.getMessage());
    }

    @Test
    void testDateFromEmpty()
    {
        String dateFromString = "";
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            flight.setDateFrom(dateFromString);
        });
        assertEquals("The Input of dateString can not be Empty or Null",exception.getMessage());
    }

    @Test
    void testDateToEmpty()
    {
        String dateToString = "";
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            flight.setDateTo(dateToString);
        });
        assertEquals("The Input of dateString can not be Empty or Null",exception.getMessage());
    }

    @Test
    void testDateFromInvalid()
    {
        String dateFromString = "sziovsdkjfbi";
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            flight.setDateFrom(dateFromString);
        });
        assertEquals("This is invalid format of dateString",exception.getMessage());
    }

    @Test
    void testDateToInvalid()
    {
        String dateToString = "klsdfsenjsdfoid";
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            flight.setDateTo(dateToString);
        });
        assertEquals("This is invalid format of dateString",exception.getMessage());
    }


    @Test
    void cannotSetExistAirplane()
    {
        Airplane mockAirplane = Mockito.mock(Airplane.class);
        when(mockAirplane.getAirplaneID()).thenReturn(7890);

        Flight existFlight = new Flight(12345, "Melbourne", "Sydney", "AA703", "AusAir",
                "10/09/2022", "11/09/2022", mockAirplane);
        FlightCollection.addFlights(existFlight);

        String expectedInValidString = "This airplane has already used for another flight";

        String actualInvalidString = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            Flight newFlight = new Flight(78958, "Perth", "Sydney", "AC703", "AusAir",
                    "15/09/2022", "17/09/2022", mockAirplane);
        }).getMessage();

        assertEquals(expectedInValidString, actualInvalidString);

    }

    @Test
    void testToStringWithValidValue()
    {
        Airplane newAirplane = new Airplane(123456,"AF123", 5, 20, 2);
        Flight existFlight = new Flight(12345, "Melbourne", "Sydney", "AA703", "AusAir",
                "10/09/2022", "11/09/2022", newAirplane);
        String expectedResult = "Flight{" + newAirplane.toString() +
                ", date to=" +  "2022-09-11 00:00:00.0" + ", " + '\'' +
                ", date from='" + "2022-09-10 00:00:00.0" + '\'' +
                ", depart from='" + "Sydney" + '\'' +
                ", depart to='" + "Melbourne" + '\'' +
                ", code=" + "AA703" + '\'' +
                ", company=" + "AusAir" + '\'' +
                '}';
        assertEquals(expectedResult, existFlight.toString());

    }

}