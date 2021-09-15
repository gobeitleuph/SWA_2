import Person.Person;
import ViewController.AuthenticationController;
import ViewController.CommandController;
import ViewController.CommandExecutor;

import java.util.List;
import java.util.Scanner;

public class AuthenticationDialog {
    private CommandExecutor commandExecutor;
    private String menuOption;
    public AuthenticationDialog() {
        this.commandExecutor = new CommandExecutor();
    }

    public String showMenu(){
        System.out.println("1: Add Authentication to Person\n2: Delete Authentication from Person\n3: View Authentication from Person");
        Scanner scanner = new Scanner(System.in);
        String selectedOption = scanner.next();
        switch (selectedOption){
            case"1":{
                this.menuOption ="21";
                return menuOption;
            }
            case"2":{
                this.menuOption ="22";
                return menuOption;
            }
            case"3":{
                this.menuOption ="23";
                return menuOption;
            }
            default:{
                throw new IllegalStateException("Input not known! Please try again" );
            }
        }

    }
    public boolean dataInput(List<Person> personList){
        System.out.println("Select a person to identify");
        for(int i=0; i < personList.size(); i++){
            System.out.println(i + personList.get(i).getName() );
        }
        Scanner scanner12 = new Scanner(System.in);
        String numberInput = scanner12.next();
        Person pers1 = personList.get(Integer.parseInt(numberInput));

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

        return authResult;
    }
    public List<Person> dataDelete(List<Person> personList){
        System.out.println("Select a person to change the identifier");
        for(int i=0; i < personList.size(); i++){
            System.out.println(i + personList.get(i).getName() );
        }
        Scanner scanner12 = new Scanner(System.in);
        String numberInput = scanner12.next();
        int persIn = Integer.parseInt(numberInput);
        Person person = personList.get(persIn);
        System.out.println("Enter the new identifier");
        Scanner scanner13 = new Scanner(System.in);
        String identInput = scanner13.next();
        person.setCredentialIdentifier(identInput);
        personList.set(persIn,person);
        return personList;
    }
    public void dataOutput(List<Person> personList){
        System.out.println("Select a person to get the identifier");
        for(int i=0; i < personList.size(); i++){
            System.out.println(i + personList.get(i).getName() );
        }
        Scanner scanner16 = new Scanner(System.in);
        String numberInput = scanner16.next();
        int pers1In = Integer.parseInt(numberInput);
        Person person1 = personList.get(pers1In);
        System.out.println(person1.getCredentialIdentifier());
    }
}
