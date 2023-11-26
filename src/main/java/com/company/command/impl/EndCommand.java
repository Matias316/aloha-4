package command.impl;

import command.api.Command;
import entities.Inventory;
import utils.SupportedCommands;

public class EndCommand implements Command {

    Inventory inventory;

    public EndCommand(){        
    }

    @Override
    public void execute() {
        System.out.println(SupportedCommands.END_COMMAND);

    }
    
}
