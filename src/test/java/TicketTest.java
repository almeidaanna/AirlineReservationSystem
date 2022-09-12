import fit5171.monash.edu.Person;
import fit5171.monash.edu.Ticket;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
