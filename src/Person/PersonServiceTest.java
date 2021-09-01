package Person;

import org.junit.jupiter.api.*;


class PersonServiceTest {
    private PersonService personService;
    private PersonType personType;

    @BeforeEach
    void setUp() throws Exception{
        personService = new PersonService();
        personType = PersonType.LegalPerson;


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Order(1)
    void canPersonBeCreated(){
        Assertions.assertTrue(personService.addPerson(personType));
    }
}