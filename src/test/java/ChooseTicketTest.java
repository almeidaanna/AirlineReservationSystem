import fit5171.monash.edu.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
    }

    @Test
    void testChooseTicketInvalid() {

        String inputCity1 = "ABC";
        String inputCity2 = "DEF";
        Airplane airplane = new Airplane(101, "747", 30, 60, 4);
        flight = new Flight(34543, "SYD", "MEL", "A342", "Boeing", "12/09/2022","13/09/2022", airplane );
        FlightCollection.addFlights(flight);
        Ticket expectedTicket = new Ticket(10024, 1000, flight, true, new Passenger());
        TicketCollection.addTicket(expectedTicket);
        Throwable actual = assertThrows(java.lang.IllegalArgumentException.class, ()->{
            String userInput = "10024\nJane\nDoe\n43\n\nFemale\njanedoe@gmail.com\n0458353978\nM79843234\n1\n1234567891012345\n123";
            System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            chooseTicket = new ChooseTicket();
            chooseTicket.chooseTicket(inputCity1, inputCity2);
        });
        assertEquals("Can not find flights you want by two city you entered.",actual.getMessage());

    }

    @Test
    void validateCity(){

    }

    @Test
    void validateChoice(){

    }

    @Test
    void validateFlight()
    {

    }
}
