package entities;

import java.util.ArrayList;
import java.util.List;
import utils.Responses;

public class Inventory
{    

    private static Inventory inventoryInstance = null;    
    public DependencyTree dependenciesTree;
    public PackageNode packageNode;
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
 
    public void addPackage(String packageName) {      
        //Package was already installed
        if (installedPackages.contains(packageName)) {
            System.out.println(packageName + " " + Responses.ALREADY_INSTALLED + " ");
            return;
        } 

        packageNode = dependenciesTree.getNode(packageName);

        //Node exists in dependency tree - obtain dependencies and install them if needed
        if (packageNode != null) {
            installDependencies(packageNode);
        } 
        
        installedPackages.add(packageName);
        System.out.println(packageName + " " + Responses.SUCCESSFULLY_INSTALLED + " ");
    }

    private void installDependencies(PackageNode packageNode) {
        String dependencyName;
        for (PackageNode dependency: packageNode.dependencies) {

            dependencyName = dependency.packageName;
            if (!installedPackages.contains(dependencyName)) {
                installedPackages.add(dependencyName);
                
                System.out.print(dependencyName + " " + Responses.SUCCESSFULLY_INSTALLED + " ");
            } else {
                System.out.print(dependencyName + " " + Responses.ALREADY_INSTALLED + " ");
            }   

            installDependencies(dependency);
        }
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