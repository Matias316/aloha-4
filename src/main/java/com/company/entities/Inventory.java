package com.company.entities;

import java.util.ArrayList;
import java.util.List;
import com.company.utils.Responses;

public class Inventory
{    

    private static Inventory inventoryInstance = null;    
    public DependencyTree dependenciesTree;
    public PackageNode packageNode;
    public List<String> installedPackages;

    private Inventory() {
        installedPackages = new ArrayList<String>();
        dependenciesTree = new DependencyTree();
    }

    public static Inventory getInstance() {
        if (inventoryInstance == null) {
            inventoryInstance = new Inventory();
        }
        return inventoryInstance;
    }
 
    public String addPackage(String packageName) {      
        String result = "";

        //Package was already installed
        if (installedPackages.contains(packageName)) {
            return result.concat(packageName + " " + Responses.ALREADY_INSTALLED + " ");            
        } 

        packageNode = dependenciesTree.getNode(packageName);

        //Node exists in dependency tree - obtain dependencies and install them if needed
        if (packageNode != null) {
            result = installDependencies(packageNode, result);
        } 
        
        installedPackages.add(packageName);
        return result.concat(packageName + " " + Responses.SUCCESSFULLY_INSTALLED + " ");
    }

    private String installDependencies(PackageNode packageNode, String result) {
        String dependencyName;        

        for (PackageNode dependency: packageNode.dependencies) {

            dependencyName = dependency.packageName;
            if (!installedPackages.contains(dependencyName)) {
                installedPackages.add(dependencyName);                
                result.concat(dependencyName + " " + Responses.SUCCESSFULLY_INSTALLED + " ");
            } else {
                result.concat(dependencyName + " " + Responses.ALREADY_INSTALLED + " ");
            }   

            installDependencies(dependency, result);
        }
        return result;
    }

    public String removePackage(String packageName){

        String result = "";
        //Node exists in dependency tree - obtain dependencies
        Boolean dependencyIsNotUsed = true;
        if (dependenciesTree.getNode(packageName) != null) {
            dependencyIsNotUsed = verifyDependencyNotUsed(packageName);
        }         
        
        //Package was not found in dependencies tree therefore it doesn't have dependencies
        if (dependencyIsNotUsed) {
            if (!installedPackages.contains(packageName)) {  
                result.concat(packageName + " " + Responses.ALREADY_REMOVED);             
            } else {
                installedPackages.remove(packageName);
                result.concat(packageName + " " + Responses.SUCCESSFULLY_REMOVED);             
            }
        } else {
            result.concat(packageName + " " + Responses.IN_USE);             
        }
        return result;
            
    }

    private boolean verifyDependencyNotUsed(String dependencyName) {
        
        boolean dependencyIsNotUsed = true;
        //Probably this could be refactored by having a reference to parent node
        for (PackageNode packageNode: dependenciesTree.getAllNodes()) {
            //According to dependencies tree, this package uses this dependency - verify it's installed
            for (PackageNode dependency: packageNode.dependencies)
                if (dependency.packageName.equals(dependencyName) && installedPackages.contains(packageNode.packageName)) {
                    dependencyIsNotUsed = false;
                    break;
                }
        }
        return dependencyIsNotUsed;
    }

    public String listPackages(){
        return installedPackages.toString(); 
    }

    public void addDependencies(String packageName, List<String> packageDependencies) {
        dependenciesTree.addNode(packageName, packageDependencies);
    }
    
}