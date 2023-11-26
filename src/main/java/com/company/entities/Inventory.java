package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import utils.Responses;

public class Inventory
{    

    private static Inventory inventoryInstance = null;    
    public DependencyTree dependenciesTree;
    public List<String> installedPackages;

    private Inventory() {
        installedPackages = new ArrayList<>();
        dependenciesTree = new DependencyTree();
    }

    public static Inventory getInstance() {
        if (inventoryInstance == null) {
            inventoryInstance = new Inventory();
        }
        return inventoryInstance;
    }
 
    public String addPackage(String packageName) {      
        String response = "";

        //Node exists in dependency tree - obtain dependencies
        if (dependenciesTree.getNode(packageName) != null) {
            response = "Install dependencies from dependency tree";
        } else {
            //Package was not found in dependencies tree therefore it doesn't have dependencies
            if (!installedPackages.contains(packageName)) {
                installedPackages.add(packageName);
                response = Responses.SUCCESSFULLY_INSTALLED;
            } else {
                response = Responses.ALREADY_INSTALLED;
            }
        }
        
        return response; 
    }

    public String removePackage(String packageName){
         String response = "";

        //Node exists in dependency tree - obtain dependencies
        if (dependenciesTree.getNode(packageName) != null) {
            response = "Verify there are no parents node before removing";
        } else {
            //Package was not found in dependencies tree therefore it doesn't have dependencies
            if (!installedPackages.contains(packageName)) {               
                response = Responses.ALREADY_REMOVED;
            } else {
                installedPackages.remove(packageName);
                response = Responses.SUCCESSFULLY_REMOVED;
            }
        }
        return response;
    }

    public String listPackages(){
        return installedPackages.toString(); 
    }

    public void addDependencies(String packageName, List<String> packageDependencies) {
        dependenciesTree.addNode(packageName, packageDependencies);
    }
    

    

}