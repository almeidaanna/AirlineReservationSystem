import fit5171.monash.edu.ChooseTicket;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Test class for ChooseTicket")
public class ChooseTicketTest {
    private ChooseTicket chooseTicket;

    @BeforeAll
    static  void initAll(){
        ChooseTicketTest chooseTicketTest = new ChooseTicketTest();
    }

    @BeforeEach
    public void init(){
        chooseTicket = new ChooseTicket();
    }
}
