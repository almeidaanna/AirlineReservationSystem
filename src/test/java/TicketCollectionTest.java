import fit5171.monash.edu.TicketCollection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Test class for TicketCollection")
public class TicketCollectionTest {
    private TicketCollection ticketCollection;

    @BeforeAll
    static  void initAll(){
        TicketCollectionTest ticketCollectionTest = new TicketCollectionTest();
    }

    @BeforeEach
    public void init(){
        ticketCollection = new TicketCollection();
    }
}
