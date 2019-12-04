public class Div extends Node implements Visitable {
    public Div(Visitable left, Visitable right) {
        super(left, right);
    }

    @Override
    public int accept(Visitor visitor) {
        if(this.getRight() instanceof Leaf){
            if(((Leaf) this.getRight()).getValue() == 0){
                throw new IllegalArgumentException();
            }
        }
        return this.getLeft().accept(visitor) / this.getRight().accept(visitor);
    }
    // YOUR CODE HERE
}
