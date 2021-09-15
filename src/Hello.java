import Authentication.CredentialType;
import Booking.*;
import Content.Content;
import Content.File;
import Content.Folder;
import Payment.Payment;
import Payment.PaymentService;
import Payment.PaymentType;
import Person.Person;
import Person.PersonType;
import Resource.Car;
import Resource.Resource;
import Resource.ResourceSelection;
import ViewController.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hello {

    public static void main(String[] args) {

        AuthenticationDialog authenticationDialog = new AuthenticationDialog();
        BookingDialog bookingDialog = new BookingDialog();
        ContentDialog contentDialog = new ContentDialog();
        PaymentDialog paymentDialog = new PaymentDialog();
        PersonDialog personDialog = new PersonDialog();
        ResourceDialog resourceDialog = new ResourceDialog();
        StatisticsDialog statisticsDialog = new StatisticsDialog();

        //auth in person
        List<Booking> bookingList = new ArrayList<>();
        List<Content> contentList = new ArrayList<>();
        List<Payment> paymentList = new ArrayList<>();
        List<Person> personList = new ArrayList<>();
        List<ResourceSelection> resourceList = new ArrayList<>();
        //stat ??

        CommandExecutor commandExecutor = new CommandExecutor();

        // Person creation
        CommandController perscon2 = new PersonController(PersonType.LegalPerson, "CarReservationService GmbH", "info@CRS.com", 012711111111, CredentialType.UserNamePasswordStrategy, "", LocalDate.of(01, 01, 01), "goodPassword");
        commandExecutor.executeCommand("createPerson", perscon2);
        Person pers2 = ((PersonController) perscon2).getPerson();
        personList.add(pers2);

        // CAR CREATION
        ResourceSelection car1;
        car1 = new Car();
        car1.setLabel("Small-size car");
        car1.setPrice(new BigDecimal("40"));
        car1.setAvailability(true);
        resourceList.add(car1);
        ResourceSelection car2;
        car2 = new Car();
        car2.setLabel("Mid-size car");
        car2.setPrice(new BigDecimal("70"));
        car2.setAvailability(true);
        resourceList.add(car2);
        ResourceSelection car3;
        car3 = new Car();
        car3.setLabel("Top-size car");
        car3.setPrice(new BigDecimal("100"));
        car3.setAvailability(true);
        resourceList.add(car3);

        //Content
        Folder folderm ;
        Folder folderY = null;

        String year = Integer.toString(LocalDate.now().getYear());
        String targetNameY = year;
        Content resultY = null;
        for (Content c : contentList) {
            if (targetNameY.equals(c.getName())) {
                resultY = c;
                break;
            }
            else{
                folderY = new Folder (year);
                contentList.add(folderY);
            }
        }

        String month = Integer.toString(LocalDate.now().getMonth().getValue());
        String targetNameM = month;
        Content resultM = null;
        for (Content c : ((Folder)folderY).getFolderContentList()) {
            if (targetNameM.equals(c.getName())) {
                resultM = c;
                break;
            }
            else{
                CommandController contcon3 = new ContentController(folderm = new Folder (month), folderY);
                commandExecutor.executeCommand("addContentToFolder",contcon3);
                Content foldBack = ((ContentController) contcon3).getFolder();
                contentList.add(foldBack);
            }
        }


        UserDialog userDialog = new UserDialog();
        //BookingType language = userDialog.selectLanguage();

        String menuOption = "1";
        while (Integer.parseInt(menuOption) != 0){
            menuOption = userDialog.showMenu();

            switch (menuOption){
                case "1":
                    userDialog.carReservationDialog(bookingList,contentList,paymentList,personList,resourceList);
                    bookingList = userDialog.getBookingList();
                    contentList = userDialog.getContentList();
                    paymentList = userDialog.getPaymentList();
                    personList = userDialog.getPersonList();
                    resourceList = userDialog.getResourceList();
                    break;
                case "21":
                    boolean idResult = authenticationDialog.dataInput(personList);
                    break;
                case "22":
                    authenticationDialog.dataDelete(personList);
                    break;
                case "23":
                    authenticationDialog.dataOutput(personList);
                    break;
                case "31":
                    bookingDialog.dataInput(bookingList,personList,resourceList);
                    break;
                case "32":
                    bookingDialog.dataDelete(bookingList);
                    break;
                case "33":
                    bookingDialog.dataOutput(bookingList);
                    break;
                case "41":
                    contentDialog.dataInput(contentList);
                    break;
                case "42":
                    contentDialog.dataDelete(contentList);
                    break;
                case "43":
                    contentDialog.dataOutput(contentList);
                    break;
                case "51":
                    paymentList = paymentDialog.dataInput(paymentList,personList);
                    personList = paymentDialog.getPersonList();
                    break;
                case "52":
                    paymentList = paymentDialog.dataDelete(paymentList);
                    break;
                case "53":
                    paymentDialog.dataOutput(paymentList);
                    break;
                case "61":
                    personList = personDialog.dataInput(personList);
                    break;
                case "62":
                    personList = personDialog.dataDelete(personList);
                    break;
                case "63":
                    personDialog.dataOutput(personList);
                    break;
                case "71":
                    resourceList = resourceDialog.dataInput(resourceList);
                    break;
                case "72":
                    resourceList = resourceDialog.dataDelete(resourceList);
                    break;
                case "73":
                    resourceDialog.dataOutput(resourceList);
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
        }
//
//        ////////////////////Person////////////////////
//        CredentialType credentialType;
//        PersonType personType;
//        String name;
//        String emailAddress;
//        int phoneNumber;
//        String surname;
//        LocalDate birthday;
//        int yearr;
//        int monthh;
//        int day;
//        String credentialIdentifier;
//
//        personType = PersonType.LegalPerson;
//        name = "Test";
//        emailAddress = "hallo@test.com";
//        phoneNumber = 012711111111;
//        credentialType = CredentialType.UserNamePasswordStrategy;
//        surname = "SurnameTest";
//        yearr = 2021;
//        monthh = 9;
//        day = 7;
//        birthday = LocalDate.of(yearr, monthh, day);
//        credentialIdentifier = "goodPassword";
//        CommandController perscon1 = new PersonController(personType, name, emailAddress, phoneNumber, credentialType, surname, birthday, credentialIdentifier);
//        commandExecutor.executeCommand("createPerson", perscon1);
//        Person pers1 = ((PersonController) perscon1).getPerson();
//        CommandController perscon3 = new PersonController(PersonType.LegalPerson, "NameTest", "hallo@test.com", 012711111111, CredentialType.UserNamePasswordStrategy, "SurnameTest", LocalDate.of(200, 8, 12), "goodPassword");
//        commandExecutor.executeCommand("createPerson", perscon3);
//        Person pers3 = ((PersonController) perscon2).getPerson();
//        System.out.println(pers1.getName());
//        System.out.println(pers3.getName());
//        ////////////////////Person End////////////////////
//
//        ////////////////////Resource////////////////////
//        String carLabel = "Carname";
//        BigDecimal carprice = new BigDecimal("500");
//        Boolean carAvailability = true;
//
//        ResourceSelection car;
//        car = new Car();
//        car.setLabel(carLabel);
//        car.setPrice(carprice);
//        car.setAvailability(carAvailability);
//        CommandController rescon1 = new ResourceController(car);
//        commandExecutor.executeCommand("selectResourceChildSeat",rescon1);
//        ResourceSelection res1 = ((ResourceController) rescon1).getCombination();
//        CommandController rescon2 = new ResourceController(res1);
//        commandExecutor.executeCommand("selectResourceSetTopBox",rescon2);
//        ResourceSelection res2 = ((ResourceController) rescon2).getCombination();
//        System.out.println(res1.getLabel());
//        System.out.println(res1.getPrice());
//        System.out.println(res2.getLabel());
//        System.out.println(res2.getPrice());
//        System.out.println(res2.getAvailability());
//        ////////////////////Resource End////////////////////
//
//        ////////////////////Payment////////////////////
//        PaymentType paymentType;
//        Person personSender;
//        Person personReceiver;
//        int value;
//        //String credentialIdentifierInput;
//        paymentType = PaymentType.PayPal;
//        personSender = pers1;
//        personReceiver = pers2;
//        value = 500;
//        //credentialIdentifierInput = "goodPassword";
//
//        CommandController paycon1 = new PaymentController(paymentType, personSender, personReceiver, value);
//        commandExecutor.executeCommand("transactPayment",paycon1);
//
//        ////////////////////Payment End////////////////////
//
//        ////////////////////Booking////////////////////
//        BookingType bookingType = BookingType.GermanBooking;
//        CommandController bookcon1 = new BookingController(pers1, res1, bookingType);
//        commandExecutor.executeCommand("creatBooking",bookcon1);
//        Booking booking1 = ((BookingController) bookcon1).getBooking();
//
//        System.out.println(booking1.print());
//        ////////////////////Booking End////////////////////
//
//        ////////////////////Content////////////////////
//        Folder folder1 = new Folder("TestFolder");
//        File file1 = new File("TestFile");
//        //File kann Payment und Booking zugewiesen werden
//        CommandController contcon1 = new ContentController(file1, folder1);
//        commandExecutor.executeCommand("addContentToFolder",contcon1);
//        Content fold1 = ((ContentController) contcon1).getFolder();
//        System.out.println(fold1.getName());
//        List<Content> folde1list = ((Folder)fold1).getFolderContentList();
//        //System.out.println(folde1list);
//        ////////////////////Content End////////////////////
//
//        //Authentication//
//        String credentialIdentifierInput = "goodPassword";
//        CommandController authcon1 = new AuthenticationController(pers1, credentialIdentifierInput);
//        commandExecutor.executeCommand("authenticatePerson",authcon1);
//        boolean authResult = ((AuthenticationController) authcon1).getAuthentication();


    }




}
