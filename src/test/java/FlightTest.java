import fit5171.monash.edu.Airplane;
import fit5171.monash.edu.Flight;
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
//@ExtendWith(MockitoExtension.class)
public class FlightTest {

    private Flight flight;
    private Airplane airplane;

//    @Mock
//    private AirplaneModelA airplaneModelA;

    @BeforeAll
    static void initAll(){
        FlightTest flightTest = new FlightTest();
    }

    @BeforeEach
    void init(){
        airplane = new Airplane();
        flight = new Flight();
    }
//Still can not use the mock
    @Test
    void testFlightValidity()
    {
        int flightID = 123456;
        String departTo = "Melbourne" ;
        String departFrom =  "Sydney";
        String code = "123456";
        String company = "AUAirLine";
//        airplane = mock(Airplane.class);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;

        try {
            date = dateFormat.parse("23/09/2007");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        long time = date.getTime();
        Timestamp dateFrom =  new Timestamp(time);

        try {
            date = dateFormat.parse("24/09/2007");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        long time2 = date.getTime();
        new Timestamp(time2);

        Timestamp dateTo =  new Timestamp(time2);;


        int expectedFlightID = 123456;
        String expectedDepartTo = "Melbourne" ;
        String expectedDepartFrom =  "Sydney";
        String expectedCode = "123456";
        String expectedCompany = "AUAirLine";
        Timestamp expectedDateFrom = Timestamp.valueOf("2022/09/10");
        Timestamp expectedDateTo = Timestamp.valueOf("2022/09/11");


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

        flight.setDateTo(dateTo);
        assertEquals(expectedDateTo,flight.getDateTo());

        flight.setDateFrom(dateFrom);
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
        String code = "";
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            flight.setCode(code);
        });
        assertEquals("Company can not be Empty",exception.getMessage());
    }

    @Test
    void testDateFromEmpty()
    {
        Timestamp dateFrom = Timestamp.valueOf("");
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            flight.setDateFrom(dateFrom);
        });
        assertEquals("DateFrom can not be Empty or enter invalid Format",exception.getMessage());
    }

    @Test
    void testDateToEmpty()
    {
        Timestamp dateTo = Timestamp.valueOf("");
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            flight.setDateTo(dateTo);
        });
        assertEquals("DateTo can not be Empty or enter invalid Format",exception.getMessage());
    }

    @Test
    void testAirplaneEmpty()
    {
        AirplaneModelA AirplaneMock = Mockito.mock(AirplaneModelA.class);
        when(AirplaneMock.getAirplaneID());
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            flight.setAirplane(airplane);
        });
        assertEquals("Airplane object can not be Empty or enter invalid Format",exception.getMessage());
    }

}