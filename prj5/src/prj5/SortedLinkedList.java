package prj5;

import java.util.LinkedList;

public class SortedLinkedList<Glyph> extends LinkedList<Glyph> {
    //fields
    private Node<Glyph> head;
    private Node<Glyph> tail;
    private int size;
    private GlyphComparator comp;
    
    public SortedLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    
    public boolean add(Glyph entry) {
        //TODO 
        return false;
    }
    
    
}