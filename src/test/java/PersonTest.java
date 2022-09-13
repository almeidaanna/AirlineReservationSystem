import fit5171.monash.edu.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

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

    @ParameterizedTest
    @ValueSource(strings = {"Male","Female","Other"})
    void testPersonValidity(String expectedGender)
    {
        String expectedFirstName ="Jane";
        String expectedSecondName = "Doe";
        int expectedAge = 42;

        person.setFirstName(expectedFirstName);
        assertEquals(expectedFirstName,person.getFirstName());
        person.setSecondName(expectedSecondName);
        assertEquals(expectedSecondName,person.getSecondName());
        person.setAge(expectedAge);
        assertEquals(expectedAge,person.getAge());
        person.setGender(expectedGender);
        assertTrue(Arrays.asList(expectedGender).contains(person.getGender()));
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
        assertEquals("Please enter valid age",exception.getMessage());
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
        assertEquals("First Name can not be null",exception.getMessage());
    }

    @Test
    void testSecondNameNull()
    {
        String secondName = null;
        Throwable exception = assertThrows(java.lang.NullPointerException.class, () -> {
            person.setSecondName(secondName);
        });
        assertEquals("Second Name can not be null",exception.getMessage());
    }

    @Test
    void testGenderNull()
    {
        String gender= null;
        Throwable exception = assertThrows(java.lang.NullPointerException.class, () -> {
            person.setGender(gender);
        });
        assertEquals("Gender can not be null",exception.getMessage());
    }

    @Test
    void testGenderOptions() {

        String genderInputInvalid = "abc";
        String expectedResultInvalid ="Please enter valid gender";
        String exception = assertThrows(java.lang.IllegalArgumentException.class,() ->{
            person.setGender(genderInputInvalid);
        }).getMessage();
        assertEquals(expectedResultInvalid,exception);
    }

    @Test
    void testFirstNameFormat() {
        String FirstNameInputInvalid = "j@n3";
        String expectedResultInvalid ="Please enter valid First Name";
        String exception = assertThrows(java.lang.IllegalArgumentException.class,() ->{
            person.setFirstName(FirstNameInputInvalid);
        }).getMessage();
        assertEquals(expectedResultInvalid,exception);
    }

    @Test
    void testSecondNameFormat() {
        String SecondNameInputInvalid = "D03";
        String expectedResultInvalid ="Please enter valid Second Name";
        String exception = assertThrows(java.lang.IllegalArgumentException.class,() ->{
            person.setSecondName(SecondNameInputInvalid);
        }).getMessage();
        assertEquals(expectedResultInvalid,exception);
    }
}

