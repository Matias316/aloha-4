package command.impl;
import java.util.ArrayList;

import command.api.Command;
import entities.Inventory;

public class DependCommand implements Command {

    Inventory inventory;

    public DependCommand(Inventory inventory){
        this.inventory = inventory;
    }

    @Override
    public void execute() {
        this.inventory.addPackageDependency(new ArrayList<String>(),"");
    }
    
}
