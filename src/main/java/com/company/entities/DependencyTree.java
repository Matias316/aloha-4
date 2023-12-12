package com.company.entities;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DependencyTree {
 
     Map<String, PackageNode> packageNodes;

    public DependencyTree() {
        this.packageNodes = new HashMap<>();
    }

    public void addNode(String packageName, List<String> dependencies) {
        //Verify whether package already exists in dependency tree, if not create it and add it
        if (!packageNodes.containsKey(packageName)) {
            packageNodes.put(packageName, new PackageNode(packageName));
        }

        PackageNode pkgNode = packageNodes.get(packageName);

        //Verify whether dependencies already exist in dependency tree, if not create it add it
        for (String dependencyName : dependencies) {
            if (!packageNodes.containsKey(dependencyName)) {
                packageNodes.put(dependencyName, new PackageNode(dependencyName));
            }
            PackageNode dependencyNode = packageNodes.get(dependencyName);
            pkgNode.dependencies.add(dependencyNode);
        }
    }

    public PackageNode getNode(String packageName) {
        PackageNode packageNode = null;
        if (packageNodes.containsKey(packageName)) packageNode = packageNodes.get(packageName);

        return packageNode;
    }

    public Collection<PackageNode> getAllNodes() {
        return packageNodes.values();
    }

}
