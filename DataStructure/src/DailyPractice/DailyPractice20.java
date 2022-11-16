package DailyPractice;

import org.junit.Test;

import java.util.*;

public class DailyPractice20 {
    // tree
    // recursive tree + level traversal + preoder/postorder/inorder traversal

    /**
     * 49. Group Anagrams
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            // for each str in strs, sort the str
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String key = String.valueOf(tmp);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    @Test
    public void testGroupAnagrams(){
//        String[] strs =new String[]{"eat","tea","tan","ate","nat","bat"};
//        System.out.println(groupAnagrams(strs));
//        char[] tmp = new char[]{'a','b','v'};
//        System.out.println(String.valueOf(tmp));
        int[] a= new int[]{1,2};
        System.out.println(Integer.toString(1));
    }


    /**
     * 543. Diameter of Binary Tree
     * @param root
     * @return
     */
    //  在每个节点时，求相隔最远节点的距离 并记录
    //  每个节点最远节点的距离 = 其最远左子树+最远右子树
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxBinaryTree(root);
        return max;

    }
    private int maxBinaryTree(TreeNode root){
        if(root==null) return 0;
        int l = maxBinaryTree(root.left);
        int r = maxBinaryTree(root.right);
        max = Math.max(l+r,max);
        return Math.max(l+1,r+1);
    }

    /**
     * 226. Invert Binary Tree
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }

    /**
     * 617. Merge Two Binary Trees
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2==null) return null;
        if(root1==null){
            return root2;
        } else if (root2==null) {
            return root1;
        }else{
            TreeNode newTree = new TreeNode(root1.val+root2.val);
            newTree.left = mergeTrees(root1.left,root2.left);
            newTree.right = mergeTrees(root1.right,root2.right);
            return newTree;
        }
    }


    /**
     * 112. Path Sum
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        if(root.left==null&&root.right==null&&root.val==targetSum){
            return true;
        }
        return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
    }


    /**
     * 437. Path Sum III (Easy)
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;

        return pathSum(root.left,targetSum)+pathSum(root.right,targetSum)+hasPath(root,targetSum);

    }

    //以下方法， 满足从当前节点开始的路径和为目标值 的数量
    // 如何当前节点的值即满足，数量+1， 如何其子节点值满足  目标值-当前节点值， 数量++， 递推
    private int hasPath(TreeNode root,long targetSum){
        if (root==null) {
            return 0;
        }
        int ret=0;
        if(root.val==targetSum) ret++;
        ret+= hasPath(root.left,targetSum-root.val)+hasPath(root.right,targetSum-root.val);
        return ret;
    }

    /**
     * 2136. Earliest Possible Day of Full Bloom
     * @param plantTime
     * @param growTime
     * @return
     */
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        // 按生长期降序排序
        //indices 中存储 按生长期降序的种子号
        int n = growTime.length;
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            indices.add(i);
        }
        Collections.sort(indices, Comparator.comparingInt(i -> -growTime[i]));
        //按开花从长到短开始种，最终日期 = 当前种植期+种植期后的最长开花期
        // 种植后的最长开花期 = 比较最后种植种子的开花期  与  种植最走种子前的最长开花期-最后种植期
        int res = 0,maxGrow = 0;
        for(int i =0 ;i<plantTime.length;i++){
            res+= plantTime[indices.get(i)];
            maxGrow = Math.max(growTime[indices.get(i)],maxGrow-plantTime[indices.get(i)]);
        }
        return res+maxGrow;


    }











}
