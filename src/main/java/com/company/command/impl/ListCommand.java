package command.impl;
import command.api.Command;
import entities.Inventory;

public class ListCommand implements Command {

    Inventory inventory;

    public ListCommand(Inventory inventory){
        this.inventory = inventory;
    }

    /**
     * List all packages names in the ordered they were added to inventory
     * Returns: LIST <packageName1> <packageNameN>
    */
    @Override
    public void execute() {
        this.inventory.listPackages();
    }
    
}
