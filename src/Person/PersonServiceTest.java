package Person;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


class PersonServiceTest {
    private PersonService personService;
    private PersonTyp personTyp;

    @BeforeEach
    void setUp() throws Exception{
        personService = new PersonService();
        personTyp = PersonTyp.LegalPerson;


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Order(1)
    void canPersonBeCreated(){
        Assertions.assertTrue(personService.createPerson(personTyp));
    }
}