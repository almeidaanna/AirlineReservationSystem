import fit5171.monash.edu.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void validateCity(){
        Airplane airplane = new Airplane(101, "Airbus", 30, 60, 4);
        Flight newflight = new Flight(34567, "Mel", "Syd", "A342", "Boeing", "12/09/2022","18/09/2022", airplane );
        FlightCollection.addFlights(newflight);
        String inputCity1 = "Mel";
        String inputCity2 = "Syd";
        try {
            chooseTicket.chooseTicket(inputCity1, inputCity2);
        } catch (Exception e) {
            throw new NullPointerException();
        }


        Flight flightResult = chooseTicket.getBuyTicket().getFlight();
        assertEquals(FlightCollection.getFlightInfo(inputCity1, inputCity2), flightResult);
    }

    @Test
    void validateChoice(){

    }

    @Test
    void validateFlight()
    {
        Airplane airplane = new Airplane(101, "Airbus", 30, 60, 4);
        Flight newflight = new Flight(34567, "Mel", "Syd", "A342", "Boeing", "12/09/2022","18/09/2022", airplane );
        FlightCollection.addFlights(newflight);

        Flight flightResult = chooseTicket.getBuyTicket().getFlight();
       // assertEquals(FlightCollection.getFlightInfo(inputCity1, inputCity2), flightResult);
    }
}
