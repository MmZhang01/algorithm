package DailyPractice;

import java.util.*;

public class DailyPractice34 {

// BST

    // inorder traversals for bst is ordered

    /**
     * 669. Trim a Binary Search Tree
     * @param root
     * @param low
     * @param high
     * @return
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;
        // preorder judge
        if(root.val>high) return trimBST(root.left,low,high); // skip this node to left
        if(root.val<low) return trimBST(root.right,low,high); // skip this node to right
        root.left = trimBST(root.left,low,high);  // the same operate to left/right node
        root.right = trimBST(root.right,low,high);
        return root;
    }


    /**
     * 230. Kth Smallest Element in a BST
     * @param root
     * @param k
     * @return
     */
    private int val;
    private int cnt=0;
    public int kthSmallest(TreeNode root, int k) {
//        // method 1  inorder traversals
//        inOrder(root,k);
//        return val;

        //method 2  recursive
        // we need to know how many node less than this root
        int c = count(root.left);
        // if c=k-1 then this value in node will be the result
        if(c == k-1) return root.val;
        // if c>k-1 then kth node is at the left
        if(c > k-1) return kthSmallest(root.left,k);
        // else the kth node is at the right, find the (k-c-1)th node at the right
        return kthSmallest(root.right,k-c-1);



    }
    private int count(TreeNode root){
        if(root == null) return 0;
        return 1+count(root.left)+count(root.right);
    }
    private void inOrder(TreeNode root,int k){
        if(root==null) return;
        inOrder(root.left,k);
        cnt++;
        if(cnt == k) {
            val=root.val;
            return;
        }
        inOrder(root.right,k);
    }

    /**
     * 538. Convert BST to Greater Tree
     * @param root
     * @return
     */

    // inorder traversals
    // right subtree first   right-> middle-> left
    public TreeNode convertBST(TreeNode root) {
        inOrder(root);
        return root;
    }
    private int sum=0;
    private void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.right);
        sum+=root.val;
        root.val=sum;
        inOrder(root.left);
    }

    /**
     * 380. Insert Delete GetRandom O(1)
     */
    class RandomizedSet {

        HashMap<Integer,Integer> map;
        List<Integer> list;
        Random r;

        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            r=new Random();
        }

        public boolean insert(int val) {
            boolean ret = map.containsKey(val);
            if(ret==true) return false;
            map.put(val,list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            boolean ret = map.containsKey(val);
            if(ret==false) return false;
            int loc = map.get(val); // remove position
            if(loc<list.size()-1){
                int lastOne = list.get(list.size()-1);
                list.set(loc,lastOne);   // set lastOne to a loc
                map.put(lastOne,loc);
            }
            list.remove(list.size()-1);// remove lastOne
            map.remove(val);
            return true;
        }

        public int getRandom() {
            return list.get(r.nextInt(list.size()));
        }

    }
}
