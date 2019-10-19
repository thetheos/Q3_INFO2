import java.util.Stack;

import static java.lang.Math.pow;


public class TowerOfHanoi{

    /*
     * we want the tower to be moved from a to b.
     * The first value of n is the size of the stack.
     */
    public static void towerOfHanoi(int n, Stack<Disk> a, Stack<Disk> b, Stack<Disk> c) {
        if(n == 1){
            //Start to end
            b.push(a.pop());
        }else {
            towerOfHanoi(n - 1, a, c, b);
            b.push(a.pop());
            towerOfHanoi(n - 1, c, b, a);
        }
    }

    public static int numberOfMoves(int stackSize){
        return (int) (pow(2, stackSize)-1);
    }

}
