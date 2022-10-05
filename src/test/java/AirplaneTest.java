import fit5171.monash.edu.Airplane;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import javax.swing.text.TableView;

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
    void testConstructorValidAndToString()
    {
        Airplane newAirplane = new Airplane(123456,"AF123", 5, 20, 2);
        String exceptedString = "Airplane{" +
                "model=" + "AF123" + '\'' +
                ", business sits=" + "5" + '\'' +
                ", economy sits=" + "20" + '\'' +
                ", crew sits=" + "2" + '\'' +
                '}';
        String actualString = newAirplane.toString();
        assertEquals(exceptedString, actualString);

    }


    @Test
    void testAirplaneValidity()
    {
        int airplaneID = 123456;
        String airplaneModel = "AF123";
        int businessSitsNumber = 5;
        int economySitsNumber = 20;
        int crewSitsNumber = 2;



        int expectedAirplaneID = 123456;
        String expectedAirplaneModel = "AF123";
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
        assertEquals("AirplaneID can not be Zero or Empty",exception.getMessage());
    }

    @Test
    void testAirplaneModelEmpty()
    {
        String  airplaneModel= "";
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            airplane.setAirplaneModel(airplaneModel);
        });
        assertEquals("AirplaneModel can not be Empty",exception.getMessage());
    }

    @Test
    void testAirplaneModelNull()
    {
        String airplaneModel= null;
        Throwable exception = assertThrows(java.lang.NullPointerException.class, () -> {
            airplane.setAirplaneModel(airplaneModel);
        });
        assertEquals("AirplaneModel can not be Null",exception.getMessage());
    }


    @Test
    void testBusinessSitsNumberEmpty()
    {
        int businessSitsNumber= 0;
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            airplane.setBusinessSitsNumber(businessSitsNumber);
        });
        assertEquals("BusinessSitsNumber can not be Zero or Empty",exception.getMessage());
    }

    @Test
    void testEconomySitsNumberEmpty()
    {
        int economySitsNumber = 0;
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            airplane.setEconomySitsNumber(economySitsNumber);
        });
        assertEquals("EconomySitsNumber can not be Zero or Empty",exception.getMessage());
    }

    @Test
    void testCrewSitsNumberEmpty()
    {
        int crewSitsNumber = 0;
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            airplane.setCrewSitsNumber(crewSitsNumber);
        });
        assertEquals("CrewSitsNumber can not be Zero or Empty",exception.getMessage());
    }


    @Test
    void testTotalNumberOverRange()
    {
        int economySitsNumber = 100;
        int businessSitsNumber = 200;
        int crewSitsNumber = 200;
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            airplane.totalSitNumber(economySitsNumber, crewSitsNumber, businessSitsNumber);
        });
        assertEquals("Total number of sits should between 1 to 300",exception.getMessage());
    }

}
