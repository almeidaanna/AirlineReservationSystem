import fit5171.monash.edu.Passenger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

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

    @ParameterizedTest
    @ValueSource(strings = {"Male","Female","Other"})
    void testPassengerValidity(String gender)
    {
        String email = "janedoe@gmail.com";
        String firstName = "Jane";
        String secondName = "Doe";
        String passport = "A123Z4569";
        int securityCode = 123;
        String cardNumber = "1234567891052378";
        String phoneNumber = "0458353974";
        int age = 42;

        String expectedEmail = "janedoe@gmail.com";
        String expectedFirstName ="Jane";
        String expectedSecondName = "Doe";
        String expectedPassport = "A123Z4569";
        int expectedSecurityCode = 123;
        String expectedCardNumber = "1234567891052378";
        String expectedPhoneNumber = "0458353974";
        int expectedAge = 42;
        String[] expectedGender = {"Male","Female","Other"};

        passenger.setEmail(email);
        assertEquals(expectedEmail,passenger.getEmail());
        passenger.setFirstName(firstName);
        assertEquals(expectedFirstName,passenger.getFirstName());
        passenger.setSecondName(secondName);
        assertEquals(expectedSecondName,passenger.getSecondName());
        passenger.setPassport(passport);
        assertEquals(expectedPassport,passenger.getPassport());
        passenger.setSecurityCode(securityCode);
        assertEquals(expectedSecurityCode,passenger.getSecurityCode());
        passenger.setCardNumber(cardNumber);
        assertEquals(expectedCardNumber,passenger.getCardNumber());
        passenger.setPhoneNumber(phoneNumber);
        assertEquals(expectedPhoneNumber,passenger.getPhoneNumber());
        passenger.setAge(age);
        assertEquals(expectedAge,passenger.getAge());
        passenger.setGender(gender);
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
        assertEquals("First Name can not be empty",exception.getMessage());
    }

    @Test
    void testSecondNameEmpty()
    {
        String secondName = "";
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            passenger.setSecondName(secondName);
        });
        assertEquals("Second Name can not be empty",exception.getMessage());
    }

    @Test
    void testAge()
    {
        int invalidAge = 0;
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            passenger.setAge(invalidAge);
        });
        assertEquals("Please enter valid age",exception.getMessage());
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
        assertEquals("First Name can not be null",exception.getMessage());
    }

    @Test
    void testSecondNameNull()
    {
        String secondName = null;
        Throwable exception = assertThrows(java.lang.NullPointerException.class, () -> {
            passenger.setSecondName(secondName);
        });
        assertEquals("Second Name can not be null",exception.getMessage());
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
        String expectedResultInvalid ="Please enter valid gender";
        String exception = assertThrows(java.lang.IllegalArgumentException.class,() ->{
            passenger.setGender(genderInputInvalid);
        }).getMessage();
        assertEquals(expectedResultInvalid,exception);
    }

    @Test
    void testFirstNameFormat() {
        String FirstNameInputInvalid = "j@n3";
        String expectedResultInvalid ="Please enter valid First Name";
        String exception = assertThrows(java.lang.IllegalArgumentException.class,() ->{
            passenger.setFirstName(FirstNameInputInvalid);
        }).getMessage();
        assertEquals(expectedResultInvalid,exception);
    }

    @Test
    void testSecondNameFormat() {
        String SecondNameInputInvalid = "D03";
        String expectedResultInvalid ="Please enter valid Second Name";
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
        assertEquals("Security Code can not be zero", exception.getMessage());
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
        String expectedResult = "Please enter a valid phone number";
        String exception = assertThrows(java.lang.IllegalArgumentException.class,() ->{
            passenger.setPhoneNumber(phoneNumber);
        }).getMessage();
        assertEquals(expectedResult,exception);
    }

    @Test
    void testEmailPattern()
    {
        String email = "AbC$@.125";
        String expectedResult = "Please enter a valid email address";
        String exception = assertThrows(java.lang.IllegalArgumentException.class,() ->{
            passenger.setEmail(email);
        }).getMessage();
        assertEquals(expectedResult,exception);
    }
    @Test
    void testPassportCharacterLength()
    {
        String passport = "01237A7@710";
        String expectedResult = "Please enter a valid passport number";
        String exception = assertThrows(java.lang.IllegalArgumentException.class,() ->{
            passenger.setPassport(passport);
        }).getMessage();
        assertEquals(expectedResult,exception);
    }
}
