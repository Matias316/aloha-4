package com.company.command.impl;
import java.util.List;

import com.company.command.api.Command;
import com.company.entities.Inventory;
import com.company.utils.SupportedCommands;

public class DependCommand implements Command {

    Inventory inventory;
    String packageName;
    List<String> dependencies;

    public DependCommand(List<String> arguments, Inventory inventory){
        this.inventory = inventory;
        this.packageName = arguments.get(0);
        this.dependencies = arguments.subList(1, arguments.size());
    }

    @Override
    public String execute() {        
        this.inventory.addDependencies(this.packageName, this.dependencies);
        return SupportedCommands.DEPEND_COMMAND + " " + this.packageName + " " + this.dependencies.toString();
    }
    
}
