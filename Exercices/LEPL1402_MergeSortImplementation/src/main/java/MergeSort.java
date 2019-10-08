import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    /**
     * Merge the array from lo to hi
     */
    /**
    private static void merge(int[] a, int lo, int mid, int hi) {
        int[] subArr = Arrays.copyOfRange(a, lo, hi);
        sort(subArr);
    }
    **/
    private static void merge(int[] a, int lo, int mid, int hi) {

        int[] subArr = Arrays.copyOfRange(a, lo, hi);
        sort(subArr);
    }

    public static void sort(int[] a) {
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        for(int i = 0; i<a.length; i++){
            if(i<(a.length)/2){
                left.add(a[i]);
            }else{
                right.add(a[i]);
            }
        }
        left = sort(left);
    }

    /**
     *  Split the array and call merge

    public static void sort(int[] a) {
        boolean sorted = false;
        for(int i = 0 ; i <a.length; i++){
            for(int j = 1; j<a.length; j++){
                if(a[j-1] > a[j]){
                    swap(a, j-1, j);
                }
            }
        }
    }
     */
    public static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    //TODO Optionnal additionnal method


}
