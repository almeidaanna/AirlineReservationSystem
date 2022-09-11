import fit5171.monash.edu.Flight;
import fit5171.monash.edu.Passenger;
import fit5171.monash.edu.Ticket;
import fit5171.monash.edu.TicketCollection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

@DisplayName("Test class for TicketCollection")
public class TicketCollectionTest {
    private TicketCollection ticketCollection;
    private Flight flight;
    private Passenger passenger;

    @BeforeAll
    static  void initAll(){
        TicketCollectionTest ticketCollectionTest = new TicketCollectionTest();
    }

    @Test
    public void testAddTickets(){
        ArrayList<Ticket> tickets = new ArrayList<>();
        Ticket inputTicket = new Ticket(12345, 600, flight,true, passenger);
        TicketCollection.addTickets(tickets);
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