package prj5;

import java.util.LinkedList;

public class SortedLinkedList<Glyph> extends LinkedList<Glyph> {
    //fields
    private Node<Glyph> head;
    private Node<Glyph> tail;
    private int size;
    private GlyphComparator<Glyph> comp;
    
    public SortedLinkedList() {
        head = null;
        tail = null;
        size = 0;
        comp = new GlyphComparator<Glyph>();
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
     * Gets the number of elements in the list.
     * @return Returns the number of elements in the list.
     */
    @Override
    public int size() {
        return size;
    }
    
    /**
     * Adds a new node to the sorted list. 
     * @param entry is the data being stored.
     * @return Returns true if the entry was successfully added to the list.
     * @throws NullPointerException if entry is equal to null;
     */
    @Override
    public boolean add(Glyph entry) {
        if (head == null) {
            head = new Node<Glyph>(entry);
            size++;
            return true;
        }
        else if (comp.compare(entry, head.getData()) < 0) {
            Node<Glyph> next = head;
            head = new Node<Glyph>(entry);
            head.setNext(next);
            size++;
            return true;
        }
        else {
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
}