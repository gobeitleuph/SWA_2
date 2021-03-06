package Person;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import Authentication.CredentialType;
import java.time.LocalDate;

class PersonServiceTest {
    private CredentialType credentialType;
    private PersonService personService;
    private PersonType personType;

    private String name;
    private String emailAddress;
    private int phoneNumber;
    private String surname;
    private LocalDate birthday;
    private int year;
    private int month;
    private int day;
    private String credentialIdentifier;

    @BeforeEach
    void setUp() throws Exception{
        personService = new PersonService();
        personType = PersonType.LegalPerson;

        name = "Test";
        emailAddress = "hallo@test.com";
        phoneNumber = 012711111111;
        credentialType = CredentialType.UserNamePasswordStrategy;
        surname = "SurnameTest";
        year = 2021;
        month = 9;
        day = 7;
        birthday = LocalDate.of(year, month, day);
        credentialIdentifier = "goodPassword";

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Order(1)
    void canPersonBeCreated(){
        Assertions.assertTrue(personService.createPerson(personType, name, emailAddress, phoneNumber, credentialType, surname, birthday, credentialIdentifier));
    }
}