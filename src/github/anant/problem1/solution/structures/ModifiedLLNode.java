package github.anant.problem1.solution.structures;

public class ModifiedLLNode {

  private String data;

  private ModifiedLLNode next;

  private ModifiedLLNode jump;

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public ModifiedLLNode getNext() {
    return next;
  }

  public void setNext(ModifiedLLNode next) {
    this.next = next;
  }

  public ModifiedLLNode getJump() {
    return jump;
  }

  public void setJump(ModifiedLLNode jump) {
    this.jump = jump;
  }
}
