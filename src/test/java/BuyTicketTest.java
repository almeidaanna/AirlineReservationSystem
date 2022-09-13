import fit5171.monash.edu.BuyTicket;
import fit5171.monash.edu.Flight;
import fit5171.monash.edu.Passenger;
import fit5171.monash.edu.Ticket;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@DisplayName("Test class for BuyTicket")
public class BuyTicketTest {
    private BuyTicket buyTicket;

    @BeforeAll
    static  void initAll(){
        BuyTicketTest buyTicketTest = new BuyTicketTest();
    }

    @BeforeEach
    public void init(){
        buyTicket = new BuyTicket();
    }

    @Test
    void testBuyTicketValidity(){
        Passenger expectedPassenger = Mockito.mock(Passenger.class);
        Ticket expectedTicket = Mockito.mock(Ticket.class);
        Flight expectedFlight = Mockito.mock(Flight.class);

    }
}