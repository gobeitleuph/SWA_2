import java.util.Scanner;

public class ContentDialog {
    private String menuOption;
    public String showMenu(){
        System.out.println("1: Add Content to Folder\n2: Delete Content form Folder\n3: View Folder");
        Scanner scanner = new Scanner(System.in);
        String selectedOption = scanner.next();
        switch (selectedOption){
            case"1":{
                this.menuOption ="41";
                return menuOption;
            }
            case"2":{
                this.menuOption ="42";
                return menuOption;
            }
            case"3":{
                this.menuOption ="43";
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
