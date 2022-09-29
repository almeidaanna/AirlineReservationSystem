import fit5171.monash.edu.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;

@DisplayName("Test class for ChooseTicket")
public class ChooseTicketTest {
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
    public void init(){
        airplane = new Airplane();
        flight = new Flight();
        ticket = new Ticket();
    //    buyTicket = mock(BuyTicket.class);
    }

//    @Test
//    void validateCity(){
//        airplane = new Airplane(101, "Airbus", 30, 60, 4);
//        flight = new Flight(34567, "Mel", "Syd", "A342", "Boeing", "12/09/2022","18/09/2022", airplane );
//        int ticket_id = 10010;
//        int price = 1000;
//        boolean classVip = false;
//        Passenger passenger = mock(Passenger.class);
//        ticket = new Ticket(ticket_id, price, flight, classVip, passenger);
//        TicketCollection.addTicket(ticket);
//        FlightCollection.addFlights(flight);
//        String inputCity1 = "Mel";
//        String inputCity2 = "Syd";
//        String userInput = "10010";
//        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
//        chooseTicket = new ChooseTicket();
//        try {
//            buyTicket = mock(BuyTicket.class);
//            doNothing().when(buyTicket).buyTicket(anyInt());
//            chooseTicket.chooseTicket(inputCity1, inputCity2);
//            verify(buyTicket,times(1)).buyTicket(10010);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        Flight flightResult = chooseTicket.getBuyTicket().getFlight();
//
//        assertEquals(FlightCollection.getFlightInfo(inputCity1, inputCity2), flightResult);
//    }

    @Test
    void validateChoice(){

    }

//    @Test
//    void validateFlight()
//    {
//        Airplane airplane = new Airplane(101, "Airbus", 30, 60, 4);
//        Flight newflight = new Flight(34567, "Mel", "Syd", "A342", "Boeing", "12/09/2022","18/09/2022", airplane );
//        FlightCollection.addFlights(newflight);
//
//        Flight flightResult = chooseTicket.getBuyTicket().getFlight();
//       // assertEquals(FlightCollection.getFlightInfo(inputCity1, inputCity2), flightResult);
//    }
}
