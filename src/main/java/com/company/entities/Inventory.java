package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventory
{    

    private static Inventory inventoryInstance = null;    
    public HashMap<String, List<String>> packageAndDependencies;

    private Inventory() {
        packageAndDependencies = new HashMap<String, List<String>>();
    }

    public static Inventory getInstance() {
        if (inventoryInstance == null) {
            inventoryInstance = new Inventory();
        }
        return inventoryInstance;
    }
 
    public String addPackage(String packageName) {      
        return ""; 
    }

    public String removePackage(String packageName){
        return ""; 
    }

    public List<String> listPackages(){
        return new ArrayList<String>(packageAndDependencies.keySet()); 
    }

    public void addPackageDependency(List<String> packageDependencies, String packageName) {
        packageAndDependencies.put(packageName, packageDependencies);
    }
    

    

}