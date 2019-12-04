import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;

public abstract class FList<A> implements Iterable<A> {
    public Cons<A> head;
    public FList<A> tail;
    public Integer length = 0;
    /**
     * Returns an empty FList
     */
    public static <A> FList<A> nil() {
        return (Nil<A>) Nil.INSTANCE;
    }

    /**
     * Creates a new list with a prepended to this list
     */
    public final FList<A> cons(final A a) {
        return new Cons(a, this);
    }

    /**
     * @return the number of elements in the list
     */
    public abstract int length();

    /**
     * @return true if the list is empty, false otherwise
     */
    public abstract boolean isEmpty();

    /**
     * @return the head of the list.
     * Throws NoSuchElementException if the list is empty
     */
    public abstract A head();

    /**
     * @return the tail of the list (i.e. the sublist without the first element of this list)
     * Throws NoSuchElementException if the list is empty
     */
    public abstract FList<A> tail();

    /**
     * Returns a new list with the output of the function f applied to each element of this list
     */
    public abstract <B> FList<B> map(Function<A,B> f);

    /**
     * Creates a new list with only the element that fullfill the predicate f (i.e. f(elem) == true).
     */
    public abstract FList<A> filter(Predicate<A> f);


    public Iterator<A> iterator() {
        return new Iterator<A>() {
            private Cons<A> it = head;
            private Integer count = 0;
            //private Integer crtLen = length;
            public boolean hasNext() {
                return (length>count++ && length>0);
            }
            public A next() {
                if(length==0) throw new NoSuchElementException();
                A val = it.value;
                it = it.tail().head;
                return val;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }


    private static final class Nil<A> extends FList<A> {
        public static final Nil<Object> INSTANCE = new Nil();

        @Override
        public int length() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public A head() {
            return null;
        }

        @Override
        public FList<A> tail() {
            return null;
        }

        @Override
        public <B> FList<B> map(Function<A, B> f) {
            return (FList<B>) INSTANCE;
        }

        @Override
        public FList<A> filter(Predicate<A> f) {
            return (FList<A>) INSTANCE;
        }

    }

    private static final class Cons<A> extends FList<A> {
        public A value;
        public Cons(A a, FList as) {
            this.head = this;
            this.tail = as;
            this.value = a;
            this.length = as.length + 1;
        }

        @Override
        public int length() {
            return this.length;
        }

        @Override
        public boolean isEmpty() {
            return this.length == 0;
        }

        @Override
        public A head() {
            return this.head.value;
        }

        @Override
        public FList<A> tail() {
            return this.tail;
        }

        @Override
        public <B> FList<B> map(Function<A, B> f) {
            FList<B> newFlist = new FList.Cons<>(f.apply(value),tail.map(f));
            return newFlist;
        }

        @Override
        public FList<A> filter(Predicate<A> f) {
            FList<A> newFlist= new FList.Nil() ;
            if(f.test(value)){
                return new Cons<>(value,tail.filter(f));
            }else{
                return tail.filter(f);
            }
        }

    }

}