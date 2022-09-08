import fit5171.monash.edu.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Test class for person")
public class PersonTest {
    private Person person;
    @BeforeAll
    static void initAll(){
        PersonTest personTest = new PersonTest();
    }
    @BeforeEach
    void init(){
        person = new Person();
    }

    @Test
    void testFirstNameEmpty()
    {
        String firstName = "";
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            person.setFirstName(firstName);
        });
        assertEquals("First Name can not be empty",exception.getMessage());
    }

    @Test
    void testSecondNameEmpty()
    {
        String secondName = "";
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            person.setSecondName(secondName);
        });
        assertEquals("Second Name can not be empty",exception.getMessage());
    }

    @Test
    void testAge()
    {
        int age = 0;
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            person.setAge(age);
        });
        assertEquals("Age can not be zero",exception.getMessage());
    }

    @Test
    void testGenderEmpty()
    {
        String gender= "";
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            person.setGender(gender);
        });
        assertEquals("Gender can not be empty",exception.getMessage());
    }

    @Test
    void testGenderOptions() {
        String genderInputValid = "Female";
        String genderInputInvalid = "abc";

        String expectedResultValid ="Female";
        String expectedResultInvalid ="Invalid Input";

        person.setGender(genderInputValid);
        assertEquals(expectedResultValid,person.getGender());

        person.setGender(genderInputInvalid);
        assertEquals(expectedResultInvalid,person.getGender());
    }
    @Test
    void testValidationOfFirstName() {
        String FirstNameInputValid = "Jane";
        String FirstNameInputInvalid = "j@n3";

        String expectedResultValid ="";
        String expectedResultInvalid ="";


        person.setFirstName(FirstNameInputValid);
        assertEquals(expectedResultValid,person.getFirstName());

        person.setFirstName(FirstNameInputInvalid);
        assertEquals(expectedResultInvalid,person.getFirstName());
    }

    @Test
    void testValidationOfSecondName() {
        String SecondNameInputValid = "Doe";
        String SecondNameInputInvalid = "D03";

        String expectedResultValid ="";
        String expectedResultInvalid ="";


        person.setFirstName(SecondNameInputValid);
        assertEquals(expectedResultValid,person.getSecondName());

        person.setFirstName(SecondNameInputInvalid);
        assertEquals(expectedResultInvalid,person.getSecondName());
    }
}

