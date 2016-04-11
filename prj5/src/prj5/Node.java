package prj5;

/**
 * Makes a node for the SortedLinkedList.
 * @author Lawrence Peczkowski-Soto
 * @author Lance Masters
 * @author Lindsey McCann.
 * @version <4/11/2016>
 * @param <E>
 */
public class Node<E> {
    private E data;
    private Node<E> next;
    
    /**
     * Constructor that makes a new Node
     * with just some data.
     * @param data is the data for this node.
     */
    public Node(E data) {
        this.data = data;
        next = null;
    }
    
    /**
     * Constructor that makes a new Node with
     * data and a reference to the next Node.
     * @param data is the data for this Node.
     * @param next is the reference to the next Node.
     */
    public Node(E data, Node next) {
        this.data = data;
        this.next = next;
    }
    
    /**
     * Gets the data for this Node.
     * @return Returns the data this Node contains.
     */
    public E getData() {
        return data;
    }
    
    /**
     * Gets the next Node.
     * @return Returns the next reference Node.
     */
    public Node<E> getNext() {
        return next;
    }
    
    /**
     * Changes the data of the Node.
     * @param data is the new data for this Node.
     */
    public void setData(E data) {
        this.data = data;
    }
    
    /**
     * Changes the next Node.
     * @param next is the new next Node for this Node.
     */
    public void setNext(Node<E> next) {
        this.next = next;
    }
}