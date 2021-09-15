import Authentication.CredentialType;
import Booking.Booking;
import Booking.BookingType;
import Content.Content;
import Payment.Payment;
import Payment.PaymentType;
import Person.Person;
import Resource.ResourceSelection;
import Statistics.PaymentVisitor;
import ViewController.*;
import Person.PersonType;
import Content.File;
import Content.Folder;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class UserDialog {
    private BookingType languageType;
    private String mainMenuOption;
    private String otherMenuoption;
    private CommandExecutor commandExecutor;

    public UserDialog() {
        this.commandExecutor = new CommandExecutor();
    }

    public String showMenu(){

//        switch (language){
//            case EnglishBooking :{
                System.out.println("Please select a number:\n1 Car Reservation Service\n2 Options Authentication\n3 Options Booking\n4 Options Content\n5 Options Payment\n6 Options Person\n7 Options Resource\n8 Options Statistics\n0 End");
                Scanner scanner = new Scanner(System.in);
                this.mainMenuOption = scanner.next();
//                break;
//            }
//            case GermanBooking:{
//                System.out.println("Bitte Nummer wählen:\n1 Car Reservation Service\n2 Optionen Authentifizierung\n3 Optionen Buchung\n4 Optionen Inhalt\n5 Optionen Bezahlung\n6 Optionen Person\n7 Optionen Ressource\n8 Optionen Statistik ");
//                Scanner scanner = new Scanner(System.in);
//                this.mainMenuOption = scanner.next();
//                break;
//            }
//        }
        switch (mainMenuOption){
            case "1":{
                this.otherMenuoption ="1";
                break;
            }
            case "2":{
                AuthenticationDialog authenticationDialog = new AuthenticationDialog();
                this.otherMenuoption = authenticationDialog.showMenu();

                break;
            }
            case "3":{
                BookingDialog bookingDialog = new BookingDialog();
                this.otherMenuoption = bookingDialog.showMenu();
                break;
            }
            case "4":{
                ContentDialog contentDialog = new ContentDialog();
                this.otherMenuoption = contentDialog.showMenu();
                break;
            }
            case "5":{
                PaymentDialog paymentDialog = new PaymentDialog();
                this.otherMenuoption = paymentDialog.showMenu();
                break;
            }
            case "6":{
                PersonDialog personDialog = new PersonDialog();
                this.otherMenuoption = personDialog.showMenu();
                break;
            }
            case "7":{
                ResourceDialog resourceDialog = new ResourceDialog();
                this.otherMenuoption = resourceDialog.showMenu();
                break;
            }
            case "8":{
                StatisticsDialog statisticsDialog = new StatisticsDialog();
                this.otherMenuoption = statisticsDialog.showMenu();
                break;
            }case "0":{
                this.otherMenuoption = "0";
                break;
            }
            default:{
                throw new IllegalStateException("Input not known! Please try again" );
            }
        }
        return otherMenuoption;
    }

    public BookingType selectLanguage(){
        System.out.println("Please select a language by typing the number of your chosen option.\nBiite wählen Sie eine Sprache aus, durch Eingabe der Nummer Ihrer gewaehlen Option.\n Option 1: English \n Option 2: Deutsch");
        Scanner scanner = new Scanner(System.in);
        String languageOption = scanner.next();
        switch (languageOption){
            case"1":{
                this.languageType = BookingType.EnglishBooking;
                break;
            }
            case"2":{
                this.languageType = BookingType.GermanBooking;
                break;
            }
            default:{
                throw new IllegalStateException("Input '" + languageOption + "' not known! Please try again" );
            }
        }
        return this.languageType;

    }
    private CredentialType credentialType;
    private PersonType personType;
    private String name;
    private String emailAddress;
    private int phoneNumber;
    private String surname;
    private LocalDate birthday;
    private String credentialIdentifier;
    private BookingType bookingType;
    private ResourceSelection resource1;
    private Person pers1;
    private PaymentType paymentType;

    private List<Booking> bookingList;
    private List<Content> contentList;
    private List<Payment> paymentList;
    private List<Person> personList;
    private List<ResourceSelection> resourceList;



    public void carReservationDialog (List<Booking> bookingList,List<Content> contentListList,List<Payment> paymentList,List<Person> personList,List<ResourceSelection> resourceList){


        System.out.println("Welcome to the Car Reservation Service");
        System.out.println("Please give in some details to your person to continue.");
        System.out.println("Are you a Company or a Person?\n1: Company\n2: Person");
        Scanner scanner = new Scanner(System.in);
        String personTypeInput = scanner.next();
        switch (personTypeInput){
            case"1":{
                this.personType = PersonType.LegalPerson;
                break;
            }
            case"2":{
                this.personType = PersonType.NaturalPerson;
                break;
            }
            default:{
                throw new IllegalStateException("Input not known! Please try again" );
            }
        }
        if (personType == PersonType.NaturalPerson){
            System.out.println("Please enter your Surname");
            Scanner scanner2 = new Scanner(System.in);
            String surnameInput = scanner2.next();
            this.surname = surnameInput;
        }
        System.out.println("Please enter your Name");
        Scanner scanner3 = new Scanner(System.in);
        String nameInput = scanner3.next();
        this.name = nameInput;

        if (personType == PersonType.NaturalPerson){
            System.out.println("Please enter your Birthday dd.mm.yyyy separately:");
            System.out.println("Day:");
            Scanner scanner4 = new Scanner(System.in);
            String dayInput = scanner4.next();
            int day = Integer.parseInt(dayInput);
            System.out.println("Month:");
            Scanner scanner5 = new Scanner(System.in);
            String monthInput = scanner5.next();
            int month = Integer.parseInt(monthInput);
            System.out.println("Year:");
            Scanner scanner6 = new Scanner(System.in);
            String yearInput = scanner6.next();
            int year = Integer.parseInt(yearInput);
            this.birthday = LocalDate.of(year, month, day);

        }
        System.out.println("Please enter your Phone number");
        Scanner scanner7 = new Scanner(System.in);
        String phoneInput = scanner7.next();
        this.phoneNumber = Integer.parseInt(phoneInput);

        System.out.println("Please enter your Email address");
        Scanner scanner9 = new Scanner(System.in);
        String emailInput = scanner9.next();
        this.emailAddress = emailInput;

        System.out.println("Please chose your identification method\n1: Password\n2: EyeScan\n3: Fingerprint");
        Scanner scanner10 = new Scanner(System.in);
        String authInput = scanner10.next();
        switch (authInput){
            case"1":{
                this.credentialType = CredentialType.UserNamePasswordStrategy;
                System.out.println("Please enter a password");
                Scanner scanner11 = new Scanner(System.in);
                String credInput = scanner11.next();
                this.credentialIdentifier = credInput;
                break;
            }
            case"2":{
                this.credentialType = CredentialType.EyeScanStrategy;
                System.out.println("Please look in the camera");
                System.out.println("Sorry the camera is not focusing but you can use this number to authenticate yourself:");
                System.out.println("Please dont loose this number!");
                Random random = new Random();
                int randomInt = random.nextInt(10000);
                this.credentialIdentifier = Integer.toString(randomInt);
                System.out.println(Integer.toString(randomInt));
                break;
            }
            case"3":{
                this.credentialType = CredentialType.FingerPrintStrategy;
                System.out.println("Please put your finger on the camera");
                System.out.println("Sorry the camera is not focusing but you can use this number to authenticate yourself:");
                System.out.println("Please dont loose this number!");
                Random random = new Random();
                int randomInt = random.nextInt(10000);
                this.credentialIdentifier = Integer.toString(randomInt);
                System.out.println(Integer.toString(randomInt));
                break;
            }
        }

        CommandController perscon1 = new PersonController(personType, name, emailAddress, phoneNumber, credentialType, surname, birthday, credentialIdentifier);
        commandExecutor.executeCommand("createPerson", perscon1);
        this.pers1 = ((PersonController) perscon1).getPerson();
        personList.add(pers1);

        ///////////////////// END PERSON START RESOURCE//////////////

        System.out.println("Please enter the number of the car type you want to select");
        for(int i=0; i < resourceList.size(); i++){
            System.out.println(i + " " + resourceList.get(i).getLabel() );
        }
        Scanner scanner2 = new Scanner(System.in);
        String numberInput = scanner2.next();

        ResourceSelection car = resourceList.get(Integer.parseInt(numberInput));

        System.out.println("Do you need any extra equipment?");
        System.out.println("1: Child seat\n2: Set top box\n3: Both\n4: none");
        Scanner scanner31 = new Scanner(System.in);
        String optionsInput = scanner31.next();

        switch (optionsInput){
            case"1":{
                CommandController rescon1 = new ResourceController(car);
                commandExecutor.executeCommand("selectResourceChildSeat",rescon1);
                this.resource1 = ((ResourceController) rescon1).getCombination();
                resourceList.add(resource1);
                break;
            }
            case"2":{
                CommandController rescon2 = new ResourceController(car);
                commandExecutor.executeCommand("selectResourceSetTopBox",rescon2);
                this.resource1 = ((ResourceController) rescon2).getCombination();
                resourceList.add(resource1);
                break;
            }
            case"3":{
                CommandController rescon1 = new ResourceController(car);
                commandExecutor.executeCommand("selectResourceChildSeat",rescon1);
                ResourceSelection res1 = ((ResourceController) rescon1).getCombination();
                CommandController rescon2 = new ResourceController(res1);
                commandExecutor.executeCommand("selectResourceSetTopBox",rescon2);
                this.resource1 = ((ResourceController) rescon2).getCombination();
                resourceList.add(resource1);
                break;
            }case"4":{
                resourceList.add(car);
                this.resource1 = car;
                break;
            }

        }
            //////////////END RESOURCE START AUthenticate////////////

//        System.out.println("Select a person to identify");
//        for(int i=0; i < personList.size(); i++){
//            System.out.println(i + personList.get(i).getName() );
//        }
//        Scanner scanner12 = new Scanner(System.in);
//        String numberInput13 = scanner12.next();
//        Person pers1 = personList.get(Integer.parseInt(numberInput13));

        System.out.println("Please enter the Password for the sending Person");
        Scanner scanner5 = new Scanner(System.in);
        String credentialIdentifierInput = scanner5.next();


        CommandController authcon1 = new AuthenticationController(pers1, credentialIdentifierInput);
        commandExecutor.executeCommand("authenticatePerson",authcon1);
        boolean authResult = ((AuthenticationController) authcon1).getAuthentication();
        if (authResult){
            System.out.println("Authentication successful");
        }else {
            System.out.println("Authentication not successful!");
        }

        //////////////END AAuthenticate START Booking////////////

//        System.out.println("Please select person for booking");
//        for(int i=0; i < personList.size(); i++){
//            System.out.println(i + personList.get(i).getName() );
//        }
//        Scanner scanner12 = new Scanner(System.in);
//        String personNumberInput = scanner12.next();
//        this.person = personList.get(Integer.parseInt(personNumberInput));
//
//        System.out.println("Please select resource for booking");
//        for(int i=0; i < resourceList.size(); i++){
//            System.out.println(i + resourceList.get(i).getLabel() );
//        }
//        Scanner scanner13 = new Scanner(System.in);
//        String resourceNumberInput = scanner13.next();
//        this.resource = resourceList.get(Integer.parseInt(resourceNumberInput));

        System.out.println("Please select a language for the booking\n1: English\n2: German");
        Scanner scanner35 = new Scanner(System.in);
        String languageOption = scanner35.next();
        switch (languageOption){
            case"1":{
                this.bookingType = BookingType.EnglishBooking;
                break;
            }
            case"2":{
                this.bookingType = BookingType.GermanBooking;
                break;
            }
            default:{
                throw new IllegalStateException("Input '" + languageOption + "' not known! Please try again" );
            }
        }

        CommandController bookcon1 = new BookingController(pers1, resource1, bookingType);
        commandExecutor.executeCommand("creatBooking",bookcon1);
        Booking booking1 = ((BookingController) bookcon1).getBooking();
        bookingList.add(booking1);

        //////////////END Booking START Payment////////////

//        System.out.println("Please select the number of the person that should send the amount");
//        for(int i=0; i < personList.size(); i++){
//            System.out.println(i + " " + personList.get(i).getName() );
//        }
//        Scanner scanner22 = new Scanner(System.in);
//        String senderInput = scanner22.next();
//        Person personSender = personList.get(Integer.parseInt(senderInput));


//        System.out.println("Please select the number of the person that receives the amount");
//        for(int i=0; i < personList.size(); i++){
//            System.out.println(i + " " + personList.get(i).getName() );
//        }
//        Scanner scanner33 = new Scanner(System.in);
//        String receiverInput = scanner33.next();
//        Person personReceiver = personList.get(Integer.parseInt(receiverInput));

//        System.out.println("Please enter the amount that should be transacted");
//        Scanner scanner4 = new Scanner(System.in);
//        String amountInput = scanner4.next();
//        int amount = Integer.parseInt(amountInput);


        int amount = resource1.getPrice().intValueExact();
        Person personReceiver = personList.get(0);
        Person personSender = this.pers1;

        System.out.println("Please select a payment type\n1: PayPal\n2: Google Wallet\n3: Mobile Money Wallet");
        Scanner scanner6= new Scanner(System.in);
        String paymentTypeInput = scanner6.next();

        switch (paymentTypeInput){
            case"1":
                this.paymentType = PaymentType.PayPalDE;
                break;
            case"2":
                this.paymentType = PaymentType.GoogleWalletDE;
                break;
            case"3":
                this.paymentType = PaymentType.MobileMoneyWalletDE;
                break;
            case"4":
                this.paymentType = PaymentType.PayPalEN;
                break;
            case"5":
                this.paymentType = PaymentType.GoogleWalletEN;
                break;
            case"6":
                this.paymentType = PaymentType.MobileMoneyWalletEN;
                break;
        }

        CommandController paycon1 = new PaymentController(paymentType, personSender, personReceiver, amount);
        commandExecutor.executeCommand("transactPayment",paycon1);
        Payment pay1 = ((PaymentController) paycon1).getPayment();
        paymentList.add(pay1);

//        int iSender = Integer.parseInt(senderInput);
//        int iReceiver = Integer.parseInt(receiverInput);
//
        personReceiver = ((PaymentController)paycon1).getPersonReceiver();
        personSender = ((PaymentController)paycon1).getPersonSender();


//        personList.set(iSender,((PaymentController)paycon1).getPersonSender());
//        personList.set(iReceiver,((PaymentController)paycon1).getPersonReceiver());
//        this.personListget = personList;

        //////////////END Payment START Content////////////

//        System.out.println("Select folder to add files/folders");
//        for(int i=0; i < contentList.size(); i++){
//            System.out.println(i + contentList.get(i).getName() );
//        }
//        Scanner scanner12 = new Scanner(System.in);
//        String numberInput = scanner12.next();
//        Content folder1 = contentList.get(Integer.parseInt(numberInput));
//
//        System.out.println("Select folder or file that will be added");
//        for(int i=0; i < contentList.size(); i++){
//            System.out.println(i + contentList.get(i).getName() );
//        }
//        Scanner scanner14 = new Scanner(System.in);
//        String contInput = scanner14.next();
//        Content folder2 = contentList.get(Integer.parseInt(contInput));

        File file1 = new File("File01");

        Folder folder1 = ((Folder)contentListList.get(0));
        List<Content> folder2 = folder1.getFolderContentList();
        CommandController contcon1 = new ContentController(file1, ((Folder)folder2));
        commandExecutor.executeCommand("addContentToFolder",contcon1);
        Content fold1 = ((ContentController) contcon1).getFolder();
//        int folderIndex =Integer.parseInt(numberInput);
//        contentList.set(folderIndex,fold1);

        //////////////END Content START Statistics////////////
       // PaymentVisitor pmv = new PaymentVisitor();

    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public List<Content> getContentList() {
        return contentList;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public List<ResourceSelection> getResourceList() {
        return resourceList;
    }


}
