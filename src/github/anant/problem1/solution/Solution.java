package github.anant.problem1.solution;

import github.anant.problem1.solution.structures.ModifiedLLNode;
import github.anant.problem1.solution.util.ListCreator;
import github.anant.problem1.solution.util.ListPrinter;

public class Solution {

  public static ModifiedLLNode cloneLL(ModifiedLLNode headLL) {
    insertCopyNodeInBetweenOriginalNodes(headLL);
    setJumpPointers(headLL);

    //set the correct next pointers for copy and original Node
    ModifiedLLNode clonedListHead = setCorrectNextPointers(headLL);

    return clonedListHead;
  }

  private static ModifiedLLNode setCorrectNextPointers(ModifiedLLNode headLL) {
    ModifiedLLNode runner = headLL;

    ModifiedLLNode clonedList = runner.getNext();
    ModifiedLLNode clonedListHead = clonedList;

    while (runner != null && clonedList != null) {
      if (runner.getNext() != null) {
        runner.setNext(runner.getNext().getNext());
      }

      if (clonedList.getNext() != null) {
        clonedList.setNext(clonedList.getNext().getNext());
      }

      runner = runner.getNext();
      clonedList = clonedList.getNext();
    }
    return clonedListHead;
  }

  private static void setJumpPointers(ModifiedLLNode headLL) {
    //Set the correct Jump pointer for copy Nodes
    ModifiedLLNode runner = headLL;
    while (runner != null) {
      ModifiedLLNode copyNode = runner.getNext();
      copyNode.setJump(runner.getJump().getNext());
      runner = runner.getNext().getNext();
    }
  }

  private static void insertCopyNodeInBetweenOriginalNodes(ModifiedLLNode headLL) {
    ModifiedLLNode runner = headLL;
    ModifiedLLNode tempNext;

    //Insert a copy Node in between original Nodes in original List
    while (runner != null) {
      tempNext = runner.getNext();

      ModifiedLLNode copyNode = new ModifiedLLNode();
      copyNode.setData(runner.getData());
      copyNode.setNext(runner.getNext());

      copyNode.setJump(runner);

      runner.setNext(copyNode);

      runner = tempNext;
    }
  }


  public static void main(String[] args) {
    ModifiedLLNode originalHeadNode = ListCreator.getOriginalList();
    System.out.println("Printing Original List Before Solving...");
    ListPrinter.printList(originalHeadNode);

    ModifiedLLNode clonedHeaderNode = Solution.cloneLL(originalHeadNode);

    System.out.println("Printing Original List After Solving...");
    ListPrinter.printList(originalHeadNode);

    System.out.println("Printing Cloned List After Solving...");
    ListPrinter.printList(clonedHeaderNode);
  }
}
