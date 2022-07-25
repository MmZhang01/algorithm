package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
    public static void postorder(TreeNode root){
        if(root==null){return;}
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.val);
    }

    /*
    145. Binary Tree Postorder Traversal (Medium)
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            ret.add(node.val);
            stack.push(node.left);
            stack.push(node.right);
        }
        Collections.reverse(ret);
        return ret;
    }
}
