package command.impl;
import java.util.List;

import command.api.Command;
import entities.Inventory;
import utils.SupportedCommands;

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
    public void execute() {
        this.inventory.addDependencies(this.packageName, this.dependencies);
        System.out.println(SupportedCommands.DEPEND_COMMAND + " " + this.packageName + " " + this.dependencies.toString());
    }
    
}
