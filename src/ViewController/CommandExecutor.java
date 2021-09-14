package ViewController;

public class CommandExecutor {

    public void executeCommand(String command, CommandController commandController){
        commandController.execute(command);
    }
}
