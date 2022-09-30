import fit5171.monash.edu.Flight;
import fit5171.monash.edu.Passenger;
import fit5171.monash.edu.Ticket;
import fit5171.monash.edu.TicketCollection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test class for TicketCollection")
public class TicketCollectionTest {
    private Flight flight;
    private Passenger passenger;
    private Ticket inputTicket;
    ArrayList<Ticket> newTickets;

    @BeforeAll
    static void initAll(){
    }

    @BeforeEach
    public void setup(){

    }

    @Test
    public void testAddTicketValid(){
        inputTicket = new Ticket(34221, 600, flight,true, passenger);
        TicketCollection.addTicket(inputTicket);

        Ticket actualTicket = TicketCollection.getTicketInfo(34221);

        assertEquals(inputTicket, actualTicket);
    }

    @Test
    public void testAddTicketNull(){
        String expectedResult = "Invalid Ticket";

        Throwable actualResult = assertThrows(java.lang.NullPointerException.class, () -> {
            TicketCollection.addTicket(inputTicket);
        });

        assertEquals(expectedResult, actualResult.getMessage());
    }

    @Test
    public void testAddTicketExists(){
        inputTicket = new Ticket(12345, 600, flight,true, passenger);
        TicketCollection.addTicket(inputTicket);

        String expectedResult = "Duplicate Ticket";
        Ticket testTicket = new Ticket(12345, 500,flight, false, passenger);
        Throwable actualResult = assertThrows(java.lang.RuntimeException.class, ()->{
            TicketCollection.addTicket(testTicket);
        });
        assertEquals(expectedResult, actualResult.getMessage());
    }

    @Test
    public void testAddTicketsNull(){
        String expectedResult = "Invalid Tickets, Cannot be added to list";

        Throwable actualResult = assertThrows(java.lang.NullPointerException.class, () -> {
            TicketCollection.addTickets(newTickets);
        });

        assertEquals(expectedResult, actualResult.getMessage());
    }

    @Test
    public void testAddTicketsValid(){
        newTickets = new ArrayList<Ticket>();
        Ticket newTicket1 = new Ticket(12345, 600, flight,true, passenger);
        Ticket newTicket2 = new Ticket(30024, 500,flight, false, passenger);
        newTickets.add(newTicket1);
        newTickets.add(newTicket2);
        TicketCollection.addTickets(newTickets);
        assertTrue(TicketCollection.getTickets().containsAll(newTickets));
    }

    @Test
    public void testTicketInfo()
    {
        int inputValidTicket_id = 12345;
        int inputInvalidTicket_id = 0;

        Ticket expectedValidTicket = new Ticket(12345, 600, flight,true, passenger);
        TicketCollection.getTickets().add(expectedValidTicket);
        String expectedInvalidTicket = "Ticket does not exist";

        Ticket actualValidTicket_id = TicketCollection.getTicketInfo(inputValidTicket_id);
        Throwable actualInvalidTicket_id = assertThrows(java.lang.NullPointerException.class,() ->{
            Ticket ticket = TicketCollection.getTicketInfo(inputInvalidTicket_id);
        });

        assertEquals(expectedValidTicket, actualValidTicket_id);
        assertEquals(expectedInvalidTicket, actualInvalidTicket_id.getMessage());
    }
}