package Person;

import Authentication.Credential;
import Authentication.CredentialType;
import org.junit.jupiter.api.*;

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
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    @Order(1)
    void canPersonBeCreated(){

        Assertions.assertTrue(personService.createPerson(personType, name, emailAddress, phoneNumber, credentialType, surname, birthday));
    }
}