public class Leaf implements Visitable {
    private int value = 0;
    public Leaf(int i){
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public int accept(Visitor visitor) {
        return this.value;
    }
}
