public class VisitableList extends Visitable {
    public VisitableList(Object[] o){
        elements = o;
    }
    @Override
    void accept(Visitor visitor) {
        for(Object o : elements){
            visitor.visit(o);
        }
    }
}
