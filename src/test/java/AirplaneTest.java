import fit5171.monash.edu.Airplane;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;



@DisplayName("This is a Test class for Airplane")
public class AirplaneTest {


        private Airplane airplane;
        @BeforeAll
        static void initAll(){
            AirplaneTest airplaneTest = new AirplaneTest();
        }
        @BeforeEach
        void init(){
            airplane = new Airplane();
        }

        @Test
        void testAirplaneValidity()
        {
            int airplaneID = 123456;
            String airplaneModel = "Normal";
            int businessSitsNumber = 5;
            int economySitsNumber = 20;
            int crewSitsNumber = 2;



            int expectedAirplaneID = 123456;
            String expectedAirplaneModel = "Normal";
            int expectedBusinessSitsNumber = 5;
            int expectedEconomySitsNumber = 20;
            int expectedCrewSitsNumber = 2;

            airplane.setAirplaneID(airplaneID);
            assertEquals(expectedAirplaneID,airplane.getAirplaneID());

            airplane.setAirplaneModel(airplaneModel);
            assertEquals(expectedAirplaneModel,airplane.getAirplaneModel());

            airplane.setBusinessSitsNumber(businessSitsNumber);
            assertEquals(expectedBusinessSitsNumber,airplane.getBusinessSitsNumber());

            airplane.setEconomySitsNumber(economySitsNumber);
            assertEquals(expectedEconomySitsNumber,airplane.getEconomySitsNumber());

            airplane.setCrewSitsNumber(crewSitsNumber);
            assertEquals(expectedCrewSitsNumber,airplane.getCrewSitsNumber());
        }

        @Test
        void testAirplaneIDEmpty()
        {
            int airplaneID = 0;
            Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
                airplane.setAirplaneID(airplaneID);
            });
            assertEquals("AirplaneID can not be Zero",exception.getMessage());
        }


}
