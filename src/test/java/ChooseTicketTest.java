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
        String inputCity1 = "";
        String inputCity2 = "";
        chooseTicket.chooseTicket(inputCity1, inputCity2);
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
