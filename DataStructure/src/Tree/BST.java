package Tree;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return val;
    }
    private int cnt = 0;
    private int val;
    private void inOrder(TreeNode root,int k){
        if(root == null) return;
        inOrder(root.left,k);
        cnt++;
        if(cnt==k){
            val = root.val;
            return;
        }
        inOrder(root.right,k);
    }

    public List<Integer> trimBst(TreeNode root){
        inOrder(root);
        return res;
    }
    private List<Integer> res = new ArrayList<>();
    private void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        res.add(root.val);
        inOrder(root.right);
    }
    @Test
    public void testTrimBst(){
        TreeNode input = new TreeNode(1);
        input.left = new TreeNode(2);
        input.left.right = new TreeNode(3);
        System.out.println(trimBst(input));
    }
}
