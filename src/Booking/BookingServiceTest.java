package Booking;

import Authentication.CredentialType;
import Person.Person;
import Person.PersonService;
import Person.PersonType;
import Resource.*;
import Resource.ResourceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

class BookingServiceTest {


    private BookingService bd1;
    private EnglishBookingBuilder engbb;
    private ResourceSelection car;

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
        ResourceSelection res1 = resourceService.getResource();
        resourceService.getSelectedResource("label",new BigDecimal("500"),true, car);
        ///////

        bd1 = new BookingService(ps1,res1);

        engbb = new EnglishBookingBuilder();

        bd1.createEnglishBooking(engbb);

        EnglishBooking engB = engbb.getResult();

    }

    @Test
    void testFinalize() {
    }



    @Test
    void createEnglishBooking() {

        Assertions.assertTrue(bd1.createEnglishBooking(engbb));

    }




}