public class FListMerge {

    /*
     * This method receives an FList and returns the FList containing the same values but sorted with the smallest value to the highest one.
     *
     */
    public static FList<Integer> mergeSort(FList<Integer> fList){
        if(fList.length() == 1) return fList;

        FList<Integer> firstHalf = new FList.Nil<>();
        FList<Integer> lastHalf = new FList.Nil<>();
        FList<Integer> current = fList;
        for(int i = 0; i < fList.length()/2; i++){
            firstHalf = firstHalf.cons(current.head());
            current = current.tail();
        }
        lastHalf = current;

        FList<Integer> currentFirstHalf;
        FList<Integer> currentLastHalf;

        currentFirstHalf = mergeSort(firstHalf);
        currentLastHalf = mergeSort(lastHalf);

        FList<Integer> sorted = FList.nil();
        /*
        for(int i = 0; i<currentFirstHalf.length();i++ ){
            if(currentFirstHalf.head() < currentLastHalf.head()){
                sorted = sorted.cons(currentLastHalf.head());
            }else{
                sorted = sorted.cons(currentFirstHalf.head());
            }
        }
        */
        while(!currentFirstHalf.isEmpty() || !currentLastHalf.isEmpty()){
            if(currentLastHalf.isEmpty() || (!currentFirstHalf.isEmpty() && currentFirstHalf.head() < currentLastHalf.head())){
                sorted = sorted.cons(currentFirstHalf.head());
                currentFirstHalf = currentFirstHalf.tail();
            }else{
                sorted = sorted.cons(currentLastHalf.head());
                currentLastHalf = currentLastHalf.tail();
            }
        }
        return reverse(sorted);

    }

    public static FList<Integer> reverse(FList<Integer> fList){
        FList<Integer> reversed = FList.nil();
        while(!fList.isEmpty()){
            reversed = reversed.cons(fList.head());
            fList = fList.tail();
        }
        return reversed;
    }

    //TO Complete if needed
}
