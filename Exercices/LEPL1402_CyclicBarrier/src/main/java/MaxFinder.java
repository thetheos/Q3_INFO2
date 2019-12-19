

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
     * Run should compute the sums of a 2D-array and store the result in sums[] then wait for the cyclic barrier to get the result
     * And restart computing nThreads further
     */
    class Worker implements Runnable {
        private int row;
        private int sum = 0;
        private int round = 0;
        private int r;
        public Worker(int r){
            this.r = r;
        }

        @Override
        public void run() {
            while(round*nThreads+r < length){
                this.row = r + nThreads * round;
                sum = 0;
                for(int[] elm : data[row]){
                    for(int i : elm){
                        sum += i;
                    }
                }
                sums[r] = sum;
                round++;
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
	
    
    /*
     *
     * Initialize all the instance variable and start the right amount of Threads
     *
     */
    private MaxFinder(int[][][] matrix, int nThreads) throws InterruptedException{
        this.length = matrix.length;
        this.width = matrix[0].length;
        this.depth = matrix[0][0].length;
        this.nThreads = nThreads;
        this.data = matrix;
        this.sums = new int[nThreads];
        max = Integer.MIN_VALUE;
        barrier = new CyclicBarrier(nThreads, () -> {
            for(int i : sums){
                max =Math.max(max,i);
            }
        });

        Thread[] threads = new Thread[nThreads];
        for(int i = 0; i<nThreads;i++){
            threads[i] = new Thread(new Worker(i));
            threads[i].start();
        }

        // wait until done
        for (Thread thread : threads){
            thread.join();
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
