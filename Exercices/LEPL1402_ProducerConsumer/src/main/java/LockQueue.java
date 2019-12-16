
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockQueue {

    public final static int SIZE = 100;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public int head = 0;
    public int tail = 0;
    public final Integer [] cells = new Integer[SIZE];
    public int count = 0;



    public Integer dequeue() {
        lock.lock();
        try{
            while (this.empty())
                notFull.await();
            if(this.    tail == SIZE) tail = 0;
            count--;
            int val = cells[tail++];
            notEmpty.signal();
            return val;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }finally {
            lock.unlock();
        }
    }


    public void enqueue(Integer i) {
        lock.lock();
        try{
            while(this.full())
                notEmpty.await();

            if(this.head == SIZE) head = 0;
            cells[head++] = i;
            count++;
            notFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public boolean full(){
        return this.count == SIZE;
    }

    public boolean empty(){
        return this.head == this.tail;
    }

    public int size() { return this.tail - this.head; }

}

