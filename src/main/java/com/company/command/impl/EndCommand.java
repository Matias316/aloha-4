package com.company.command.impl;

import com.company.command.api.Command;
import com.company.entities.Inventory;
import com.company.utils.SupportedCommands;

public class EndCommand implements Command {

    Inventory inventory;

    public EndCommand(){        
    }

    @Override
    public void execute() {
        System.out.println(SupportedCommands.END_COMMAND);

    }
    
}
