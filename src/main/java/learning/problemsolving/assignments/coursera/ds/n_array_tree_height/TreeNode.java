package learning.problemsolving.assignments.coursera.ds.n_array_tree_height;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {

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
