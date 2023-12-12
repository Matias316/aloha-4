package com.company.entities;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;  


public class DependencyTreeTest {
    
    private DependencyTree dependencyTree;

    @Before
	public void setUp() throws Exception {
		dependencyTree = new DependencyTree();
	}

    @Test  
    public void testValidateNodeIsAdded(){  
        List<String> dependencyList = new ArrayList<String>(Arrays.asList("DEPENDENCY1","DEPENDENCY2"));
        dependencyTree.addNode("TEST_PACKAGE", dependencyList );
        assertEquals("TEST_PACKAGE",dependencyTree.getNode("TEST_PACKAGE").packageName);          
    }  

}