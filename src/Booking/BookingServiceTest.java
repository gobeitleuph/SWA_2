package Booking;

import Authentication.CredentialType;
import Person.Person;
import Person.PersonService;
import Person.PersonType;
import Resource.*;
import Resource.ResourceService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.descriptor.FileSystemSource;

import java.math.BigDecimal;
import java.time.LocalDate;

class BookingServiceTest {


    private BookingService bd1;
    //private EnglishBookingBuilder engbb;
    private ResourceSelection car;
    ResourceSelection res1;

    @BeforeEach
    void setUp() throws Exception{

        ///Person///
        PersonService personService = new PersonService();
        personService.createPerson(PersonType.LegalPerson, "Test", "hallo@test.com", 012711111111, CredentialType.UserNamePasswordStrategy, "SurnameTest", LocalDate.of(200, 8, 12),"goodPassword");
        Person ps1 = personService.getPerson();
        ///////
        //Resource//
        car = new Car();
        car.setLabel("TestLabel");
        car.setPrice(new BigDecimal("100"));
        car.setAvailability(true);
        ResourceService resourceService = new ResourceService();
        resourceService.getSelectedResource("label",new BigDecimal("500"),true, car);
        res1 = resourceService.getResource();

        ///////

        bd1 = new BookingService(ps1,res1);

    }

    @Test
    void testFinalize() {
    }


    @Test
    void createEnglishBooking() {

        Assertions.assertTrue(bd1.createBooking(BookingType.GermanBooking));
        String temp = bd1.getBooking().print();
        System.out.println(temp);

    }

}