import assignment.monash.edu.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Test for ticket class")
    class TicketTest {
    private Ticket ticket;
    Airplane airplane;
    Flight flight;
    Passenger passenger;

    @BeforeEach
    void init(){
        int ticket_id = 10010;
        int price = 1000;
        airplane = mock(Airplane.class);
        flight = mock(Flight.class);
        boolean classVip = false;
        passenger = mock(Passenger.class);
        ticket = new Ticket(ticket_id, price, flight, classVip, passenger);
    }

    @Test
    void testTicketValidity()
    {
        int price = 1001;
        int expectedTicket_id = 10052;
        int expectedPrice = (int) (price * 1.12);
        boolean expectedClassVip = false;
        ticket.setTicketId(expectedTicket_id);
        assertEquals(expectedTicket_id,ticket.getTicketId());
        ticket.setPassenger(passenger);
        assertEquals(passenger,ticket.getPassenger());
        ticket.setFlight(flight);
        assertEquals(flight,ticket.getFlight());
        when(passenger.getAge()).thenReturn(43);
        ticket.setPrice(price);
        assertEquals(expectedPrice,ticket.getPrice());
        ticket.setClassVip(expectedClassVip);
        assertEquals(expectedClassVip,ticket.getClassVip());
    }

    @Test
    void testTicketStatus()
    {
        boolean status = false;
        Flight flight = null;
        Passenger passenger = new Passenger();
        Ticket ticket = new Ticket(4034,500,flight, false,passenger);
        String exception = assertThrows(java.lang.IllegalArgumentException.class,() ->{
            ticket.setTicketStatus(true);
        }).getMessage();
        assertFalse(ticket.ticketStatus());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,14,60})
    void testSaleByAgeDiscount(int age)
    {
        if(age == 0) {
            Exception exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
                ticket.saleByAge(age);
            });
            assertEquals("Invalid age", exception.getMessage());
        }
        else if(age < 15) {
           ticket.saleByAge(age);
           assertEquals(500, ticket.getPrice());
        }
        else if (age >= 60) {
           ticket.saleByAge(age);
           assertEquals(0, ticket.getPrice());
        }
    }

    @Test
    void testPrice()
    {
        int price = 0;
        when(ticket.getPassenger().getAge()).thenReturn(43);
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            ticket.setPrice(price);
        });
        assertEquals("Invalid Price",exception.getMessage());
    }

    @Test
    void testPriceAndServiceTax()
    {
        int price = -5;
        ticket.saleByAge(43);
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            ticket.setPrice(price);
        });
        assertEquals("Invalid Price",exception.getMessage());
    }

    @Test
    void testServiceTaxOnEveryTicketSold()
    {
        int price = 1000;
        when(passenger.getAge()).thenReturn(43);
        ticket.setPrice(price);
        assertEquals(price* 1.12,ticket.getPrice());
    }
}
