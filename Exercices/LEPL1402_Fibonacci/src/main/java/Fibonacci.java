public class Fibonacci {


    public static int fiboRecursive(int index){
        if(index == 0) return 0;
        else if(index == 1) return 1;
        else return fiboRecursive(index - 2) + fiboRecursive(index -1);
    }


    public static int fiboIterative(int index){
        int[] fibo = new int[3];
        fibo[0] = 0;
        fibo[1] = 1;
        for(int i = 0; i<index; i++){
            fibo[2] = fibo[0] + fibo[1];
            fibo[0] = fibo[1];
            fibo[1] = fibo[2];
        }
        return fibo[0];
    }

}
