package hh;

//此节点类用于演示哈夫曼树编码
public class Node {
  public char aChar;
  public int frequency;
  public Node leftNode; //<key
  public Node rightNode; //>=key
  public Node(char ch,int frequency) {
      this.aChar = ch;
      this.frequency = frequency;
  }
  public void display() {
      System.out.print( aChar + " ");
  }
}
