import Content.Content;
import Content.Folder;
import ViewController.CommandController;
import ViewController.CommandExecutor;
import ViewController.ContentController;

import java.util.List;
import java.util.Scanner;

public class ContentDialog {
    private CommandExecutor commandExecutor;
    public ContentDialog() {
        this.commandExecutor = new CommandExecutor();
    }
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
    public List<Content> dataInput(List<Content> contentList){
        System.out.println("Select folder to add files/folders");
        for(int i=0; i < contentList.size(); i++){
            System.out.println(i + contentList.get(i).getName() );
        }
        Scanner scanner12 = new Scanner(System.in);
        String numberInput = scanner12.next();
        Content folder1 = contentList.get(Integer.parseInt(numberInput));

        System.out.println("Select folder or file that will be added");
        for(int i=0; i < contentList.size(); i++){
            System.out.println(i + contentList.get(i).getName() );
        }
        Scanner scanner14 = new Scanner(System.in);
        String contInput = scanner14.next();
        Content folder2 = contentList.get(Integer.parseInt(contInput));


        CommandController contcon1 = new ContentController(folder2, ((Folder)folder1));
        commandExecutor.executeCommand("addContentToFolder",contcon1);
        Content fold1 = ((ContentController) contcon1).getFolder();
        int folderIndex =Integer.parseInt(numberInput);
        contentList.set(folderIndex,fold1);


        return contentList;
    }
    public List<Content> dataDelete(List<Content> contentList){
        System.out.println("Select folder to delete");
        for(int i=0; i < contentList.size(); i++){
            System.out.println(i + contentList.get(i).getName() );
        }
        Scanner scanner14 = new Scanner(System.in);
        String deleteInput = scanner14.next();
        contentList.remove(Integer.parseInt(deleteInput));
        return contentList;
    }
    public void dataOutput(List<Content> contentList){
        System.out.println("Current folders");
        for(int i=0; i < contentList.size(); i++){
            System.out.println(i + contentList.get(i).getName() );
        }
    }
}
