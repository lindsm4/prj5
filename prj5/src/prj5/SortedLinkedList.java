package prj5;

import java.util.LinkedList;

public class SortedLinkedList<Glyph> extends LinkedList<Glyph> {

    //fields
    private static final long serialVersionUID = 1L;
    private Node<Glyph> head;
    private int size;
    private GlyphComparator<Glyph> comp;
    
    /**
     * Default constructor.
     */
    public SortedLinkedList() {
        head = null;
        size = 0;
        comp = new GlyphComparator<Glyph>();
    }
    
    /**
     * Adds a new node to the sorted list. 
     * @param entry is the data being stored.
     * @return Returns true if the entry was successfully added to the list.
     * @throws NullPointerException if entry is equal to null;
     */
    @Override
    public boolean add(Glyph entry) {
        if (isEmpty()) { 
            head = new Node<Glyph>(entry);
            size++;
            return true;
        }
        else if (comp.compare(entry, head.getData()) < 0) { //if entry should go before head
            Node<Glyph> next = head;
            head = new Node<Glyph>(entry);
            head.setNext(next);
            size++;
            return true;
        }
        else {
            Node<Glyph> curr = head;
            
            while (comp.compare(entry, curr.getData()) >= 0) {
                curr = curr.getNext();
            }
            Node<Glyph> newNode = new Node<Glyph>(entry);
            newNode.setNext(curr.getNext());
            curr.setNext(newNode);
            
            
            Node<Glyph> curr = head.getNext();
            Node<Glyph> prev = head;
            if (curr != null) {
                while (comp.compare(entry, curr.getData()) >= 0) {
                    curr = curr.getNext();
                    prev = prev.getNext();
                    if (curr == null)
                    {
                        break;
                    }
                }
                Node<Glyph> newNode = new Node<Glyph>(entry);

                newNode.setNext(curr);
                prev.setNext(newNode); 
                
            }
            else {
                prev.setNext(new Node<Glyph>(entry));
            }
            size++;
            return true;
        }
    }
    
    /**
     * Clears the list.
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    }
    
    /**
     * Check if another object equals this list.
     * @param other is the other object being compared to.
     * @return Returns true if the other object is the same class,
     * the lengths are the same, and if the each entry is the value in
     * the same order.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        else if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        else {
            @SuppressWarnings("unchecked")
            SortedLinkedList<Glyph> otherList = (SortedLinkedList<Glyph>) other;
            if (this.size() != otherList.size()) {
                return false;
            }
            else {
                for (int i = 0; i < this.size(); i++) {
                    if (!this.get(i).equals(otherList.get(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
    }
    
    /**
     * Returns an element in a specified position in the list.
     * @param index if the number.
     * @return Returns the element in the specified position.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    @Override
    public Glyph get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        else {
            Node<Glyph> temp = head;
            int counter = 0;
            while (counter != index) {
                temp = temp.getNext();
                counter++;
            }
            return temp.getData();
        }
    }
    
    /**
     * Checks if the list is empty.
     * @return Returns true is the head node is null.
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }
   
    /**
     * Removes a specific entry from the list.
     * @param entry is the entry trying to be deleted.
     * @return Returns true if successfully removes the data.
     */
    @Override
    public boolean remove(Object entry) {
        if (isEmpty()) {         
            return false;
        }
        else if (entry.getClass() != head.getData().getClass()) {
            return false;
        }
        else {
            @SuppressWarnings("unchecked")
            Glyph data = (Glyph) entry;
            Node<Glyph> curr = head;
            
            if (head.getData().equals(data)) {
                head = head.getNext();
                size--;
                return true;
            }
            
            while (curr != null) {
                if (curr.getData().equals(data)) {
                    (curr.getPrev()).setNext(curr.getNext());
                    size--;
                    return true;
                }
                curr = curr.getNext();
            }
            return false;
        }
        
    }

    /**
     * Gets the number of elements in the list.
     * @return Returns the number of elements in the list.
     */
    @Override
    public int size() {
        return size;
    }
    
    /**
     * Converts the list to an array.
     * @return Returns an array of the entries in the list.
     */
    @Override
    public Object[] toArray() {
        Object[] ret = new Object[size];
        for (int i = 0; i < size; i++) {
            ret[i] = this.get(i);
        }
        
        return ret;
    }
}