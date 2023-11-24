package command.impl;

import command.api.Command;
import entities.Inventory;

public class EndCommand implements Command {

    Inventory inventory;

    public EndCommand(){        
    }

    @Override
    public void execute() {
    }
    
}
