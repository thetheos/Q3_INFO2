
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;

    public abstract class FList<A> implements Iterable<A>{
        public Cons<A> head;
        public FList<A> tail;
        public Integer length = 0;

        public final boolean isNotEmpty() {
            return this instanceof Cons;
        }

        public final boolean isEmpty() {
            return this instanceof Nil;
        }

        public final int length() {
            return this.length;
        }

        public abstract A head();

        public abstract FList<A> tail();

        public static <A> FList<A> nil() {
            return (Nil<A>) Nil.INSTANCE;
        }

        public final FList<A> cons(final A a) {
            return new Cons(a, this);
        }

        public Iterator<A> iterator() {
            return new Iterator<A>() {
                private Cons<A> it = head;
                private Integer count = 0;
                public boolean hasNext() {
                    return (length>count++ && length>0);
                }
                public A next() {
                    if(length==0) throw new NoSuchElementException();
                    A val = it.head();
                    it = it.tail().head;
                    return val;
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };        }

        public static final class Nil<A> extends FList<A> {
            public static final Nil<Object> INSTANCE = new Nil();

            @Override
            public A head() {
                return null;
            }

            @Override
            public FList<A> tail() {
                return null;
            }

        }

        public static final class Cons<A> extends FList<A> {
            private A head;
            private FList<A> tail;

            public Cons(A a, FList as) {
                this.tail = as;
                this.head = a;
                this.length = as.length + 1;
            }


            @Override
            public A head() {
                return this.head;
            }

            @Override
            public FList<A> tail() {
                return this.tail;
            }
        }

    }

