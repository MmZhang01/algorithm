package Tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
1. 思考退出条件  一般root == null 退出 and 或满足一定条件退出
2. 代入子数递推
 */
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

    /**
     * 437. Path Sum III (Easy)
     */
    private int pathSumRoot(TreeNode root,int targetSum){
        if(root == null) return 0;
        int ret = 0;
        if(root.val == targetSum) ret++;
        ret+=pathSumRoot(root.left,targetSum-root.val)+pathSumRoot(root.right,targetSum-root.val);
        return ret;
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)return 0;
        int ret = pathSumRoot(root, targetSum)+pathSum(root.left,targetSum)+pathSum(root.right,targetSum);
        return ret;
    }

    /**
     * 572. Subtree of Another Tree (Easy)
     */
    private boolean sameTree(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1==null || t2 == null) return false;
        if (t1.val!=t2.val) return false;
        boolean l1=sameTree(t1.left,t2.left);
        boolean l2=sameTree(t1.right,t2.right);
        return l1&&l2;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null) return false;
        return sameTree(root,subRoot) || isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
    }

    /**
     * 101. Symmetric Tree (Easy)
     */
    /*
    利用revertTree + sameTree
     */
//    public boolean isSymmetric(TreeNode root) {
//        TreeNode tmp = inverttree(root.right);
//        return sameTree(root.left,tmp);
//    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isSubtree(root.left,root.right);

    }
    private boolean isSymmetric(TreeNode r1,TreeNode r2) {
        if(r1==null&&r2==null){return true;}
        if(r1==null||r2==null){return false;}
        if(r1.val!=r2.val){return false;}
        return isSymmetric(r1.left,r2.right)&&isSymmetric(r1.right,r2.left);
    }

    /**
     * 111. Minimum Depth of Binary Tree (Easy)
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        if(l==0||r==0) return l+r+1;
        return Math.min(l,r)+1;
    }

    /**
     *404. Sum of Left Leaves (Easy)
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if(root ==null) return 0;
        if(isLeaf(root.left)) return root.left.val+sumOfLeftLeaves(root.right);
        return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);

    }
    private boolean isLeaf(TreeNode node){
        if(node == null) return false;
        return node.left==null && node.right==null;
    }

    /**
     * 687. Longest Univalue Path (Easy)
     */
    public int longestUnivaluePath(TreeNode root) {

        dfs(root);
        return path;
    }
    private int path = 0;
    private int dfs(TreeNode root){
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftPath = root.left != null && root.left.val == root.val ? left + 1 : 0;
        int rightPath = root.right != null && root.right.val == root.val ? right + 1 : 0;
        path = Math.max(path, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }


//    int ans;
//    public int longestUnivaluePath(TreeNode root) {
//        ans = 0;
//        arrowLength(root);
//        return ans;
//    }
//    public int arrowLength(TreeNode node) {
//        if (node == null) return 0;
//        int left = arrowLength(node.left);
//        int right = arrowLength(node.right);
//        int arrowLeft = 0, arrowRight = 0;
//        if (node.left != null && node.left.val == node.val) {
//            arrowLeft += left + 1;
//        }
//        if (node.right != null && node.right.val == node.val) {
//            arrowRight += right + 1;
//        }
//        ans = Math.max(ans, arrowLeft + arrowRight);
//        return Math.max(arrowLeft, arrowRight);
//    }
    @Test
    public void testLongestUnivaluePath(){
        TreeNode input = new TreeNode(1);
        input.right = new TreeNode(1);
        input.right.left = new TreeNode(1);
        input.right.right = new TreeNode(1);
        input.right.left.left = new TreeNode(1);
        input.right.left.right = new TreeNode(1);
        input.right.right.left = new TreeNode(1);
        System.out.println(longestUnivaluePath(input));
    }

    /**
     * 337. House Robber III (Medium)
     */
    public int rob(TreeNode root) {
        if(root == null ) return 0;
        int val = 0;
        if(root.left!= null){
            val+=rob(root.left.left)+rob(root.left.right);
        }
        if(root.right!= null){
            val+=rob(root.right.right)+rob(root.right.left);
        }
      return Math.max(val+root.val,rob(root.left)+rob(root.right));
    }

    /**
     * 671. Second Minimum Node In a Binary Tree (Easy)
     */
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        if (root.left == null && root.right == null) return -1;
        int leftVal = root.left.val;
        int rightVal = root.right.val;
        if (leftVal == root.val) leftVal = findSecondMinimumValue(root.left);
        if (rightVal == root.val) rightVal = findSecondMinimumValue(root.right);
        if (leftVal != -1 && rightVal != -1) return Math.min(leftVal, rightVal);
        if (leftVal != -1) return leftVal;
        return rightVal;
    }

}

















