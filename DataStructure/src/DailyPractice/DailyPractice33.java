package DailyPractice;

import org.junit.Test;

import java.util.*;

public class DailyPractice33 {

    public int pivotInteger(int n) {
        int l =0,r=n+1;
        while(l+1!=r){
            int m = (l+r)/2;
            if((1+m)*m/2<(m+n)*(n-m+1)/2){
                l=m;
            }else r=m;
        }
        if((1+r)*r/2!=(r+n)*(n-r+1)/2){
            return -1;
        }
        return r;
    }

    @Test
    public void testPivotInteger(){
        System.out.println(pivotInteger(8));
    }

    /**
     * 102. Binary Tree Level Order Traversal
     * @param root
     * @return
     */

    // bfs
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList();
        List<List<Integer>> ret = new ArrayList<>();
        if(root==null) return ret;
        queue.add(root);
        int level =0;
        while(!queue.isEmpty()){
            int size = queue.size();
            ret.add(new ArrayList<>());
            while(size--!=0){
                TreeNode tmp = queue.poll();
                ret.get(level).add(tmp.val);
                if(tmp.left!=null) queue.add(tmp.left);
                if(tmp.right!=null) queue.add(tmp.right);
            }
            level++;
        }
        return ret;
    }


    /**
     * 103. Binary Tree Zigzag Level Order Traversal
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        List<List<Integer>> ret = new ArrayList<>();
        if(root==null) return ret;
        queue.add(root);
        int level =0;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size--!=0){
                TreeNode tmp = queue.poll();
                list.add(tmp.val);
                if(tmp.left!=null) queue.add(tmp.left);
                if(tmp.right!=null) queue.add(tmp.right);
            }
            level++;
            if(level%2 ==0){
                Collections.reverse(list);
            }
            ret.add(list);
        }
        return ret;
    }


    /**
     * 297. Serialize and Deserialize Binary Tree
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return serial(new StringBuilder(), root).toString();
        }

        private StringBuilder serial(StringBuilder str,TreeNode root){
            // preorder tree to transform values to string
            if(root == null) return str.append("#");
            str.append(root.val).append(",");
            serial(str,root.left).append(",");
            serial(str,root.right);
            return str;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return deserial(new LinkedList<>(Arrays.asList(data.split(","))));
        }

        private TreeNode deserial(Queue<String> q){
            String val = q.poll();
            if ("#".equals(val)) return null;
            TreeNode root = new TreeNode(Integer.valueOf(val));
            root.left = deserial(q);
            root.right = deserial(q);
            return root;
        }
    }

    @Test
    public void testCodec(){
        Codec t1 = new Codec();
        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(3);
        System.out.println(t1.serialize(t2));
    }

    /**
     * 2225. Find Players With Zero or One Losses
     * @param matches
     * @return
     */
    public List<List<Integer>> findWinners(int[][] matches) {
        HashSet<Integer> lose0 = new HashSet<>();
        HashSet<Integer> lose1 = new HashSet<>();
        HashSet<Integer> losemore = new HashSet<>();
        int n = matches.length;
        for(int[] match:matches){
            lose0.add(match[0]);
        }
        for(int[] match:matches){
            if(lose0.contains(match[1])){
                lose0.remove(match[1]);}
            if(!lose1.add(match[1])){
                losemore.add(match[1]);
                }
            }

        for(int i: losemore){
            lose1.remove(i);
        }
        List<Integer> l1 =  new ArrayList<>(lose0);
        Collections.sort(l1);
        List<Integer> l2=  new ArrayList<>(lose1);
        Collections.sort(l2);
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(l1);
        ret.add(l2);
        return ret;
    }
}
