public class Cons {
    // the item inside this list node
    public int v;
    // The next element, null if nothing
    public Cons next;
    // creates a new Cons that applies function f on all elements
    /*
    public Cons map(F f) {
        Cons headMappedCons = null;
        Cons crtMappedCons= new Cons(0,null);
        while(next != null){
           if(headMappedCons == null) headMappedCons = new Cons(f.apply(v), crtMappedCons);
           else if (crtMappedCons == null) {
               crtMappedCons = new Cons(f.apply(v), null);
               crtMappedCons = crtMappedCons.next;
           }
           next = next.next;
        }
        return headMappedCons;
    }

    */

    public Cons map(F f){
        Cons head = null;
        Cons crtNext = null;
        Cons displacementCons = this;
        while(displacementCons != null){
            if(head == null ) {
                head = new Cons(f.apply(v), null);
                crtNext = head;
            }
            else{
                crtNext.next = new Cons(f.apply(displacementCons.v), null);
                crtNext = crtNext.next;
            }
            displacementCons = displacementCons.next;
        }
        return head;
    }
    // creates a new Cons with all elements that matches predicate p
    public Cons filter(P p) {
        Cons headCons  = null;
        Cons crtCons = null;
        while(next != null){
            if(p.filter(v)){
                if(headCons == null) headCons = new Cons(v, crtCons);
                else if (crtCons == null) {
                    crtCons = new Cons(v, null);
                    crtCons = crtCons.next;
                }
            }
            next = next.next;
        }
        return headCons;
    }
    // Constructor
    public Cons(int v, Cons next) {
        this.v = v;
        this.next = next;
    }
}