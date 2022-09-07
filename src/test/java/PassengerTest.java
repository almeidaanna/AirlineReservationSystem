import fit5171.monash.edu.Passenger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("This is to test the Passenger class")
public class PassengerTest {
    private Passenger passenger;

    @BeforeAll
    static void initAll(){
        PassengerTest passengerTest = new PassengerTest();
    }

    @BeforeEach
    void init(){
        passenger = new Passenger();
    }

    @Test
    void testAllFields()
    {
        String firstName = "";
        String secondName = "";
        int age = 0;
        String gender = "";
        String email = "";
        String phoneNumber = "";
        String passport = "";
        String cardNumber = "";
        int securityCode = 0;
//        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
//            passenger.(null,)
//        })
    }
    @Test
    void testFirstNameEmpty()
    {
        String firstName = "";
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            passenger.setFirstName(firstName);
        });
    }
}
