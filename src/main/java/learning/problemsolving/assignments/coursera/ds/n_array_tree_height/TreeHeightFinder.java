package learning.problemsolving.assignments.coursera.ds.n_array_tree_height;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TreeHeightFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String tree = scanner.nextLine();
        TreeHeightFinder treeHeightFinder = new TreeHeightFinder();
        TreeNode[] treeNodes = treeHeightFinder.createDefaultTreeNodes(n);
        TreeNode rootNode = treeHeightFinder.buildTreeStructure(treeNodes, tree);
        System.out.print(treeHeightFinder.computeTreeHeight(rootNode));
    }

    public void printTree(TreeNode rootNode) {
        if(rootNode.getChildrens() == null) { // Leaf
            System.out.print(rootNode.getValue());
            return;
        } else {
            rootNode.getChildrens().forEach(node -> {
                System.out.print(node.getValue());
                printTree(node);
            });
        }
    }

    private TreeNode buildTreeStructure(TreeNode[] treeNodes, String treeInput) {
        TreeNode rootNode = null;

        int index = 0;
        for(String value : treeInput.split(" ")) {
            int int_value = Integer.parseInt(value);
            if(int_value == -1) {
                rootNode = treeNodes[index];
            } else {
                treeNodes[int_value].addChild(treeNodes[index]);
            }

            index++;
        }
    }

    private int computeTreeHeight(TreeNode rootNode) {
        if(rootNode.getChildrens() == null || rootNode.getChildrens().isEmpty()) {
            // Leaf
            return 1;
        } else { // has children (sub-tree)
            int max = 1;
            int current;
            for(TreeNode subTree : rootNode.getChildrens()) {
                current = 1 + computeTreeHeight((subTree));
                if(current > max) {
                    max = current;
                }
            }
            return max;
        }
    }

    private TreeNode[] createDefaultTreeNodes(int nodesCount) {
        TreeNode[] treeNodes = new TreeNode[nodesCount];
        for(int i = 0; i < nodesCount; i++) {
            treeNodes[i] = new TreeNode(i);
        }
        return treeNodes;
    }

}

class TreeNode {

    private int value;

    private List<TreeNode> childNodes;

    public TreeNode(int nodeValue) {
        this.value = nodeValue;
        this.childNodes = new LinkedList<>();
    }

    public void addChild(TreeNode childNode) {
        this.childNodes.add(childNode);
    }

    public void addChild(int childValue) {
        this.childNodes.add(new TreeNode(childValue));
    }

    public List<TreeNode> getChildrens() {
        return this.childNodes;
    }

    public int getValue() {
        return this.value;
    }

}
