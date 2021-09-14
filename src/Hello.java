import Authentication.CredentialType;
import Booking.*;
import Content.Content;
import Content.File;
import Content.Folder;
import Payment.PaymentService;
import Payment.PaymentType;
import Person.Person;
import Person.PersonType;
import Resource.Car;
import Resource.ResourceSelection;
import ViewController.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Hello {



    public static void main(String[] args) {


        CommandExecutor commandExecutor = new CommandExecutor();


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
        CommandController perscon1 = new PersonController(personType, name, emailAddress, phoneNumber, credentialType, surname, birthday, credentialIdentifier);
        commandExecutor.executeCommand("createPerson", perscon1);
        Person pers1 = ((PersonController) perscon1).getPerson();
        CommandController perscon2 = new PersonController(PersonType.LegalPerson, "NameTest", "hallo@test.com", 012711111111, CredentialType.UserNamePasswordStrategy, "SurnameTest", LocalDate.of(200, 8, 12), "goodPassword");
        commandExecutor.executeCommand("createPerson", perscon2);
        Person pers2 = ((PersonController) perscon2).getPerson();
        System.out.println(pers1.getName());
        System.out.println(pers2.getName());
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
        commandExecutor.executeCommand("selectResourceChildSeat",rescon1);
        ResourceSelection res1 = ((ResourceController) rescon1).getCombination();
        CommandController rescon2 = new ResourceController(res1);
        commandExecutor.executeCommand("selectResourceSetTopBox",rescon2);
        ResourceSelection res2 = ((ResourceController) rescon2).getCombination();
        System.out.println(res1.getLabel());
        System.out.println(res1.getPrice());
        System.out.println(res2.getLabel());
        System.out.println(res2.getPrice());
        System.out.println(res2.getAvailability());
        ////////////////////Resource End////////////////////

        ////////////////////Payment////////////////////
        PaymentType paymentType;
        Person personSender;
        Person personReceiver;
        int value;
        String credentialIdentifierInput;
        paymentType = PaymentType.PayPal;
        personSender = pers1;
        personReceiver = pers2;
        value = 500;
        credentialIdentifierInput = "goodPassword";

        CommandController paycon1 = new PaymentController(paymentType, personSender, personReceiver, value, credentialIdentifierInput);
        commandExecutor.executeCommand("transactPayment",paycon1);

        ////////////////////Payment End////////////////////

        ////////////////////Content////////////////////
        Folder folder1 = new Folder("TestFolder");
        File file1 = new File("TestFile");
        //File kann Payment und Booking zugewiesen werden
        CommandController contcon1 = new ContentController(file1, folder1);
        commandExecutor.executeCommand("addContentToFolder",contcon1);
        Content fold1 = ((ContentController) contcon1).getFolder();
        System.out.println(fold1.getName());
        List<Content> folde1list = ((Folder)fold1).getFolderContentList();

        ////////////////////Content End////////////////////

        BookingService bd1 = new BookingService(pers1,res1);

        EnglishBookingBuilder engbb = new EnglishBookingBuilder();

        bd1.createEnglishBooking(engbb);

        EnglishBooking engB = engbb.getResult();

        System.out.println("\nEnglsih Booking built:\n" + engB.print());

    }
}
