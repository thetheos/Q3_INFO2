

public class IntroductionExercises {

    public static int variable = 0;

    public static int[] squares;
    public static void main(String[] val){
        attribute(7);
        System.out.println(variable);
        System.out.println(add(7,7));
        System.out.println(equalsIntegers(7,9));
        System.out.println(middleValue(7,11,9));
        int[] a = {1,2,3};
        System.out.println(sum(a));
        return;
    }

    public static void attribute(int value){
        variable = value;
    }


    public static int add(int a, int b){
        return a+b;
    }

    public static boolean equalsIntegers(int a, int b){
        if(a == b){
            return true;
        }else{
            return false;
        }
    }

    public static int middleValue(int a, int b, int c){
        if((c > b && a < b) || (a > b && c < b)){
            return b ;
        }else if((a > b && a < c ) || (a>c && a < b) ){
            return a;
        }else if((c > a && c<b)|| (c>b && c<a) ){
            return c;
        }
        return -1;
    }

    public static int max(int a, int b){
        return (a>b) ? a : b;
    }



    public static String greetings(String str){
        if(str == "Morning"){
            return "Good morning, sir!";
        }else if (str == "Evening"){
            return "Good evening, sir!";
        }
        return "Hello, sir!";
    }

    public static int[] lastFirstMiddle(int[] a){
        int[] b = {a[a.length-1], a[0], a[a.length/2]};
        return b;
    }

    public static int sum(int[] array){
        int sum = 0;
        for(int i : array){
            sum += i;
        }
        return sum;
    }

    public static int maxArray(int[] array){
        int lenght = array.length;
        int i = 0;
        int maxValue =0;

        while(i < lenght){
            if(array[i]>maxValue){
                maxValue = array[i];
            }
        }
        return maxValue;
    }


}
