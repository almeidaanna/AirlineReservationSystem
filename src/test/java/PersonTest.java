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
    void testPersonValidity()
    {
        String firstName = "Jane";
        String secondName = "Doe";
        int age = 42;
        String gender = "Female";

        String expectedFirstName ="Jane";
        String expectedSecondName = "Doe";
        int expectedAge = 42;
        String expectedGender = "Female";

        person.setFirstName(firstName);
        assertEquals(expectedFirstName,person.getFirstName());
        person.setSecondName(secondName);
        assertEquals(expectedSecondName,person.getSecondName());
        person.setAge(age);
        assertEquals(expectedAge,person.getAge());
        person.setGender(gender);
        assertEquals(expectedGender,person.getGender());
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
        int invalidAge = 0;
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            person.setAge(invalidAge);
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
    void testFirstNameNull()
    {
        String firstName = null;
        Throwable exception = assertThrows(java.lang.NullPointerException.class, () -> {
            person.setFirstName(firstName);
        });
        assertEquals("First Name can not be empty",exception.getMessage());
    }

    @Test
    void testSecondNameNull()
    {
        String secondName = null;
        Throwable exception = assertThrows(java.lang.NullPointerException.class, () -> {
            person.setSecondName(secondName);
        });
        assertEquals("Second Name can not be empty",exception.getMessage());
    }

    @Test
    void testGenderNull()
    {
        String gender= null;
        Throwable exception = assertThrows(java.lang.NullPointerException.class, () -> {
            person.setGender(gender);
        });
        assertEquals("Gender can not be empty",exception.getMessage());
    }

    @Test
    void testGenderOptions() {

        String genderInputInvalid = "abc";
        String expectedResultInvalid ="Invalid Input";
        person.setGender(genderInputInvalid);
        assertEquals(expectedResultInvalid,person.getGender());
    }

    @Test
    void testFirstNameFormat() {
        String FirstNameInputInvalid = "j@n3";
        String expectedResultInvalid ="";
        person.setFirstName(FirstNameInputInvalid);
        assertEquals(expectedResultInvalid,person.getFirstName());
    }

    @Test
    void testSecondNameFormat() {
        String SecondNameInputInvalid = "D03";
        String expectedResultInvalid ="";
        person.setFirstName(SecondNameInputInvalid);
        assertEquals(expectedResultInvalid,person.getSecondName());
    }
}

