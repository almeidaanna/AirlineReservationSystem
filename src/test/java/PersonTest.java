import fit5171.monash.edu.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Test class for person")
public class PersonTest {
    private Person person;
    @BeforeAll
    static void initAll(){
        PersonTest personTest = new PersonTest();
    }
}

