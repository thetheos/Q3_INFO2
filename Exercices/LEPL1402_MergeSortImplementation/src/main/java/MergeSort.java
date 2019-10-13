import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    /**
     * Merge the array from lo to hi
     */
    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        int j = mid + 1;
        int i = lo;
        for(int k = lo; k<= hi; k++){
            if(i > mid) a[k] = aux[j++];
            else if(j>hi) a[k] = aux[i++];
            else if(aux[j]<= aux[i]) a[k] = aux[j++];
            else a[k] = aux[i++];
        }

    }

    public static void sort(int[] a) {
        sort(a,0, a.length -1);
    }

    public static void sort(int[] a, int lo, int hi){
        if(lo >= hi) return;
        int mid = lo + (hi-lo)/2;
        sort(a, lo ,mid);
        sort(a,mid+1, hi);
        int[] b = a.clone();
        merge(a,b, lo, mid, hi);
    }
    public static void main(String[] args) {
        int[] a = {1,5,8,2,3,7};
        int[] b ={1,5,8,2,3,7};
        sort(a);
        System.out.print(Arrays.toString(a));
    }
    //TODO Optionnal additionnal method


}
