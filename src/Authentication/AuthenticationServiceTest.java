package Authentication;

import Person.Person;
import Person.PersonService;
import Person.PersonType;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationServiceTest {
    private AuthenticationService authenticationService;
    private Person subject;


    @BeforeEach
    void setUp() throws Exception{
        authenticationService = new AuthenticationService();
        PersonService personService = new PersonService();
        personService.createPerson(PersonType.LegalPerson, "Test", "hallo@test.com", 012711111111, CredentialType.EyeScanStrategy, "SurnameTest", LocalDate.of(200, 8, 12),"goodPassword");
        subject = personService.getPerson();


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Order(1)
    void canPersonBeAuthenticated(){
        Assertions.assertTrue(authenticationService.authenticateSubject(subject));
    }
}