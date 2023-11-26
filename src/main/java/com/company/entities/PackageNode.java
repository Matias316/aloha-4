package entities;

import java.util.HashSet;
import java.util.Set;

public class PackageNode {
    
    String packageName;
    Set<PackageNode> dependencies;

    public PackageNode(String packageName) {
        this.packageName = packageName;
        this.dependencies = new HashSet<>();
    }

}
