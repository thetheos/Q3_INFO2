public class Tree {

    public Node root;

    public Tree(Node root){
        this.root = root;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Tree)) return false;
        Tree tmp = (Tree) o;
        if(this.root == null && tmp.root == null) return true;
        if(this.root == null && tmp.root != null) return false;
        return this.root.equals(tmp.root);
    }

}