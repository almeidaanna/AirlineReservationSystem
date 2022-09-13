import fit5171.monash.edu.Flight;
import fit5171.monash.edu.Passenger;
import fit5171.monash.edu.Person;
import fit5171.monash.edu.Ticket;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for ticket class")
public class TicketTest {
    private Ticket ticket;

    @BeforeAll
    static void initAll(){
        TicketTest ticketTest = new TicketTest();
    }

    @BeforeEach
    void init(){
        ticket = new Ticket();
    }

    @Test
    void testTicketValidity()
    {
        int expectedTicket_id = 10052;
        int expectedPrice = 1001;
        Flight expectedFlight = Mockito.mock(Flight.class);
        boolean expectedClassVip = false;
        Passenger expectedPassenger = Mockito.mock(Passenger.class);

        ticket.setTicket_id(expectedTicket_id);
        assertEquals(expectedTicket_id,ticket.getTicket_id());
        ticket.setPassenger(expectedPassenger);
        assertEquals(expectedPassenger,ticket.getPassenger());
        ticket.setFlight(expectedFlight);
        assertEquals(expectedFlight,ticket.getFlight());
        ticket.setPrice(expectedPrice);
        assertEquals(expectedPrice,ticket.getPrice());
        ticket.setClassVip(expectedClassVip);
        assertEquals(expectedClassVip,ticket.getClassVip());
    }

    @Test
    void testStatus()
    {

    }

    @Test
    void testSaleByAgeDiscount()
    {

    }

    @Test
    void testPrice()
    {

    }

    @Test
    void testPriceAndServiceTax()
    {

    }

    @Test
    void testServiceTaxOnEveryTicketSold()
    {

    }
}
