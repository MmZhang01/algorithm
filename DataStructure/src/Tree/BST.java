package Tree;


public class BST {
    /**
     * 669. Trim a Binary Search Tree (Easy)
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root== null) return null;
        if(root.val<low) return trimBST(root.right,low,high);
        if(root.val>high) return trimBST(root.left,low,high);
        root.left = trimBST(root.left,low,high);
        root.right=trimBST(root.right,low,high);
        return root;
    }

    /**
     * 230. Kth Smallest Element in a BST (Medium)
     */
}
