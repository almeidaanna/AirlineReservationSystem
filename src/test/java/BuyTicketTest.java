import assignment.monash.edu.*;
import org.junit.jupiter.api.*;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test class for BuyTicket")
    class BuyTicketTest {
    private BuyTicket buyTicket;
    Passenger passenger;
    Flight flight;

    @BeforeEach
    public void init(){
        passenger = new Passenger("Jane", "Doe", 43, "Female", "janedoe@gmail.com", "0458353978", "M79843234","1234567891012345", 123);
        Airplane airplane = new Airplane(101, "747", 30, 60, 4);
        flight = new Flight(34543, "SYD", "MEL", "A342", "Boeing", "12/09/2022","13/09/2022", airplane );
        FlightCollection.addFlights(flight);
    }

    @Test
    void testBuyTicketValidity() {
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
            throw new IllegalArgumentException(e);
        }
        String actualPassenger = buyTicket.getPassenger().toString();
        assertEquals(expectedPassenger, actualPassenger);
        assertEquals(expectedTicket, buyTicket.getTicket());
        assertEquals(flight,buyTicket.getFlight());
    }

    @Test
    void testInvalidPassenger() {
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
    void testInvalidFlight() {
        int inputTicketId = 10024;
        Airplane inputAirplane = new Airplane(102, "747", 30, 60, 4);
        Flight inputFlight = new Flight(0, "SYD", "MEL", "A363", "Boeing", "12/11/2022","13/11/2022", inputAirplane);
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
    void testInvalidTicket() {
        int inputTicketId = 10025;
        Ticket expectedTicket = new Ticket(10024, 1000, flight, true, passenger);
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

    @Test
    void testBuyTwoTicketsValid() {
        int ticketId1 = 10024;
        int ticketId2 = 10157;
        Ticket ticket1 = new Ticket(10024, 110, flight, false, passenger);
        TicketCollection.addTicket(ticket1);
        Airplane airplane = new Airplane(132, "A330", 30, 60, 4);
        Flight flight2 = new Flight(30015, "LHR", "SYD", "F287", "Airbus", "13/09/2022","14/09/2022", airplane );
        FlightCollection.addFlights(flight2);
        Ticket ticket2 = new Ticket(10157, 670, flight2, true, passenger);
        TicketCollection.addTicket(ticket2);
        String userInput = "Jane\nDoe\n43\n\nFemale\njanedoe@gmail.com\n0458353978\nM79843234\n1\n1234567891012345\n123";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        buyTicket = new BuyTicket();
        buyTicket.buyTicket(ticketId1, ticketId2);
        Ticket actualTicket1 = TicketCollection.getTicketInfo(ticketId1);
        Ticket actualTicket2 = TicketCollection.getTicketInfo(ticketId2);
        int expectedPrice = (int) ((110 + 670) * 1.12);
        assertEquals(ticket1, actualTicket1);
        assertEquals(ticket2, actualTicket2);
        assertEquals(expectedPrice, buyTicket.getTicket().getPrice());
    }

    @Test
    void testBuyTwoTicketsInvalidPassenger() {
        int ticketId1 = 10024;
        int ticketId2 = 10157;
        Ticket ticket1 = new Ticket(10024, 110, flight, false, passenger);
        TicketCollection.addTicket(ticket1);
        Airplane airplane = new Airplane(132, "A330", 30, 60, 4);
        Flight flight2 = new Flight(30015, "LHR", "SYD", "F287", "Airbus", "13/09/2022","14/09/2022", airplane );
        FlightCollection.addFlights(flight2);
        Ticket ticket2 = new Ticket(10157, 670, flight2, true, passenger);
        TicketCollection.addTicket(ticket2);
        Throwable expected = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            String userInput = "Jane\nDoe\n43\n\nFemale\n \n0458353978\nM79843234\n1\n1234567891012345\n123";
            System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            buyTicket = new BuyTicket();
            buyTicket.buyTicket(ticketId1, ticketId2);
        });
        assertEquals("Email can not be empty", expected.getMessage());
    }

    @Test
    void testBuyTwoTicketsInvalidFlight() {
        int ticketId1 = 10024;
        int ticketId2 = 10157;
        Ticket ticket1 = new Ticket(10024, 110, flight, false, passenger);
        TicketCollection.addTicket(ticket1);
        Airplane airplane = new Airplane(132, "A330", 30, 60, 4);
        Flight flight2 = new Flight(30015, "LHR", "SYD", "F287", "Airbus", "13/09/2022","14/09/2022", airplane );
        Ticket ticket2 = new Ticket(10157, 670, flight2, true, passenger);
        TicketCollection.addTicket(ticket2);
        Throwable expected = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            String userInput = "Jane\nDoe\n43\n\nFemale\njanedoe@gmail.com\n0458353978\nM79843234\n1\n1234567891012345\n123";
            System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            buyTicket = new BuyTicket();
            buyTicket.buyTicket(ticketId1, ticketId2);
        });
        assertEquals("Can not find flights you want by FlightID you entered.", expected.getMessage());
    }

    @Test
    void testBuyInvalidTicket() {
        int ticketId1 = 10024;
        int ticketId2 = 10167;
        Ticket ticket1 = new Ticket(10024, 110, flight, false, passenger);
        TicketCollection.addTicket(ticket1);
        Airplane airplane = new Airplane(132, "A330", 30, 60, 4);
        Flight flight2 = new Flight(30015, "LHR", "SYD", "F287", "Airbus", "13/09/2022","14/09/2022", airplane );
        Ticket ticket2 = new Ticket(10157, 670, flight2, true, passenger);
        TicketCollection.addTicket(ticket2);
        Throwable expected = assertThrows(java.lang.NullPointerException.class, () -> {
            String userInput = "Jane\nDoe\n43\n\nFemale\njanedoe@gmail.com\n0458353978\nM79843234\n1\n1234567891012345\n123";
            System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            buyTicket = new BuyTicket();
            buyTicket.buyTicket(ticketId1, ticketId2);
        });
        assertEquals("Ticket does not exist", expected.getMessage());
    }

    @AfterEach
    public void reset() {
        FlightCollection.getFlights().removeAll(FlightCollection.getFlights());
        TicketCollection.getTickets().removeAll(TicketCollection.getTickets());
    }
}