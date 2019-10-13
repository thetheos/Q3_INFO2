import java.util.Arrays;

public class largestSum {
    public static int sum(int[] sub){
        int sum = 0;
        for(int elm : sub){
            sum += elm;
        }
        return sum;
    }
    public static int[] findTheGreatestArr(int[] a){
        int greatestSum = -10000;
        int gretLo = 0;
        int greatHi = 0;
        int[] subArr;
        if(a.length == 1){
            int[] c = {a[0],0,0};
            return c;
        }
        for(int i = 0; i < a.length; i++){
            for(int j = i+1; j < a.length; j++){
                subArr = Arrays.copyOfRange(a,i,j);
                if(sum(subArr) > greatestSum){
                    greatestSum = sum(subArr);
                    gretLo = i;
                    greatHi = j-1;
                }
            }
        }
        int[] b = {greatestSum, gretLo, greatHi};
        return b;
    }

    public static int[] kadane(int[] a){
        int globalMax = a[0];
        int localMax = a[0];
        int lowIndex = 0;
        int tmpLowIndex = 0;
        int hiIndex = 0;

        for(int i = 1; i<a.length; i++){
            if(a[i]> localMax + a[i]){
                localMax = a[i];
                tmpLowIndex = i;
            }else{
                localMax += a[i];
            }
            if(localMax > globalMax){
                hiIndex = i;
                globalMax = localMax;
                lowIndex = tmpLowIndex;
            }
        }
        return new int[] {globalMax,lowIndex,hiIndex};
    }

    public static void main(String[] args) {
        int[] a = {-4,1,-4,-5};
        System.out.println(Arrays.toString(kadane(a)));
        System.out.print(Arrays.toString(findTheGreatestArr(a)));
    }

}
