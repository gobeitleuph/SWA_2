import java.util.Scanner;

public class StatisticsDialog {
    private String menuOption;
    public String showMenu(){
        System.out.println("1: Add Statistic Input\n2: Delete Statistic Input\n3: View Statistics");
        Scanner scanner = new Scanner(System.in);
        String selectedOption = scanner.next();
        switch (selectedOption){
            case"1":{
                this.menuOption ="81";
                return menuOption;
            }
            case"2":{
                this.menuOption ="82";
                return menuOption;
            }
            case"3":{
                this.menuOption ="83";
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
