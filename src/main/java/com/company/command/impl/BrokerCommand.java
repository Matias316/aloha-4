package com.company.command.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.company.command.api.Command;
import com.company.entities.Inventory;
import com.company.utils.SupportedCommands;

public class BrokerCommand {

    Inventory inventory;

    public BrokerCommand(){
        this.inventory = Inventory.getInstance();
    }

    /**
     * 
     * @param inputCommand: expected format <command> <arguments> 
     */
    public String executeCommand(String inputCommand) {

        String result = "";
        List<String> inputCommandAndArgumentsList = new ArrayList<>(Arrays.asList(inputCommand.split(" ")));
        
        String command = inputCommandAndArgumentsList.get(0);

        //Remove command and keep arguments (if any)
        if (inputCommandAndArgumentsList.size() > 1) inputCommandAndArgumentsList.remove(0);

        Command commandToExecute = null;
        switch (command) {
            case SupportedCommands.INSTALL_COMMAND:
                commandToExecute = new InstallCommand(inputCommandAndArgumentsList, inventory);                           
                break;
            case SupportedCommands.DEPEND_COMMAND:
                commandToExecute = new DependCommand(inputCommandAndArgumentsList, inventory);        
                break;
            case SupportedCommands.REMOVE_COMMAND:
                commandToExecute = new RemoveCommand(inputCommandAndArgumentsList, inventory);                            
                break;
            case SupportedCommands.LIST_COMMAND:
                commandToExecute = new ListCommand(inventory);             
                break;
            case SupportedCommands.END_COMMAND:
                commandToExecute = new EndCommand();              
                break;
            default:                
                break;
        }

        //Ignore anything else different to the known commands
        if (commandToExecute != null) result = commandToExecute.execute();
        
        return result;
    }
}
