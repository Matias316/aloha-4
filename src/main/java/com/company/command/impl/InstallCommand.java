package command.impl;
import java.util.List;

import command.api.Command;
import entities.Inventory;
import utils.SupportedCommands;

public class InstallCommand implements Command {

    Inventory inventory;
    String packageName;

    public InstallCommand(List<String> arguments, Inventory inventory){
        this.inventory = inventory;
        this.packageName = arguments.get(0);
    }

    /**
     * Install package with respective dependencies to inventory if not already installed
     * Returns: INSTALL <packageName> <result>
     * Where <result> is: 
     * <packageName> successfully installed --> Package with no dependencies installed
     * or
     * <dependency1> succesfully installed <dependencyN> successfully installed <packageName> successfully installed --> Package with dependencies installed
     * or
     * <packageName> is already installed --> Package already installed
     */
    @Override
    public void execute() {
        System.out.print(SupportedCommands.INSTALL_COMMAND + " " + this.packageName + " ");
        this.inventory.addPackage(this.packageName);
    }
    
}
