
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class MyArrayList<Item> implements Iterable<Item>{

    private Object [] list;
    private int size;

    private class Node{
        private Item item;
        private Node next;

        Node(Item item){
            this.item = item;
            this.next = null;
        }
    }

    public MyArrayList(int initSize){
        if(initSize<0) throw new IndexOutOfBoundsException();
        list = new Object[initSize];
    }


    /*
    * Checks if 'list' needs to be resized then add the element at the end 
    * of the list.
    */
    public void enqueue(Item item){
        if(size == list.length) checkSize();
        list[size++] = item;
    }

    public void checkSize(){
        Object[] newList = new Object[size*2];
        for(int i = 0; i<size;i++){
            newList[i] = list[i];
        }
        list = newList;
    }


    /*
    * Removes the element at the specified position in this list.
    * Returns the element that was removed from the list. You dont need to 
    * resize when removing an element.
    */
    public Item remove(int index){
        if(index > size-1 || index < 0) throw new IndexOutOfBoundsException();
        Object tmp = list[index];
        list[index] = null;
        for(int i = index;i<size-1; i++){
            list[i] = list[i+1];
            list[i+1]=null;
        }
        size--;
        return (Item) tmp;
    }


    public int size(){
        return this.size;
    }


    @Override
    public Iterator<Item> iterator() {
        return new MyArrayListIterator();
    }


    private class MyArrayListIterator implements Iterator<Item> {
        int count = 0;
        private int n = size;
        MyArrayListIterator(){

        }
        private void failfast(){
            if(n!=size) throw new ConcurrentModificationException();
        }

        public Item next(){
            failfast();
            if(hasNext()){
                return (Item) list[count++];
            }
            return null;
        }

        public boolean hasNext(){
            return count<size;
        }

    }
}