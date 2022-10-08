import fit5171.monash.edu.*;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test class for BuyTicket")
public class BuyTicketTest {
    private BuyTicket buyTicket;

    Passenger passenger;
    Flight flight;

    @BeforeAll
    static  void initAll(){
        BuyTicketTest buyTicketTest = new BuyTicketTest();
    }

    @BeforeEach
    public void init(){
        passenger = new Passenger("Jane", "Doe", 43, "Female", "janedoe@gmail.com", "0458353978", "M79843234","1234567891012345", 123);
        Airplane airplane = new Airplane(101, "Airbus", 30, 60, 4);
        flight = new Flight(34543, "Mel", "Syd", "A342", "Boeing", "12/09/2022","18/09/2022", airplane );
        FlightCollection.addFlights(flight);
    }
    @Test
    void testBuyTicketValidity()
    {
        int inputTicketId = 10024;
        String expectedPassenger = passenger.toString();
        Ticket expectedTicket = new Ticket(10024, 1000, flight, true, passenger);
        TicketCollection.addTicket(expectedTicket);
        try {
            String userInput = "Jane\nDoe\n43\n\nFemale\njanedoe@gmail.com\n0458353978\nM79843234\n1\n1234567891012345\n123";
            System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            buyTicket = new BuyTicket();
            buyTicket.buyTicket(inputTicketId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String actualPassenger = buyTicket.getPassenger().toString();
        assertEquals(expectedPassenger, actualPassenger);
        assertEquals(expectedTicket, buyTicket.getTicket());
        assertEquals(flight,buyTicket.getFlight());
    }

    @Test
    void testInvalidPassenger()
    {
        int inputTicketId = 10024;
        Ticket ticket = new Ticket(10024, 1000, flight, true, passenger);
        TicketCollection.addTicket(ticket);
        String userInput = "Jane\nDoe\n43\n\nFemale\n@tfgybhn\n\n0458353978\nM79843234\n1\n1234567891012345\n123";
        Throwable actual = assertThrows(java.lang.IllegalArgumentException.class, () ->{
                System.setIn(new ByteArrayInputStream(userInput.getBytes()));
                buyTicket = new BuyTicket();
                buyTicket.buyTicket(inputTicketId);
        });
        String expected = "Invalid email address";
        assertEquals(expected, actual.getMessage());
    }

    @Test
    void testInvalidFlight()
    {
        int inputTicketId = 10024;
        Airplane inputAirplane = new Airplane(102, "Airbus", 30, 60, 4);
        Flight inputFlight = new Flight(0, "Mel", "Syd", "A363", "Boeing", "12/11/2022","12/11/2022", inputAirplane);
        Ticket expectedTicket = new Ticket(10024, 1000, inputFlight, true, passenger);
        TicketCollection.addTicket(expectedTicket);
        Throwable actual = assertThrows(java.lang.IllegalArgumentException.class, ()->{
            String userInput = "Jane\nDoe\n43\n\nFemale\njanedoe@gmail.com\n0458353978\nM79843234\n1\n1234567891012345\n123";
            System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            buyTicket = new BuyTicket();
            buyTicket.buyTicket(inputTicketId);
        });
        String expected = "Can not find flights you want by FlightID you entered.";
        assertEquals(expected,actual.getMessage());
    }

    @Test
    void testInvalidTicket()
    {
        int inputTicketId = 10025;
        Ticket expectedTicket = new Ticket(10022, 1000, flight, true, passenger);
        TicketCollection.addTicket(expectedTicket);
        Throwable actual = assertThrows(java.lang.NullPointerException.class, ()->{
            String userInput = "Jane\nDoe\n43\n\nFemale\njanedoe@gmail.com\n0458353978\nM79843234\n1\n1234567891012345\n123";
            System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            buyTicket = new BuyTicket();
            buyTicket.buyTicket(inputTicketId);
        });
        String expected = "Ticket does not exist";
        assertEquals(expected, actual.getMessage());
    }

    @AfterEach
    public void reset()
    {
        FlightCollection.getFlights().removeAll(FlightCollection.getFlights());
        TicketCollection.getTickets().removeAll(TicketCollection.getTickets());
    }
}