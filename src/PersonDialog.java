import java.util.Scanner;

public class PersonDialog {
    private String menuOption;
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
    public void dataInput(){}
    public void dataDelete(){}
    public void dataOutput(){}
}
