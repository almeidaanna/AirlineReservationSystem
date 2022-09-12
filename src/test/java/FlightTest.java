import fit5171.monash.edu.Airplane;
import fit5171.monash.edu.Flight;
import fit5171.monash.edu.FlightCollection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;



@DisplayName("This is test class for Flight")
public class FlightTest {

    private Flight flight;

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
        String airplaneModel = "AF123";
        String departTo = "Melbourne" ;
        String departFrom =  "Sydney";
        String code = "123456";
        String company = "AUsAir";
        Timestamp dateFrom = Timestamp.valueOf("2022/09/10");
        Timestamp dateTo = Timestamp.valueOf("2022/09/11");

        int expectedAirplaneID = 123456;
        String expectedAirplaneModel = "AF123";
        int expectedBusinessSitsNumber = 5;
        int expectedEconomySitsNumber = 20;
        int expectedCrewSitsNumber = 2;

//        airplane.setAirplaneID(airplaneID);
//        assertEquals(expectedAirplaneID,airplane.getAirplaneID());
//
//        airplane.setAirplaneModel(airplaneModel);
//        assertEquals(expectedAirplaneModel,airplane.getAirplaneModel());
//
//        airplane.setBusinessSitsNumber(businessSitsNumber);
//        assertEquals(expectedBusinessSitsNumber,airplane.getBusinessSitsNumber());
//
//        airplane.setEconomySitsNumber(economySitsNumber);
//        assertEquals(expectedEconomySitsNumber,airplane.getEconomySitsNumber());
//
//        airplane.setCrewSitsNumber(crewSitsNumber);
//        assertEquals(expectedCrewSitsNumber,airplane.getCrewSitsNumber());
    }


}
