package command.impl;
import command.api.Command;
import entities.Inventory;

public class RemoveCommand implements Command {

    Inventory inventory;

    public RemoveCommand(Inventory inventory){
        this.inventory = inventory;
    }

    /**
     * Remove package with respective dependencies from inventory if not already removed
     * Returns: REMOVE <packageName> <result>
     * Where <result> is: 
     * <packageName> successfully removed --> Package with no dependencies removed
     * or
     * <packageName> successfully removed <dependency1> is no longer needed <dependency1> successfully removed <dependencyN> is no longer needed <dependencyN> successfully removed  --> Package with dependencies removed
     * or
     * <packageName> is still needed --> Package is a dependency to other package and can't be removed
     * or
     * <packageName> is not installed --> Package already removed
     */
    @Override
    public void execute() {
        this.inventory.removePackage("");
    }
    
}
