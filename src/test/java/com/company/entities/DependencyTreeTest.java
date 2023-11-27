import static org.junit.Assert.*;  
import org.junit.Test;  
import com.company.entities.DependencyTree;
import com.company.entities.PackageNode;

public class DependencyTreeTest {
    
    private DependencyTree dependencyTree;

    @Override
	protected void setUp() throws Exception {
		dependencyTree = new DependencyTree();
	}

    @Test  
    public void testValidateNodeIsAdded(){  
        dependencyTree.addNode("TEST_PACKAGE", new ArrayList<String>("DEPENDENCY1","DEPENDENCY2"));
        assertEquals("TEST_PACKAGE",dependencyTree.getNode("TEST_PACKAGE")));          
    }  

}
