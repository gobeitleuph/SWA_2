package Authentication;

import Person.Person;
import Person.PersonService;
import Person.PersonType;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationServiceTest {
    private AuthenticationService authenticationService;
    private Person person;
    private String credentialIdentifierInput;


    @BeforeEach
    void setUp() throws Exception{
        authenticationService = new AuthenticationService();
        PersonService personService = new PersonService();
        personService.createPerson(PersonType.LegalPerson, "Test", "hallo@test.com", 012711111111, CredentialType.EyeScanStrategy, "SurnameTest", LocalDate.of(200, 8, 12),"goodPassword");
        person = personService.getPerson();
        credentialIdentifierInput = "goodPassword";

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Order(1)
    void canPersonBeAuthenticated(){
        Assertions.assertTrue(authenticationService.authenticateSubject(person, credentialIdentifierInput));
    }
}