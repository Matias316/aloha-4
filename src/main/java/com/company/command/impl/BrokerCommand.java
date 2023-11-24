package command.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import command.api.Command;
import utils.SupportedCommands;

public class BrokerCommand {
    public void executeCommand(String commandLine) {

        String[] inputCommandAndArguments = commandLine.split(" ");
        
        String inputCommand = inputCommandAndArguments[0];

        //Convert to list to easily manipulate
        ArrayList<String> inputCommandAndArgumentsList = new ArrayList<String>(Arrays.asList(inputCommandAndArguments));

        Command command = null;

        switch (inputCommand) {
            case SupportedCommands.INSTALL_COMMAND:
                //Command and 1 argument are required for install command
                if (inputCommandAndArgumentsList.size() == 2) {
                    //Remove command and just pass arguments
                    inputCommandAndArgumentsList.remove(0);
                    command = new InstallCommand(inputCommandAndArgumentsList);            
                }
                break;
            case SupportedCommands.DEPEND_COMMAND:
                //Command and at least 2 arguments are required for install command
                if (inputCommandAndArgumentsList.size() > 2) {
                    //Remove command and just pass arguments
                    inputCommandAndArgumentsList.remove(0);
                    command = new DependCommand(inputCommandAndArgumentsList);        
                }      
                break;
            case SupportedCommands.REMOVE_COMMAND:
                //Command and 1 argument are required for remove command
                if (inputCommandAndArgumentsList.size() == 2) {
                    //Remove command and just pass arguments
                    inputCommandAndArgumentsList.remove(0);
                    command = new RemoveCommand(inputCommandAndArgumentsList);            
                }
                break;
            case SupportedCommands.LIST_COMMAND:
                command = new ListCommand();             
                break;
            case SupportedCommands.END_COMMAND:
                command = new EndCommand();              
                break;
            default:                
                break;
        }
        if (command != null) command.execute();
    }
}
