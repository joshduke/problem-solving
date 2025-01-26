package learning.problemsolving.assignments.coursera.ds.n_array_tree_height;

import java.util.Scanner;
import java.util.stream.IntStream;

public class TreeHeightFinder {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String tree = scanner.nextLine();
        TreeNode[] treeNodes = new TreeNode[n];

        IntStream.range(0, n).mapToObj(i -> treeNodes[i] = new TreeNode(i));

        TreeNode rootNode = null;

        int index = 0;
        for(String value : tree.split(" ")) {
            int int_value = Integer.parseInt(value);
            if(int_value == -1) {
                rootNode = treeNodes[index];
            }
            treeNodes[int_value].addChild(treeNodes[index]);
        }

    }

    public void printTree(TreeNode rootNode) {
        if(rootNode.getChildrens() == null) { // Leaf
            System.out.print(rootNode.getValue());
            return;
        } else {
//            printTree(rootNode.getChildrens());
        }
        rootNode.getChildrens();

    }

}
