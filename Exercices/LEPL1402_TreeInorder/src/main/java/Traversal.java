import java.util.List;
import java.util.Stack; // this should give you a hint for the iterative version

public class Traversal {

    public static void recursiveInorder(Node root, List<Integer> res) {
        if(root.isLeaf()){
            res.add(root.val);
            return;
        }

        if(root.left != null) recursiveInorder(root.left, res);
        res.add(root.val);
        if(root.right != null) recursiveInorder(root.right, res);
    }


    public static void iterativeInorder(Node root, List<Integer> res){
        Stack<Node> tmp = new Stack<Node>();
        while (root!=null || tmp.size()>0){
            while(root!= null){
                tmp.push(root);
                root = root.left;
            }
            root = tmp.pop();
            res.add(root.val);
            root = root.right;
        }
    }


}
