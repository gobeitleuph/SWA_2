import java.util.Scanner;

public class PaymentDialog {
    private String menuOption;
    public String showMenu(){

        System.out.println("1: Add Payment\n2: Delete Payment\n3: View Payment");
        Scanner scanner = new Scanner(System.in);
        String selectedOption = scanner.next();
        switch (selectedOption){
            case"1":{
                this.menuOption ="51";
                return menuOption;
            }
            case"2":{
                this.menuOption ="52";
                return menuOption;
            }
            case"3":{
                this.menuOption ="53";
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
