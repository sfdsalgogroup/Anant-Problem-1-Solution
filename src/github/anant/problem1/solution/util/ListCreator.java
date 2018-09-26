package github.anant.problem1.solution.util;

import github.anant.problem1.solution.structures.ModifiedLLNode;

public class ListCreator {

  public static ModifiedLLNode getOriginalList() {
    ModifiedLLNode node4 = new ModifiedLLNode();
    node4.setData("D");
    node4.setNext(null);

    ModifiedLLNode node3 = new ModifiedLLNode();
    node3.setData("C");
    node3.setNext(node4);

    ModifiedLLNode node2 = new ModifiedLLNode();
    node2.setData("B");
    node2.setNext(node3);

    ModifiedLLNode node1 = new ModifiedLLNode();
    node1.setData("A");
    node1.setNext(node2);

    node1.setJump(node3);
    node2.setJump(node4);
    node3.setJump(node2);
    node4.setJump(node4);

    return node1;
  }
}
