package Tree;

public class Tree {

    /**
     * 104. Maximum Depth of Binary Tree (Easy)
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 110. Balanced Binary Tree (Easy)
     */
    private boolean result =true;

    public boolean isBalanced(TreeNode root){
        compareDepth(root);
        return result;
    }

    public int compareDepth(TreeNode root){
        if (root == null) return 0;
        int l =compareDepth(root.left);
        int r = compareDepth(root.right);
        if (Math.abs(l-r)>1){
            result=false;
        }
        return Math.max(l,r)+1;
    }


}
