import java.util.ConcurrentModificationException;
import java.util.Iterator;


public class CircularLinkedList<Item> implements Iterable<Item> {

    private int n;          // size of the list
    private Node last;   // trailer of the list

    // helper linked list class
    private class Node {

        private Item item;
        private Node next;

        private Node(Item item){
            this.item = item;
            this.next = null;
        }

    }

    public CircularLinkedList() {
        last = null;
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public Node getLast(){
        return last;
    }

    public Item getItem(Node n){
        return n.item;
    }



    /**
     * Append an item at the end of the list
     * @param item the item to append
     */
    public void enqueue(Item item) {
        Node current = new Node(item);
        if(isEmpty()){
            last = current;
            current.next = last;
        }else{
            current.next = last.next;
            last.next = current;
            last = current;
        }
        n++;
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     */
    public Item remove(int index) {
        if(index < 0 || index >= n) throw new IndexOutOfBoundsException();
        Item rmvitem;
        if(index == 0){
            rmvitem = last.next.item;
            last.next = last.next.next;
        }else {
            Node tmpNode = last.next;
            for(int i = 0; i<index-1;i++){
                tmpNode = tmpNode.next;
            }
            if(tmpNode.next == last){
                rmvitem = tmpNode.next.item;
                tmpNode.next = last.next;
                last = tmpNode;
            }else {
                rmvitem = tmpNode.next.item;
                tmpNode.next = tmpNode.next.next;
            }
        }
        n--;
        return rmvitem;
    }


    /**
     * Returns an iterator that iterates through the items in FIFO order.
     * @return an iterator that iterates through the items in FIFO order.
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    /**
     * Implementation of an iterator that iterates through the items in FIFO order.
     *
     */
    private class ListIterator implements Iterator<Item> {
        private final int size = n;
        private int count = 0;
        Node firstNode;
        ListIterator(){
            firstNode = last;
        }

        private boolean failFastCheck() {
            if (n != size)
                throw new ConcurrentModificationException("bag modified while iterating on it");
            return true;
        }


        public Item next(){
            failFastCheck();
            if(!hasNext()) throw new IndexOutOfBoundsException();
            Item itm = firstNode.next.item;
            firstNode = firstNode.next;
            count++;
            return itm;
        }

        public boolean hasNext(){
            return count < size;
        }
    }


}