import fit5171.monash.edu.Airplane;
import fit5171.monash.edu.Flight;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;


@DisplayName("This is test class for Flight")
@ExtendWith(MockitoExtension.class)
public class FlightTest {

    private Flight flight;

    @Mock
    private Airplane airplane;

    @BeforeAll
    static void initAll(){
        FlightTest flightTest = new FlightTest();
    }

    @BeforeEach
    void init(){

        flight = new Flight();
    }

    @Test
    void testFlightValidity()
    {
        int flightID = 123456;
        String departTo = "Melbourne" ;
        String departFrom =  "Sydney";
        String code = "123456";
        String company = "AUAirLine";
        Timestamp dateFrom = Timestamp.valueOf("2022/09/10");
        Timestamp dateTo = Timestamp.valueOf("2022/09/11");
        airplane = mock(Airplane.class);

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
        assertEquals("Code can not be Empty",exception.getMessage());
    }
}