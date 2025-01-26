package learning.problemsolving.assignments.coursera.ds.n_array_tree_height;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TreeHeightFinderTest {


    private TreeHeightFinder treeHeightFinder = new TreeHeightFinder();

    @Test
    public void testDefaultTree() {
        int nodeCount = 5;
        TreeNode[] defaultTreeNode = treeHeightFinder.createDefaultTreeNodes(nodeCount);
        Assertions.assertEquals(nodeCount, defaultTreeNode.length);
    }




}
