import assignment.monash.edu.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("This is to test the Passenger class")
class PassengerTest {
    private Passenger passenger;

    @BeforeEach
    void init(){
        passenger = new Passenger();
    }

    @Test
    void constructorTestValid(){
        Passenger newPassenger = new Passenger("Jane", "Doe", 43, "Female", "janedoe@gmail.com", "0458353978", "M79843234","1234567891012345", 123);
        String expectedResult = "Passenger{ Fullname= Jane Doe ,email='janedoe@gmail.com', phoneNumber='0458353978', passport='M79843234}";
        assertEquals(expectedResult, newPassenger.toString());
    }

    @Test
    void constructorTestInvalid(){
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            Passenger newPassenger = new Passenger("", "", 43, "Female", "janedoe@gmail.com", "0458353978", "M79843234","1234567891012345", 123);
        });
        String expectedResult = "Invalid details";
        assertEquals(expectedResult, exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Male","Female","Other"})
    void testPassengerValidity(String expectedGender)
    {
        String expectedEmail = "janedoe@gmail.com";
        String expectedFirstName ="Jane";
        String expectedSecondName = "Doe";
        String expectedPassport = "A123Z4569";
        int expectedSecurityCode = 123;
        String expectedCardNumber = "1234567891052378";
        String expectedPhoneNumber = "0458353974";
        int expectedAge = 42;
        passenger.setEmail(expectedEmail);
        assertEquals(expectedEmail,passenger.getEmail());
        passenger.setFirstName(expectedFirstName);
        assertEquals(expectedFirstName,passenger.getFirstName());
        passenger.setSecondName(expectedSecondName);
        assertEquals(expectedSecondName,passenger.getSecondName());
        passenger.setPassport(expectedPassport);
        assertEquals(expectedPassport,passenger.getPassport());
        passenger.setSecurityCode(expectedSecurityCode);
        assertEquals(expectedSecurityCode,passenger.getSecurityCode());
        passenger.setCardNumber(expectedCardNumber);
        assertEquals(expectedCardNumber,passenger.getCardNumber());
        passenger.setPhoneNumber(expectedPhoneNumber);
        assertEquals(expectedPhoneNumber,passenger.getPhoneNumber());
        passenger.setAge(expectedAge);
        assertEquals(expectedAge,passenger.getAge());
        passenger.setGender(expectedGender);
        assertTrue(Arrays.asList(expectedGender).contains(passenger.getGender()));
    }

    @Test
    void testEmailEmpty()
    {
        String email = "";
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            passenger.setEmail(email);
        });
        assertEquals("Email can not be empty", exception.getMessage());
    }

    @Test
    void testFirstNameEmpty()
    {
        String firstName = "";
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            passenger.setFirstName(firstName);
        });
        assertEquals("Invalid details",exception.getMessage());
    }

    @Test
    void testSecondNameEmpty()
    {
        String secondName = "";
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            passenger.setSecondName(secondName);
        });
        assertEquals("Invalid details",exception.getMessage());
    }

    @Test
    void testAge()
    {
        int invalidAge = 0;
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            passenger.setAge(invalidAge);
        });
        assertEquals("Invalid age",exception.getMessage());
    }

    @Test
    void testGenderEmpty()
    {
        String gender= "";
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            passenger.setGender(gender);
        });
        assertEquals("Gender can not be empty",exception.getMessage());
    }

    @Test
    void testFirstNameNull()
    {
        String firstName = null;
        Throwable exception = assertThrows(java.lang.NullPointerException.class, () -> {
            passenger.setFirstName(firstName);
        });
        assertEquals("Invalid details",exception.getMessage());
    }

    @Test
    void testSecondNameNull()
    {
        String secondName = null;
        Throwable exception = assertThrows(java.lang.NullPointerException.class, () -> {
            passenger.setSecondName(secondName);
        });
        assertEquals("Invalid details",exception.getMessage());
    }

    @Test
    void testGenderNull()
    {
        String gender= null;
        Throwable exception = assertThrows(java.lang.NullPointerException.class, () -> {
            passenger.setGender(gender);
        });
        assertEquals("Gender can not be null",exception.getMessage());
    }

    @Test
    void testGenderOptions() {

        String genderInputInvalid = "abc";
        String expectedResultInvalid ="Invalid gender";
        String exception = assertThrows(java.lang.IllegalArgumentException.class,() ->{
            passenger.setGender(genderInputInvalid);
        }).getMessage();
        assertEquals(expectedResultInvalid,exception);
    }

    @Test
    void testFirstNameFormat() {
        String FirstNameInputInvalid = "j@n3";
        String expectedResultInvalid ="Invalid First Name";
        String exception = assertThrows(java.lang.IllegalArgumentException.class,() ->{
            passenger.setFirstName(FirstNameInputInvalid);
        }).getMessage();
        assertEquals(expectedResultInvalid,exception);
    }

    @Test
    void testSecondNameFormat() {
        String SecondNameInputInvalid = "D03";
        String expectedResultInvalid ="Invalid details";
        String exception = assertThrows(java.lang.IllegalArgumentException.class,() ->{
            passenger.setSecondName(SecondNameInputInvalid);
        }).getMessage();
        assertEquals(expectedResultInvalid,exception);
    }

    @Test
    void testEmailNull()
    {
        String email = null;
        Throwable exception = assertThrows(java.lang.NullPointerException.class, () -> {
            passenger.setEmail(email);
        });
        assertEquals("Email can not be null", exception.getMessage());
    }

    @Test
    void testPassportEmpty()
    {
        String passport = "";
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            passenger.setPassport(passport);
        });
        assertEquals("Passport can not be empty", exception.getMessage());
    }

    @Test
    void testPassportNull()
    {
        String passport = null;
        Throwable exception = assertThrows(java.lang.NullPointerException.class, () -> {
            passenger.setPassport(passport);
        });
        assertEquals("Passport can not be null", exception.getMessage());
    }

    @Test
    void testSecurityCodeEmpty()
    {
        int securityCode = 0;
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            passenger.setSecurityCode(securityCode);
        });
        assertEquals("Invalid Security Code", exception.getMessage());
    }

    @Test
    void testCardNumberEmpty()
    {
        String cardNumber = "";
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            passenger.setCardNumber(cardNumber);
        });
        assertEquals("Card Number can not be empty", exception.getMessage());
    }

    @Test
    void testCardNumberNull()
    {
        String cardNumber = null;
        Throwable exception = assertThrows(java.lang.NullPointerException.class, () -> {
            passenger.setCardNumber(cardNumber);
        });
        assertEquals("Card Number can not be null", exception.getMessage());
    }

    @Test
    void testPhoneNumberEmpty()
    {
        String phoneNumber = "";
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            passenger.setPhoneNumber(phoneNumber);
        });
        assertEquals("Phone Number can not be empty", exception.getMessage());
    }

    @Test
    void testPhoneNumberNull()
    {
        String phoneNumber = null;
        Throwable exception = assertThrows(java.lang.NullPointerException.class, () -> {
            passenger.setPhoneNumber(phoneNumber);
        });
        assertEquals("Phone Number can not be null", exception.getMessage());
    }

    @Test
    void testPhoneNumberPattern()
    {
        String phoneNumber = "012E5Ab597@";
        String expectedResult = "Invalid phone number";
        String exception = assertThrows(java.lang.IllegalArgumentException.class,() ->{
            passenger.setPhoneNumber(phoneNumber);
        }).getMessage();
        assertEquals(expectedResult,exception);
    }

    @Test
    void testEmailPattern()
    {
        String email = "AbC$@.125";
        String expectedResult = "Invalid email address";
        String exception = assertThrows(java.lang.IllegalArgumentException.class,() ->{
            passenger.setEmail(email);
        }).getMessage();
        assertEquals(expectedResult,exception);
    }

    @Test
    void testPassportCharacterLength()
    {
        String passport = "01237A7@710";
        String expectedResult = "Invalid passport number";
        String exception = assertThrows(java.lang.IllegalArgumentException.class,() ->{
            passenger.setPassport(passport);
        }).getMessage();
        assertEquals(expectedResult,exception);
    }

    @Test
    void testToString()
    {
        Passenger passenger = new Passenger("Jane", "Doe", 43, "Female", "janedoe@gmail.com", "0458353978", "M79843234","1234567891012345", 123);
        String expectedString = "Passenger{ Fullname= Jane Doe ,email='janedoe@gmail.com', phoneNumber='0458353978', passport='M79843234}";
        assertEquals(expectedString,passenger.toString());
    }

}
