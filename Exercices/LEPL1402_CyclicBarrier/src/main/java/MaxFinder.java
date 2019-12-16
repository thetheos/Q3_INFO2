

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MaxFinder {

    private final int nThreads,length,width,depth;
    private final int[][][] data;
    private final CyclicBarrier barrier;
    private int[] sums;
    private int max;

    /*
     * Worker constructor takes only one parameter int r, which is his associated row number
     * A worker is responsible of the calculation of the sum of each 2D-Array with row == r + nThread * round; with round >= 0
     *
     * Run should compute the sum of a 2D-array and store the result in sums[] then wait for the cyclic barrier to get the result
     * And restart computing nThreads further
     */
    class Worker implements Runnable {
        private final int row;
        private int sum = 0;

        public Worker(int r){
            this.row = r;
        }

        @Override
        public void run() {

            for(int[] elm : data[row]){
                for(int i : elm){
                    sum += i;
                }
            }
            sums[row] = sum;

            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        //TODO by student
        
    }
	
    
    /*
     *
     * Initialize all the instance variable and start the right amount of Threads
     *
     */
    private MaxFinder(int[][][] matrix, int nThreads) throws InterruptedException{
        this.depth = matrix.length;
        this.width = matrix[0].length;
        this.length = matrix[0][0].length;
        this.nThreads = nThreads;
        this.data = matrix;
        this.sums = new int[this.depth];

        barrier = new CyclicBarrier(nThreads, () -> {
            max = sums[0];
            for(int i : sums){
                if(i> max) max = i;
            }
        });

        int count=0;
        int maxDepth = this.depth;
        while(maxDepth != 0) {



            if(maxDepth - count<0) count = maxDepth;
            else count = nThreads;
            maxDepth -= count;
            Thread[] threads = new Thread[count];
            //List<Thread> threads = new ArrayList<Thread>(count);

            for (int i = 0; i < count; i++) {
                Thread thread = new Thread(new Worker(i));
                threads[i] = thread;
                thread.start();
            }

            // wait until done
            for (Thread thread : threads){
                thread.join();
            }

        }
    }
    /*
    * subSize is the length of the subarray
    * rowSize is the rowlength for all the array
    *
    */
    public static int getMaxSum(int[][][] matrix, int nThreads){
        try{
            MaxFinder mf = new MaxFinder(matrix, nThreads);
            return mf.max;
        }catch(InterruptedException e){
            return -1;
        }

    }
}
