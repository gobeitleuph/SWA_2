package Booking;

import Authentication.CredentialType;
import Person.PersonService;
import Person.PersonType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookingDirectorTest {

    @BeforeEach
    void setUp() throws Exception{
        BookingDirector bd1 = new BookingDirector();

        EnglishBookingBuilder engbb = new EnglishBookingBuilder();

        bd1.createEnglishBooking(engbb);

        EnglishBooking engB = engbb.getResult();

    }

    @Test
    void testFinalize() {
    }

    @Test
    void createGermanBooking() {
        Assertions.assertTrue(bd1.createGermanBooking());
    }

    @Test
    void createEnglishBooking() {
    }

    void canPersonBeCreated(){
        Assertions.assertTrue(personService.createPerson(personType, name, emailAddress, phoneNumber, credentialType, surname, birthday));
    }

}