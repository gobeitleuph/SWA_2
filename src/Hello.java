import Authentication.CredentialType;
import Booking.*;
import Payment.PaymentService;
import Person.Person;
import Person.PersonType;
import Resource.Car;
import Resource.ResourceSelection;
import ViewController.CommandController;
import ViewController.CommandExecutor;
import ViewController.PersonController;
import ViewController.ResourceController;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Hello {



    public static void main(String[] args) {
        ////////////////////Person////////////////////
        CredentialType credentialType;
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

        CommandExecutor commandExecutor = new CommandExecutor();
        CommandController perscon1 = new PersonController(personType, name, emailAddress, phoneNumber, credentialType, surname, birthday, credentialIdentifier);
        commandExecutor.executeCommand("createPerson", perscon1);
        Person pers1 = ((PersonController) perscon1).getPerson();
        commandExecutor.executeCommand("createPerson", new PersonController(PersonType.LegalPerson, "Test", "hallo@test.com", 012711111111, CredentialType.UserNamePasswordStrategy, "SurnameTest", LocalDate.of(200, 8, 12), "goodPassword"));

        ////////////////////Person End////////////////////

        ////////////////////Resource////////////////////
        String carLabel = "Carname";
        BigDecimal carprice = new BigDecimal("500");
        Boolean carAvailability = true;

        ResourceSelection car;
        car = new Car();
        car.setLabel(carLabel);
        car.setPrice(carprice);
        car.setAvailability(carAvailability);
        CommandController rescon1 = new ResourceController(car);
        //commandExecutor.executeCommand("createResourceCar",rescon1);
        //ResourceSelection car1 = ((ResourceController) rescon1).getCar();
        commandExecutor.executeCommand("selectResourceChildSeat",rescon1);
        ResourceSelection res1 = ((ResourceController) rescon1).getCombination();
        CommandController rescon2 = new ResourceController(res1);
        commandExecutor.executeCommand("selectResourceSetTopBox",rescon2);
        ResourceSelection res2 = ((ResourceController) rescon2).getCombination();
        System.out.println(res1.getLabel());
        System.out.println(res1.getPrice());
        System.out.println(res2.getLabel());
        System.out.println(res2.getPrice());



        ////////////////////Resource End////////////////////


        PaymentService pms = new PaymentService();

        //////////////////////
        // Person



        BookingService bd1 = new BookingService(pers1,res1);

        EnglishBookingBuilder engbb = new EnglishBookingBuilder();

        bd1.createEnglishBooking(engbb);

        EnglishBooking engB = engbb.getResult();

        System.out.println("\nEnglsih Booking built:\n" + engB.print());

    }
}
