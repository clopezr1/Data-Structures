/**
 * Created by Carlos on 11/3/2017.
 */
public class Node {
    private int freq;
    private String word;
    private Node leftChild, rightChild;

    public Node(){
        freq = 1;
        leftChild = rightChild = null;
    }
    ////getter setters///
    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
