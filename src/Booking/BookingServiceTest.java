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


    BookingService bd1;
    EnglishBookingBuilder engbb;
    Resource res1;
    ResourceService resourceService;
    @BeforeEach
    void setUp() throws Exception{


        PersonService personService = new PersonService();

        personService.createPerson(PersonType.LegalPerson, "Test", "hallo@test.com", 012711111111, CredentialType.UserNamePasswordStrategy, "SurnameTest", LocalDate.of(200, 8, 12),"goodPassword");


        Person ps1 = personService.getPerson();


        ///Person
        ///////////
        //Resource
        resourceService = new ResourceService();


        resourceService.getSelectedResource("label",new BigDecimal("500"),true);

        res1 = resourceService.getResource();

        //////////////

        bd1 = new BookingService(ps1,res1);

        engbb = new EnglishBookingBuilder();

        bd1.createEnglishBooking(engbb);

        EnglishBooking engB = engbb.getResult();

        System.out.println(engB.print());

    }

    @Test
    void testFinalize() {
    }



    @Test
    void createEnglishBooking() {

        Assertions.assertTrue(bd1.createEnglishBooking(engbb));

    }




}