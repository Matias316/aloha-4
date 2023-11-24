package command.impl;
import command.api.Command;
import entities.Inventory;

public class InstallCommand implements Command {

    Inventory inventory;

    public InstallCommand(Inventory inventory){
        this.inventory = inventory;
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
        this.inventory.addPackage("");
    }
    
}