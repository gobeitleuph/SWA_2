import java.util.Scanner;

public class BookingDialog {
    private String menuOption;
    public String showMenu(){
        System.out.println("1: Add Booking\n2: Delete Booking \n3: View Booking");
        Scanner scanner = new Scanner(System.in);
        String selectedOption = scanner.next();
        switch (selectedOption){
            case"1":{
                this.menuOption ="31";
                return menuOption;
            }
            case"2":{
                this.menuOption ="32";
                return menuOption;
            }
            case"3":{
                this.menuOption ="33";
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
