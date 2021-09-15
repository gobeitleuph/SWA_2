import Person.Person;

import java.util.List;
import java.util.Scanner;

public class AuthenticationDialog {
    private String menuOption;
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
    public List<Person> dataInput(List<Person> personList){
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
    public void dataDelete(){

    }
    public void dataOutput(){}
}
