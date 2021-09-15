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


        UserDialog userDialog = new UserDialog();
        BookingType language = userDialog.selectLanguage();
        String menuOption = userDialog.showMenu(language);
        AuthenticationDialog authenticationDialog = new AuthenticationDialog();
        BookingDialog bookingDialog = new BookingDialog();
        ContentDialog contentDialog = new ContentDialog();
        PaymentDialog paymentDialog = new PaymentDialog();
        PersonDialog personDialog = new PersonDialog();
        ResourceDialog resourceDialog = new ResourceDialog();
        StatisticsDialog statisticsDialog = new StatisticsDialog();


        switch (menuOption){
            case "1":
                userDialog.carReservationDialog(language);
                break;
            case "21":
                authenticationDialog.dataInput();
                break;
            case "22":
                authenticationDialog.dataDelete();
                break;
            case "23":
                authenticationDialog.dataOutput();
                break;
            case "31":
                bookingDialog.dataInput();
                break;
            case "32":
                bookingDialog.dataDelete();
                break;
            case "33":
                bookingDialog.dataOutput();
                break;
            case "41":
                contentDialog.dataInput();
                break;
            case "42":
                contentDialog.dataDelete();
                break;
            case "43":
                contentDialog.dataOutput();
                break;
            case "51":
                paymentDialog.dataInput();
                break;
            case "52":
                paymentDialog.dataDelete();
                break;
            case "53":
                paymentDialog.dataOutput();
                break;
            case "61":
                personDialog.dataInput();
                break;
            case "62":
                personDialog.dataDelete();
                break;
            case "63":
                personDialog.dataOutput();
                break;
            case "71":
                resourceDialog.dataInput();
                break;
            case "72":
                resourceDialog.dataDelete();
                break;
            case "73":
                resourceDialog.dataOutput();
                break;
            case "81":
                statisticsDialog.dataInput();
                break;
            case "82":
                statisticsDialog.dataDelete();
                break;
            case "83":
                statisticsDialog.dataOutput();
                break;

        }

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

        ////////////////////Booking////////////////////
        BookingType bookingType = BookingType.GermanBooking;
        CommandController bookcon1 = new BookingController(pers1, res1, bookingType);
        commandExecutor.executeCommand("creatBooking",bookcon1);
        Booking booking1 = ((BookingController) bookcon1).getBooking();

        System.out.println(booking1.print());
        ////////////////////Booking End////////////////////

        ////////////////////Content////////////////////
        Folder folder1 = new Folder("TestFolder");
        File file1 = new File("TestFile");
        //File kann Payment und Booking zugewiesen werden
        CommandController contcon1 = new ContentController(file1, folder1);
        commandExecutor.executeCommand("addContentToFolder",contcon1);
        Content fold1 = ((ContentController) contcon1).getFolder();
        System.out.println(fold1.getName());
        List<Content> folde1list = ((Folder)fold1).getFolderContentList();
        //System.out.println(folde1list);
        ////////////////////Content End////////////////////


    }





}
