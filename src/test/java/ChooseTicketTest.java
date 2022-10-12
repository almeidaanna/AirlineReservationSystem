import assignment.monash.edu.*;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

    @DisplayName("Test class for ChooseTicket")
    class ChooseTicketTest {
    private ChooseTicket chooseTicket;
    private Airplane airplane;
    private Flight flight;
    private Ticket ticket;
    private BuyTicket buyTicket;

    @BeforeAll
    static  void initAll(){
        ChooseTicketTest chooseTicketTest = new ChooseTicketTest();
    }

    @BeforeEach
    void init(){
        airplane = new Airplane();
        flight = new Flight();
        ticket = new Ticket();
    }

    @Test
    void testChooseTicketInvalidCity() {
        String inputCity1 = "MEL";
        String inputCity2 = "QLD";
        Airplane airplane = new Airplane(101, "747", 30, 60, 4);
        flight = new Flight(34543, "SYD", "MEL", "A342", "Boeing", "12/09/2022","13/09/2022", airplane );
        FlightCollection.addFlights(flight);
        Ticket expectedTicket = new Ticket(10024, 1000, flight, true, new Passenger());
        TicketCollection.addTicket(expectedTicket);
        Throwable actual = assertThrows(java.lang.IllegalArgumentException.class, ()->{
            String userInput = "10024";
            System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            chooseTicket = new ChooseTicket();
            chooseTicket.chooseTicket(inputCity1, inputCity2);
        });
        assertEquals("No Flights exist to the input city", actual.getMessage());
    }

    @Test
    void testPassengerChoiceInvalid(){
        Airplane airplane = new Airplane(101, "747", 30, 60, 4);
        flight = new Flight(34543, "SYD", "MEL", "A342", "Boeing", "12/09/2022","13/09/2022", airplane );
        FlightCollection.addFlights(flight);
        Ticket expectedTicket = new Ticket(10024, 1000, flight, true, new Passenger());
        TicketCollection.addTicket(expectedTicket);
        String userInput = "20521\n";
        Throwable actual = assertThrows(java.lang.IllegalArgumentException.class, ()-> {
            System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            chooseTicket = new ChooseTicket();
            chooseTicket.chooseTicket("SYD", "MEL");
        });
        assertEquals("This ticket does not exist!", actual.getMessage());
    }

    @Test
    void testChooseConnectingTicketInvalidCity() {
        String inputCity1 = "MEL";
        String inputCity2 = "QLD";

        Airplane airplane = new Airplane(101, "747", 30, 60, 4);
        flight = new Flight(34543, "MEL", "ADL", "A342", "Boeing", "12/09/2022","13/09/2022", airplane );
        FlightCollection.addFlights(flight);
        Ticket ticket1 = new Ticket(10024, 200, flight, true, new Passenger());
        TicketCollection.addTicket(ticket1);

        Airplane airplane2 = new Airplane(116, "747", 30, 60, 4);
        Flight flight2 = new Flight(30021, "SYD", "QLD", "A342", "Boeing", "13/09/2022","13/09/2022", airplane2 );
        FlightCollection.addFlights(flight2);
        Ticket ticket2 = new Ticket(10026, 250, flight2, true, new Passenger());
        TicketCollection.addTicket(ticket2);

        Throwable actual = assertThrows(java.lang.IllegalArgumentException.class, ()->{
            String userInput = "10024";
            System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            chooseTicket = new ChooseTicket();
            chooseTicket.chooseTicket(inputCity1, inputCity2);
        });
        assertEquals("Cannot find a flight between the two input cities", actual.getMessage());
    }

    @AfterEach
    void reset() {
        FlightCollection.getFlights().removeAll(FlightCollection.getFlights());
        TicketCollection.getTickets().removeAll(TicketCollection.getTickets());
    }
}
