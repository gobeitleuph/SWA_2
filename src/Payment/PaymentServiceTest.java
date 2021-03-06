package Payment;

import Authentication.CredentialType;
import Person.Person;
import Person.PersonService;
import Person.PersonType;
import org.junit.jupiter.api.*;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    private PaymentService pms;
    private Person ps1;
    private Person ps2;
    private PaymentType type = PaymentType.PayPalDE;
    //private String pcredentialIdentifierInput ="goodPassword";
    PersonService personService;
    @BeforeEach
    void setUp() {

        personService = new PersonService();

        personService.createPerson(PersonType.LegalPerson, "Test", "hallo@test.com", 012711111111, CredentialType.UserNamePasswordStrategy, "SurnameTest", LocalDate.of(200, 8, 12),"goodPassword");
        ps1 = personService.getPerson();

        personService.createPerson(PersonType.LegalPerson, "Test2", "hallo2@test.com", 22222222, CredentialType.UserNamePasswordStrategy, "SurnameTest2", LocalDate.of(200, 8, 12),"goodPassword");

        ps2 = personService.getPerson();

        pms = new PaymentService();

    }

    @Test
    void canPaymentBeCompleted(){

        Assertions.assertTrue(pms.payAmount(type, ps1, ps2, 200));


    }

}