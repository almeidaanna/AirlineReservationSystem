import assignment.monash.edu.Airplane;
import assignment.monash.edu.Flight;
import assignment.monash.edu.FlightCollection;
import org.junit.jupiter.api.*;
import static junit.framework.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("This is a Test class for Airplane")
    class AirplaneTest {
    private Airplane airplane;

    @BeforeEach
    void init()
    {
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
    void testSitNumberValid()
    {
        Airplane newAirplane = new Airplane(123456,"AF123", 5, 20, 2);
        int expectedBusinessSitNumber = 5;
        int expectedEconomySitNumber = 20;
        int expectedCrewSitNumber = 2;
        assertEquals(expectedBusinessSitNumber, newAirplane.getBusinessSitsNumber());
        assertEquals(expectedEconomySitNumber, newAirplane.getEconomySitsNumber());
        assertEquals(expectedCrewSitNumber, newAirplane.getCrewSitsNumber());

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

    @Test
    void testGetAirplaneInfoWithValidID()
    {
        Airplane existAirplane = new Airplane(123456,"AF123", 5, 20, 2);
        Flight existFlight = new Flight(12345, "Melbourne", "Sydney", "AA703", "AusAir",
                "10/09/2022", "11/09/2022", existAirplane);
        FlightCollection.addFlights(existFlight);
        assertEquals(existAirplane, Airplane.getAirPlaneInfo(123456));
    }

    @Test
    void testGetAirplaneInfoWithInvalidID()
    {
        Airplane existAirplane = new Airplane(123456,"AF123", 5, 20, 2);
        Flight existFlight = new Flight(12345, "Melbourne", "Sydney", "AA703", "AusAir",
                "10/09/2022", "11/09/2022", existAirplane);
        FlightCollection.addFlights(existFlight);
        assertNull(null,Airplane.getAirPlaneInfo(123999));
    }

    @AfterEach
    public void reset(){
        FlightCollection.getFlights().removeAll(FlightCollection.getFlights());
    }
}
