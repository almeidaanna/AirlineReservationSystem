import fit5171.monash.edu.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Test for ticket class")
public class TicketTest {
    private Ticket ticket;
    Airplane airplane;
    Flight flight;
    Passenger passenger;

    @BeforeAll
    static void initAll(){
        TicketTest ticketTest = new TicketTest();
    }

    @BeforeEach
    void init(){
        int ticket_id = 10010;
        int price = 1000;
        airplane = mock(Airplane.class);
    //    flight = new Flight(34567, "Mel", "Syd", "A342", "Boeing", "12/09/2022","18/09/2022", airplane );
        flight = mock(Flight.class);
        boolean classVip = false;
        passenger = mock(Passenger.class);
//        passenger = new Passenger("Jane", "Doe", 43, "Female", "janedoe@gmail.com", "0458353978", "M79843234","1234567891012345", 123);
        ticket = new Ticket(ticket_id, price, flight, classVip, passenger);
    }

    @Test
    void testTicketValidity()
    {
        int price = 1001;
        int expectedTicket_id = 10052;
        int expectedPrice = (int) (price * 1.12);
        //Flight expectedFlight = mock(Flight.class);
        boolean expectedClassVip = false;
       // Passenger expectedPassenger = mock(Passenger.class);

        ticket.setTicket_id(expectedTicket_id);
        assertEquals(expectedTicket_id,ticket.getTicket_id());
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
        Passenger passenger = null;
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
        int price = -1000;
        when(passenger.getAge()).thenReturn(43);
        ticket.setPrice(price);
        assertEquals(price* 1.12,ticket.getPrice());
    }
}
