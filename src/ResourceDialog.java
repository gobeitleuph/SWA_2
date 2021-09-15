import java.util.Scanner;

public class ResourceDialog {
    private String menuOption;
    public String showMenu(){
        System.out.println("1: Add Car\n2: Delete Car\n3: View Car");
        Scanner scanner = new Scanner(System.in);
        String selectedOption = scanner.next();
        switch (selectedOption){
            case"1":{
                this.menuOption ="71";
                return menuOption;
            }
            case"2":{
                this.menuOption ="72";
                return menuOption;
            }
            case"3":{
                this.menuOption ="73";
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
