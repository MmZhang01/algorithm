package Tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637. Average of Levels in Binary Tree (Easy)
 */
public class LevelTraversal {
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int cnt = queue.size();
            double sum = 0;
            for (int i = 0; i < cnt; i++) {
                TreeNode node = queue.poll();
                sum+=node.val;
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            ret.add(sum/cnt);
        }
        return ret;
    }

    /**
     * 513. Find Bottom Left Tree Value (Easy)
     */
    public static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        int output= root.val;
        while (!queue.isEmpty()){
            root = queue.poll();
            if(root.left!=null){
                queue.add(root.left);
                output=root.left.val;
            }
            if(root.right!=null){
                queue.add(root.right);
            }
        }
        return output;
    }
}

