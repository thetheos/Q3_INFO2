
public class Search {

    /**
     *
     * @param tab
     * @return
     */
    public static int search(int[] tab, int elem){
        boolean found = false;
        int lowerBound = 0;
        int upperBound = tab.length -1;
        int m = 0;
        while(lowerBound <= upperBound){
            m = (int) Math.floor((lowerBound + upperBound)/2);
            if(tab[m] < elem){
                lowerBound = m + 1;
            }else if(tab[m] > elem){
                upperBound = m - 1;
            }else{
                return m;
            }
        }

        return -1;
    }
}
