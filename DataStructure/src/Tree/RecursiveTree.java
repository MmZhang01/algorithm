package Tree;

public class RecursiveTree {

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

    /**
     * 543. Diameter of Binary Tree (Easy)
     */
    private int max=0;
    public int diameterOfBinaryTree(TreeNode root){
       depth(root);
       return max;
    }

    public int depth(TreeNode root){
        if(root==null){return 0;}
        int leftdepth = depth(root.left);
        int rightdepth = depth(root.right);
        max = Math.max(max,leftdepth+rightdepth);
        return Math.max(leftdepth,rightdepth)+1;
    }

    /**
     * 226. Invert Binary Tree (Easy)
     */
    public TreeNode inverttree(TreeNode root){
        if(root == null){return null;}
        TreeNode m = root.left;
        root.left = inverttree(root.right);
        root.right=inverttree(m);
        return root;
    }

    /**
     *617. Merge Two Binary Trees (Easy)
     */

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){return null;}
        if(root1 == null){return root2;}
        if(root2 == null){return root1;}
        TreeNode root = new TreeNode(root1.val+root2.val);
        root.left=mergeTrees(root1.left,root2.left);
        root.right=mergeTrees(root1.right,root2.right);
        return root;
    }

    /**
     *  112. Path Sum (Easy)
     */

    public boolean hasPathSum(TreeNode root,int sum){
        if(root == null){
            return false;
        }
        if(root.left==null && root.right==null && root.val == sum){
            return true;
        }
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
}

















