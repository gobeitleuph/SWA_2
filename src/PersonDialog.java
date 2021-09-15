import Authentication.CredentialType;
import Person.Person;
import Person.PersonType;
import ViewController.CommandController;
import ViewController.CommandExecutor;
import ViewController.PersonController;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class PersonDialog {
    private String menuOption;
    private CommandExecutor commandExecutor;

    private CredentialType credentialType;
    private PersonType personType;
    private String name;
    private String emailAddress;
    private int phoneNumber;
    private String surname;
    private LocalDate birthday;
    private String credentialIdentifier;

    public PersonDialog() {
        this.commandExecutor = new CommandExecutor();
    }

    public String showMenu(){
        System.out.println("1: Add Person\n2: Delete Person\n3: View Person");
        Scanner scanner = new Scanner(System.in);
        String selectedOption = scanner.next();
        switch (selectedOption){
            case"1":{
                this.menuOption ="61";
                return menuOption;
            }
            case"2":{
                this.menuOption ="62";
                return menuOption;
            }
            case"3":{
                this.menuOption ="63";
                return menuOption;
            }
            default:{
                throw new IllegalStateException("Input not known! Please try again" );
            }
        }
    }
    public List<Person> dataInput(List<Person> personList){
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
                    Scanner scanner11 = new Scanner(System.in);
                    String credInput = scanner11.next();
                    this.credentialIdentifier = credInput;
                    break;
                }
                case"3":{
                    this.credentialType = CredentialType.FingerPrintStrategy;
                    System.out.println("Please put your finger on the camera");
                    Scanner scanner11 = new Scanner(System.in);
                    String credInput = scanner11.next();
                    this.credentialIdentifier = credInput;
                    break;
                }
            }


        CommandController perscon1 = new PersonController(personType, name, emailAddress, phoneNumber, credentialType, surname, birthday, credentialIdentifier);
        commandExecutor.executeCommand("createPerson", perscon1);
        Person pers1 = ((PersonController) perscon1).getPerson();
        personList.add(pers1);

        return personList;
    }
    public List<Person> dataDelete(List<Person> personList){
        System.out.println("Please enter the number of the person you want to delete");
        for(int i=0; i < personList.size(); i++){
            System.out.println(i + personList.get(i).getName() );
        }
        Scanner scanner12 = new Scanner(System.in);
        String numberInput = scanner12.next();
        personList.remove(Integer.parseInt(numberInput));
        return personList;
    }
    public void dataOutput(List<Person> personList){
        System.out.println("Current Persons");
        for(int i=0; i < personList.size(); i++){
            System.out.println(i + personList.get(i).getName() );
        }
    }
}
