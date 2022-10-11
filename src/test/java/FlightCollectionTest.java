import assignment.monash.edu.Airplane;
import assignment.monash.edu.Flight;
import assignment.monash.edu.FlightCollection;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("This is a test class for flightCollection")
class FlightCollectionTest {

    private FlightCollection flightCollection;
    private Flight flight;
    private Airplane airplane;

    @BeforeAll
    static void initALL()
    {
        FlightCollectionTest flightCollectionTest = new FlightCollectionTest();
    }

    @BeforeEach
    void init()
    {
        airplane = new Airplane();
        //flightCollection = new FlightCollection();
        flight = new Flight();
    }

    @Test
    void testAddFlightsValid()
    {
        Flight newFlight = new Flight(12345, "Melbourne", "Sydney", "AA703", "AusAir",
                "10/09/2022", "11/09/2022", airplane);
        FlightCollection.addFlights(newFlight);
        Flight expectedFlight = FlightCollection.getFlightInfo(12345);
        assertEquals(expectedFlight, newFlight);
    }

    @Test
    void testGetFlightByTwoCityValid()
    {
        String inputValidCity1 = "Melbourne";
        String inputValidCity2 = "Sydney";
        Flight expectedValidFlight = new Flight(12345, "Melbourne", "Sydney", "AA703", "AusAir",
                "10/09/2022", "11/09/2022", airplane);
        FlightCollection.addFlights(expectedValidFlight);
        Flight actualValidFlight = FlightCollection.getFlightInfo(inputValidCity1, inputValidCity2);

        assertEquals(expectedValidFlight, actualValidFlight);

    }

    @Test
    void testGetFlightByTwoCityInvalid()
    {
        String inputInvalidCity1 = "asffawfasd";
        String inputInvalidCity2 = "asduhanwknhisa";
        Flight flight = new Flight(12345, "Melbourne", "Sydney", "AA703", "AusAir",
                "10/09/2022", "11/09/2022", airplane);
        FlightCollection.addFlights(flight);
        Flight actualFlight = FlightCollection.getFlightInfo(inputInvalidCity1, inputInvalidCity2);
        assertNull(actualFlight);
    }

    @Test
    void testGetFlightInfoByOneCityValid()
    {
        String inputValidCity = "Sydney";
        Flight expectedValidFlight = new Flight(12345, "Melbourne", "Sydney", "AA703", "AusAir",
                "10/09/2022","11/09/2022", airplane);
        FlightCollection.addFlights(expectedValidFlight);

        Flight actualValidFlight = FlightCollection.getFlightInfo(inputValidCity);

        assertEquals(expectedValidFlight, actualValidFlight);
    }

    @Test
    void testGetFlightByOneCityInvalid()
    {
        String inputInvalidCity = "asffawfasd";
        Flight expectedValidFlight = new Flight(12345, "Melbourne", "Sydney", "AA703", "AusAir",
                "10/09/2022", "11/09/2022", airplane);
        FlightCollection.addFlights(expectedValidFlight);
        Flight flight = FlightCollection.getFlightInfo(inputInvalidCity);

        assertNull(flight);
    }

    @Test
    void testGetFlightInfoByFlightIDValid()
    {
        int inputValidFlightID = 12345;
        Flight expectedValidFlight = new Flight(12345, "Melbourne", "Sydney", "AA703", "AusAir",
                "10/09/2022", "11/09/2022", airplane);
        FlightCollection.addFlights(expectedValidFlight);
        Flight actualValidFlight = FlightCollection.getFlightInfo(inputValidFlightID);

        assertEquals(expectedValidFlight, actualValidFlight);
    }

    @Test
    void testGetFlightByFlightIDInvalid()
    {
        int inputInvalidFlightID = 78347834;
        Flight expectedValidFlight = new Flight(12345, "Melbourne", "Sydney", "AA703", "AusAir",
                "10/09/2022", "11/09/2022", airplane);
        FlightCollection.addFlights(expectedValidFlight);
        String expectedInValidString = "Can not find flights you want by FlightID you entered.";

        String actualInvalidString = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            Flight flight = FlightCollection.getFlightInfo(inputInvalidFlightID);
        }).getMessage();

        assertEquals(expectedInValidString, actualInvalidString);
    }

    @AfterEach
    void reset(){
        FlightCollection.getFlights().removeAll(FlightCollection.getFlights());
    }
}
