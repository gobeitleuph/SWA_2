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
    public void dataInput(){}
    public void dataDelete(){}
    public void dataOutput(){}
}
