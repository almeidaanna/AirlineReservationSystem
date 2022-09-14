import fit5171.monash.edu.Airplane;
import fit5171.monash.edu.Flight;
import fit5171.monash.edu.FlightCollection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("This is a test class for flightCollection")
public class FlightCollectionTest {

    private FlightCollection flightCollection;
    private Flight flight;
    private Airplane airplane;

    @BeforeAll
    static void initALL()
    {
        FlightCollectionTest flightCollectionTest = new FlightCollectionTest();
    }

    @Test
    public void testAddFlights()
    {
        ArrayList<Flight> flights = new ArrayList<>();
        Flight newFlight = new Flight(12345, "Melbourne", "Sydney", "AA703", "AusAir",
                "2022/09/10", "2022/09/11", airplane);
        FlightCollection.addFlights(flights);
    }

    @Test
    public void testGetFlightInfo()
    {
        String inputValidCity1 = "Melbourne";
        String inputValidCity2 = "Sydney";
        String inputInvalidCity1 = "";
        String inputInvalidCity2 = "";
        Flight expectedValidFlight = new Flight(12345, "Melbourne", "Sydney", "AA703", "AusAir",
                "2022/09/10", "2022/09/11", airplane);
        FlightCollection.flights.add(expectedValidFlight);

        String expectedInValidString = "Can not find flights you want.";

        Flight actualValidFlight = FlightCollection.getFlightInfo(inputValidCity1, inputValidCity2);

        String actuallyInvalidFlight = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            Flight flight = FlightCollection.getFlightInfo(inputInvalidCity1, inputInvalidCity2);
        }).getMessage();

        assertEquals(expectedValidFlight, actualValidFlight);
        assertEquals(expectedInValidString, actuallyInvalidFlight);

    }

    @Test
    public void testGetFlightInfoOneCity()
    {
        String inputValidCity = "Melbourne";
        String inputInvalidCity = "";
        Flight expectedValidFlight = new Flight(12345, "Melbourne", "Sydney", "AA703", "AusAir",
                "2022/09/10","2022/09/11", airplane);
        FlightCollection.flights.add(expectedValidFlight);

        String expectedInValidString = "Can not find flights you want by one city.";

        Flight actualValidFlight = FlightCollection.getFlightInfo(inputValidCity);

        String actuallyInvalidFlight = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            Flight flight = FlightCollection.getFlightInfo(inputInvalidCity);
        }).getMessage();

        assertEquals(expectedValidFlight, actualValidFlight);
        assertEquals(expectedInValidString, actuallyInvalidFlight);
    }

    @Test
    public void testGetFlightInfoFlightID()
    {
        int inputValidFlightID = 12345;
        int inputInvalidFlightID= 0;
        Flight expectedValidFlight = new Flight(12345, "Melbourne", "Sydney", "AA703", "AusAir",
                "2022/09/10", "2022/09/11", airplane);
        FlightCollection.flights.add(expectedValidFlight);

        Flight actualValidFlight = FlightCollection.getFlightInfo(inputValidFlightID);

        String actuallyInvalidFlight = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            Flight flight = FlightCollection.getFlightInfo(inputInvalidFlightID);
        }).getMessage();
        String expectedInValidString = "Can not find flights you want by one city.";

        assertEquals(expectedValidFlight, actualValidFlight);
        assertEquals(expectedInValidString, actuallyInvalidFlight);
    }















}
