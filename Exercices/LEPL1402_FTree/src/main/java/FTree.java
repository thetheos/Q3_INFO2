import java.util.function.Function;

public abstract class FTree<A> {

    public final int depth() {/*
        FTree it = this.left();
        Integer depth = 1;
        while(it instanceof Node){
            it = it.left();
            depth++;
        }
        return depth;*/

        if(this instanceof Leaf) return 0;
        return left().depth() + 1;
    }

    public abstract A value();
    public abstract FTree<A> left();
    public abstract FTree<A> right();

    public final <B> FTree<B> map(Function<A,B> f) {
        if(left()==null && right()==null) return new Leaf(f.apply(value()));
        if(right() == null) return new Node(f.apply(value()),left().map(f),null);
        if(left() == null) return new Node(f.apply(value()),null,right().map(f));
        else return new Node(f.apply(value()),left().map(f),right().map(f));
    }


}
