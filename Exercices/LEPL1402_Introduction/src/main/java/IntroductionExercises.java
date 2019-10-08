public class IntroductionExercises {

    public static int variable = 0;

    public static int[] squares;

    /*
     * Function that bound variable to value
     */
    public static void attribute(int value){
        variable = value;
    }

    /*
     * Function that return the addition of the two parameters
     */
    public static int add(int a, int b){
        return a+b;
    }
    /*
     * return true is a and b are equal
     */
    public static boolean equalsIntegers(int a, int b){
        if(a == b){
            return true;
        }else{
            return false;
        }
    }
    /*
     * Function that return the max between a and b
     * You must use a ternary operation
     */
    public static int max(int a, int b){
        return (a>b) ? a : b;
    }

    /*
     * Function that return the middle value.
     * If a > b > c, the function must return b.
     * If two value are equals, return -1.
     */
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
    /*
     * This function must return :
     * "Good morning, sir!" if str is "Morning"
     * "Good evening, sir!" if str is "Evening"
     * "Hello, sir!" otherwise
     * Use a switch case statement
     * Your implementation must be case sensitive
     */
    public static String greetings(String str){
        switch(str){
            case "Morning":
                return "Good morning, sir!";
            case "Evening":
                return "Good evening, sir!";
            default:
                return "Hello, sir!";
        }
    }
    /*
     * This function must return a new array of length 3
     * The first element of this new array is the last element of a
     * The second element is the first element of a
     * The last element is the middle element of a
     */
    public static int[] lastFirstMiddle(int[] a){
        int[] b = {a[a.length-1], a[0], a[a.length/2]};
        return b;
    }

    /*
     * This function must return the sum of the elements of array using a for loop
     */
    public static int sum(int[] array){
        int sum = 0;
        for(int i : array){
            sum += i;
        }
        return sum;
    }

    /*
     * return the maximum element of array using a while loop
     */
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
    /*
     * Using the argument of the program
     * Bound the variable squares with the square of
     * the elements passed in argument.
     * Look at the java API : https://docs.oracle.com/javase/8/docs/api/index.html
     * If an exception occurs, assign the value 0 at the index where its occurs
     */
    public static void main(String... args){
        squares = new int[args.length];
        for(int i = 0 ; i<args.length; i++){
            try{
                squares[i] = Integer.parseInt(args[i]) * Integer.parseInt(args[i]);
            }catch (Exception e){
                squares[i] = 0;
            }
        }
    }

}
