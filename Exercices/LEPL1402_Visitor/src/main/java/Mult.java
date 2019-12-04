public class Mult extends Node implements Visitable {
    public Mult(Visitable left, Visitable right) {
        super(left, right);
    }

    @Override
    public int accept(Visitor visitor) {
        return this.getLeft().accept(visitor)*this.getRight().accept(visitor);
    }
    // YOUR CODE HERE
}
