package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    public static void preorder(TreeNode root){
        if(root==null){return;}
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    /*
    144. Binary Tree Preorder Traversal (Medium)
    use iterative method
     */
    public static List<Integer> preorderTraversal(TreeNode root){
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node= stack.pop();
//            if(node==null){continue;}
            ret.add(node.val);
            if(node.right!=null){stack.push(node.right);}
            if(node.left!=null){stack.push(node.left);}

        }
        return ret;
    }
}
