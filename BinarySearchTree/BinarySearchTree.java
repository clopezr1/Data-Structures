/**
 * Created by Carlos on 11/3/2017.
 */
public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    private boolean isEmpty() {
        return root == null;
    }

    public void insert(String word) { //adds new word/node
        Node nd = new Node();
        nd.setWord(word);
        if (isEmpty())
            root = nd;
        else
            insert(root, nd);
    }

    private void insert(Node subroot, Node nd) { //adds to correct spot
        if (subroot.getWord().compareTo(nd.getWord()) == 0) { //are equal, freq++
            subroot.setFreq(subroot.getFreq() + 1);
            return;
        }
        if (subroot.getWord().compareTo(nd.getWord()) > 0) {  //Go left
            if (subroot.getLeftChild() == null)
                subroot.setLeftChild(nd);
            else
                insert(subroot.getLeftChild(), nd);
        } else {                                              //Go right
            if (subroot.getRightChild() == null)
                subroot.setRightChild(nd);
            else
                insert(subroot.getRightChild(), nd);
        }


    }

    public void search(String key) {
        System.out.println(search(root, key));
    }
    private String search(Node subroot, String key){
        if (subroot == null)
            return key + " Not found";
        if (subroot.getWord().compareTo(key) == 0)          //if that is the key word print it
            return key;
        if (subroot.getWord().compareTo(key) > 0)           //go left
            return search(subroot.getLeftChild(), key);
        else
            return search(subroot.getRightChild(), key);    //go right
    }
    ///Traversals////
    public void printPreOrder() {
        printPreOrder(root);
    }
    private void printPreOrder(Node subroot) {
        if (subroot == null)
            return;
        System.out.println(subroot.getWord() + "   freq: "+subroot.getFreq());
        printPreOrder(subroot.getLeftChild());
        printPreOrder(subroot.getRightChild());
    }

    public void printInOrder() {
        printInOrder(root);
    }
    private void printInOrder(Node subroot) {
        if (subroot == null)
            return;
        printInOrder(subroot.getLeftChild());
        System.out.println(subroot.getWord()+ "   freq: "+subroot.getFreq());
        printInOrder(subroot.getRightChild());
    }
    public void printPostOrder() {
        printPostOrder(root);
    }
    private void printPostOrder(Node subroot) {
        if (subroot == null)
            return;
        printPostOrder(subroot.getLeftChild());
        printPostOrder(subroot.getRightChild());
        System.out.println(subroot.getWord()+ "   freq: "+subroot.getFreq());
    }

}
