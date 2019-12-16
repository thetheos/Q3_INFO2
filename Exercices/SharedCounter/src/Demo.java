class SharedCounter {
    private int counter = 0;
    private Object lock = null;

    public void inc() {
        synchronized (this) {
            while (lock != null) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock = new Object();
            counter++;
            lock = null;
            this.notify();
        }
    }

    public void dec() {
        synchronized (this) {
            while (lock != null || counter == 0) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock = new Object();
            counter--;
            lock = null;
            this.notify();
        }
    }

    public int get(){
        return counter;
    }

}

class notSharedCounter{
    private int counter = 0;

    public void inc(){
        synchronized(this){
            counter++;
            this.notify();
        }
    }

    public void dec(){
        synchronized (this){
            while(counter ==0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            counter--;
        }
    }

    public int get(){
        return counter;
    }

}

public class Demo{
    public static void main(String[] args) {
        notSharedCounter counter = new notSharedCounter();
        /*ExecutorService executor = Executors.newFixedThreadPool(2);
        for(int i = 0; i<1000;i++){
        Future<?> f1 = executor.submit(counter::inc);
        Future<?> f2 = executor.submit(counter::inc);
            try {
                f1.get();
                f2.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println(counter.get());*/

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<1000000; i++) {
                    counter.inc();
                }
            }
        }

        );

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<1000000; i++) {
                    counter.dec();
                }
            }
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.get());
    }

}
