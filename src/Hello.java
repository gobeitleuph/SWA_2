import Authentication.CredentialType;
import Booking.*;
import Person.Person;
import Person.PersonService;
import Person.PersonType;
import Resource.Resource;
import Resource.ResourceService;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Hello {



    public static void main(String[] args) {
        System.out.println("hello");
        System.out.println("test1");
// Person
        ////////////////////
        CredentialType credentialType;
        PersonService personService;
        PersonType personType;

        String name;
        String emailAddress;
        int phoneNumber;
        String surname;
        LocalDate birthday;
        int year;
        int month;
        int day;
        String credentialIdentifier;

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

        personService.createPerson(personType, name, emailAddress, phoneNumber, credentialType, surname, birthday, credentialIdentifier);

        personService.createPerson(PersonType.LegalPerson, "Test", "hallo@test.com", 012711111111, CredentialType.UserNamePasswordStrategy, "SurnameTest", LocalDate.of(200, 8, 12), "goodPassword");
        Person ps1 = personService.getPerson();

        //////////////////////
        // Person

        //Resource
        ///////////////////
        ResourceService resourceService = new ResourceService();
        resourceService.getSelectedResource("label",new BigDecimal("500"),true);
        Resource res1 = resourceService.getResource();
        /////////

        BookingService bd1 = new BookingService(ps1,res1);

        EnglishBookingBuilder engbb = new EnglishBookingBuilder();

        bd1.createEnglishBooking(engbb);

        EnglishBooking engB = engbb.getResult();

        System.out.println("\nEnglsih Booking built:\n" + engB.print());

    }
}
