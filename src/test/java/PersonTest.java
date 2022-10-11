import assignment.monash.edu.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

    @DisplayName("Test class for person")
    class PersonTest {
    private Person person;

    @BeforeEach
    void init(){
        person = new Person();
    }

    @Test
    void constructorTestValid(){
        Person newPerson = new Person("Jane", "Doe", 43, "Female");
        String expectedResult = "Person{firstName='Jane', secondName='Doe', age=43, gender='Female'}";
        assertEquals(expectedResult, newPerson.toString());
    }

    @Test
    void constructorTestInvalid(){
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            Person newPerson = new Person("", "", 43, "Female");
        });
        String expectedResult = "Invalid details";
        assertEquals(expectedResult, exception.getMessage());
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
        assertEquals("Invalid details",exception.getMessage());
    }

    @Test
    void testSecondNameEmpty()
    {
        String secondName = "";
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            person.setSecondName(secondName);
        });
        assertEquals("Invalid details",exception.getMessage());
    }

    @Test
    void testAge()
    {
        int invalidAge = 0;
        Throwable exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            person.setAge(invalidAge);
        });
        assertEquals("Invalid age",exception.getMessage());
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
        assertEquals("Invalid details",exception.getMessage());
    }

    @Test
    void testSecondNameNull()
    {
        String secondName = null;
        Throwable exception = assertThrows(java.lang.NullPointerException.class, () -> {
            person.setSecondName(secondName);
        });
        assertEquals("Invalid details",exception.getMessage());
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
        String expectedResultInvalid ="Invalid gender";
        String exception = assertThrows(java.lang.IllegalArgumentException.class,() ->{
            person.setGender(genderInputInvalid);
        }).getMessage();
        assertEquals(expectedResultInvalid,exception);
    }

    @Test
    void testFirstNameFormat() {
        String FirstNameInputInvalid = "j@n3";
        String expectedResultInvalid ="Invalid First Name";
        String exception = assertThrows(java.lang.IllegalArgumentException.class,() ->{
            person.setFirstName(FirstNameInputInvalid);
        }).getMessage();
        assertEquals(expectedResultInvalid,exception);
    }

    @Test
    void testSecondNameFormat() {
        String SecondNameInputInvalid = "D03";
        String expectedResultInvalid ="Invalid details";
        String exception = assertThrows(java.lang.IllegalArgumentException.class,() ->{
            person.setSecondName(SecondNameInputInvalid);
        }).getMessage();
        assertEquals(expectedResultInvalid,exception);
    }

    @Test
    void testToString()
    {
        Person person = new Person("Jane","Doe", 43,"Female");
        String expectedString = "Person{firstName='Jane', secondName='Doe', age=43, gender='Female'}";
        assertEquals(expectedString,person.toString());
    }

}

