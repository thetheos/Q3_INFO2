import java.util.BitSet;

public class Sieve{

    public static void main(String[] args) {
        numberOfPrime(20);
    }
    
    public static int numberOfPrime(int n){
        BitSet bs = new BitSet(n);
        bs.flip(2,n);
        for(int i = 2; i<Math.sqrt(n); i++){
            if(bs.get(i)){
                for(int j=i*i; j<n ; j+=i){
                    bs.set(j, false);
                }
            }
        }
        return bs.cardinality();
    }
    
}