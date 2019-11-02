import java.util.function.Predicate;
import java.util.function.Function;

public class Cons<E> {
    // the item inside this list node
    public E v;
    // The next element, null if nothing
    public Cons<E> next;
    // Constructor
    public Cons(E v, Cons<E> next) {
        this.v = v;
        this.next = next;
    }

    public <R> Cons <R> map(Function <E,R> function) {
        Cons<R> head = null;
        Cons<R> crtNext = null;
        Cons<E> displacementCons = this;
        while(displacementCons != null){
            if(head == null ) {
                head = new Cons(function.apply(v), null);
                crtNext = head;
            }
            else{
                crtNext.next = new Cons(function.apply(displacementCons.v), null);
                crtNext = crtNext.next;
            }
            displacementCons = displacementCons.next;
        }
        return head;
    }

    public Cons <E> filter(Predicate <E> predicate) {
        Cons<E> head = null;
        Cons<E> crtNext = null;
        Cons<E> displacementCons = this;
        while(displacementCons != null) {
            if (predicate.test(displacementCons.v)){
                if (head == null) {
                    head = new Cons(displacementCons.v, null);
                    crtNext = head;
                } else {
                    crtNext.next = new Cons(displacementCons.v, null);
                    crtNext = crtNext.next;
                }
            }
            displacementCons = displacementCons.next;
        }
        return head;
    } 
}
