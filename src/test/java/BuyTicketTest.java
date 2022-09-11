import fit5171.monash.edu.BuyTicket;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

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
}