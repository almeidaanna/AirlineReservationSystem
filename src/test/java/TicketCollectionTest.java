import fit5171.monash.edu.Flight;
import fit5171.monash.edu.Passenger;
import fit5171.monash.edu.Ticket;
import fit5171.monash.edu.TicketCollection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Test class for TicketCollection")
public class TicketCollectionTest {
    private TicketCollection ticketCollection;
    private Flight flight;
    private Passenger passenger;
    private Ticket inputTicket;
    ArrayList<Ticket> newTickets;

    @BeforeAll
    static void initAll(){
        TicketCollectionTest ticketCollectionTest = new TicketCollectionTest();
    }

    @BeforeEach
    public void setup(){
        TicketCollection ticketCollection1 = new TicketCollection();
    }

    @Test
    public void testAddTicketValid(){
        inputTicket = new Ticket(12345, 600, flight,true, passenger);
        TicketCollection.addTicket(inputTicket);

        Ticket actualTicket = TicketCollection.getTicketInfo(12345);

        assertEquals(inputTicket, actualTicket);
    }

    @Test
    public void testAddTicketNull(){
        String expectedResult = "Invalid Ticket";

        String actualResult = assertThrows(java.lang.NullPointerException.class, () -> {
            TicketCollection.addTicket(inputTicket);
        }).getMessage();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddTicketExists(){
        inputTicket = new Ticket(12345, 600, flight,true, passenger);
        TicketCollection.addTicket(inputTicket);

        String expectedResult = "Duplicate Ticket";
        Ticket testTicket = new Ticket(12345, 500,flight, false, passenger);
        String actualResult = assertThrows(java.lang.RuntimeException.class, ()->{
            TicketCollection.addTicket(testTicket);
        }).getMessage();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddTicketsNull(){
        String expectedResult = "Invalid Tickets, Cannot be added to list";

        String actualResult = assertThrows(java.lang.NullPointerException.class, () -> {
            TicketCollection.addTickets(newTickets);
        }).getMessage();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testTicketInfo()
    {
        int inputValidTicket_id = 12345;
        int inputInvalidTicket_id = 0;

        Ticket expectedValidTicket = new Ticket(12345, 600, flight,true, passenger);
        TicketCollection.tickets.add(expectedValidTicket);
        String expectedInvalidTicket = "Ticket does not exist.";

        Ticket actualValidTicket_id = TicketCollection.getTicketInfo(inputValidTicket_id);
        String actualInvalidTicket_id = assertThrows(java.lang.IllegalArgumentException.class,() ->{
            Ticket ticket = TicketCollection.getTicketInfo(inputInvalidTicket_id);
        }).getMessage();

        assertEquals(expectedValidTicket, actualValidTicket_id);
        assertEquals(expectedInvalidTicket, actualInvalidTicket_id);
    }
}