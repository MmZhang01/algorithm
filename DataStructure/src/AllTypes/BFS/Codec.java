package AllTypes.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Codec{

    // Encodes a tree to a single string.

    public String serialize(TreeNode root) {
        // use string to represent null
        // use " " to split node
        if(root== null) return "n";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node==null){
                res.append("n ");
                continue;
            }
            res.append(node.val+" ");
            queue.add(node.left);
            queue.add(node.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("n")) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        for(int i=1;i< values.length;i++){
            TreeNode node = queue.poll();
            // use two pointers to add left tree and right tree for the node
            if(!values[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                node.left= left;
                queue.add(left);
            }
            if(!values[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                node.right = right;
                queue.add(right);
            }
        }
        return root;

    }
}
