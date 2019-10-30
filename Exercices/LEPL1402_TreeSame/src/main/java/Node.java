public class Node {

    public int val;
    public Node left;
    public Node right;

    public Node(int val){
        this.val = val;
    }

    public boolean isLeaf(){
        return this.left == null && this.right == null;
    }

    @Override
    public boolean equals(Object o){
        Node tmp = (Node) o;
        if(tmp.isLeaf() && this.isLeaf() && tmp.val == this.val) return true;
        if(tmp.isLeaf() && this.isLeaf() && tmp.val != this.val) return false;
        return tmp.val == this.val && tmp.left.equals(this.left) && tmp.right.equals(this.right);
    }
}