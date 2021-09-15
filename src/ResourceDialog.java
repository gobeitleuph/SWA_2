import Person.Person;
import Resource.ResourceSelection;
import ViewController.CommandController;
import ViewController.CommandExecutor;
import ViewController.ResourceController;

import java.util.List;
import java.util.Scanner;

public class ResourceDialog {
    private CommandExecutor commandExecutor;
    private String menuOption;

    public ResourceDialog() {
        this.commandExecutor = new CommandExecutor();
    }
    public String showMenu(){
        System.out.println("1: Select resources\n2: Delete resources\n3: View resources");
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
    public List<ResourceSelection> dataInput(List<ResourceSelection> resourceList){
        System.out.println("Please enter the number of the car type you want to select");
        for(int i=0; i < resourceList.size(); i++){
            System.out.println(i + " " + resourceList.get(i).getLabel() );
        }
        Scanner scanner2 = new Scanner(System.in);
        String numberInput = scanner2.next();

        ResourceSelection car = resourceList.get(Integer.parseInt(numberInput));

        System.out.println("Do you need any extra equipment?");
        System.out.println("1: Child seat\n2: Set top box\n3: Both\n4: none");
        Scanner scanner3 = new Scanner(System.in);
        String optionsInput = scanner3.next();

        switch (optionsInput){
            case"1":{
                CommandController rescon1 = new ResourceController(car);
                commandExecutor.executeCommand("selectResourceChildSeat",rescon1);
                ResourceSelection res1 = ((ResourceController) rescon1).getCombination();
                resourceList.add(res1);
                break;
            }
            case"2":{
                CommandController rescon2 = new ResourceController(car);
                commandExecutor.executeCommand("selectResourceSetTopBox",rescon2);
                ResourceSelection res2 = ((ResourceController) rescon2).getCombination();
                resourceList.add(res2);
                break;
            }
            case"3":{
                CommandController rescon1 = new ResourceController(car);
                commandExecutor.executeCommand("selectResourceChildSeat",rescon1);
                ResourceSelection res1 = ((ResourceController) rescon1).getCombination();
                CommandController rescon2 = new ResourceController(res1);
                commandExecutor.executeCommand("selectResourceSetTopBox",rescon2);
                ResourceSelection res2 = ((ResourceController) rescon2).getCombination();
                resourceList.add(res2);
                break;
            }case"4":{
                resourceList.add(car);
                break;
            }

        }

        return resourceList;
    }
    public List<ResourceSelection> dataDelete(List<ResourceSelection> resourceList){
        System.out.println("Please enter the number of the resource you want to delete");
        for(int i=0; i < resourceList.size(); i++){
            System.out.println(i + resourceList.get(i).getLabel() );
        }
        Scanner scanner12 = new Scanner(System.in);
        String numberInput = scanner12.next();
        resourceList.remove(Integer.parseInt(numberInput));
        return resourceList;
    }
    public void dataOutput(List<ResourceSelection> resourceList){
        System.out.println("Current resources");
        for(int i=0; i < resourceList.size(); i++){
            System.out.println(i + " " + resourceList.get(i).getLabel() );
        }
    }
}
