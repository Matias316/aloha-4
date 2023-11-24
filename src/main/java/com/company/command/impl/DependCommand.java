package command.impl;
import java.util.ArrayList;
import java.util.List;

import command.api.Command;
import entities.Inventory;
import utils.Responses;
import utils.SupportedCommands;

public class DependCommand implements Command {

    Inventory inventory;
    String packageName;
    List<String> dependencies;

    public DependCommand(List<String> arguments){
        //this.cli = cli;
        //this.inventory = inventory;
        this.packageName = arguments.get(0);
        this.dependencies = arguments.subList(1, arguments.size());
    }

    @Override
    public void execute() {

        //this.inventory.addPackageDependency(new ArrayList<String>(),"");
        System.out.print(SupportedCommands.DEPEND_COMMAND + " " + this.packageName + " " + this.dependencies.toString());

    }
    
}
