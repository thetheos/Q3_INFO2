public class Tree {

    public Node root;

    public Tree(Node root){
        this.root = root;
    }

    public Tree combineWith(Tree o){
        if(o==null) return this;
        return  new Tree(mergeTree(this.root,o.root));
    }

    public Node mergeTree(Node t1, Node t2){
        if(t1 == null && t2 == null) return null;
        Node newNode = new Node(0);
        if(t1 == null){
            newNode = t2;
        }else if(t2 == null){
            newNode = t1;
        }else {
            newNode.val += t1.val + t2.val;
            newNode.right = mergeTree(t1.right, t2.right);
            newNode.left = mergeTree(t1.left, t2.left);
        }
        return newNode;
    }
}