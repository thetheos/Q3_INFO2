import java.util.Arrays;
import java.util.Stack;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class MyQueue<E> {

    Stack<E> s1;
    Stack<E> s2;

    private E front;

    /*
     * Constructor
     */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        this.front = null;
    }

    public void enqueue(E elem) {
      s1.push(elem);
    }

    public E dequeue() {
      return s1.remove(0);
    }

    public E peek() {
      return s1.get(0);
    }

    public boolean empty() {
        return s1.size() == 0;
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        Supplier<Integer> rnd = () -> (int) (Math.random() * 100);


        Integer [] seeds = Stream.generate(rnd).limit(100).toArray(Integer[]::new);
        Arrays.stream(seeds).forEach(queue::enqueue);

        for(int i=0; i < 100; i++){
            System.out.println("Seed " + seeds[i]);
            System.out.println("Queue " + queue.dequeue());
        }

    }

}
