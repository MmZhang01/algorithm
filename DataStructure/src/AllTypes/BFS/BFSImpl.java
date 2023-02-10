package AllTypes.BFS;


import java.util.*;

public class BFSImpl {

    /**
     * 909. Snakes and Ladders
     * @param board
     * @return
     */
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[][] visit = new boolean[n][n];
        visit[n-1][0] = true;
        int level = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            while (size-->0){
                int cur = queue.poll();
                for(int i = cur+1;i<=cur+6&&i<=n*n;i++){// i is next position
                    // cal the row and col for the cur position
                    if(i==n*n) return level;
                    int row = n-1-(i-1)/n;
                    int col = (n-row)%2==1?(i-1)%n:n-1-(i-1)%n;
                    if(visit[row][col]==true)continue;
                    visit[row][col]=true;
                    if(board[row][col]==-1){
                        queue.add(i);
                    } else if (board[row][col]==n*n) {
                        return level;
                    } else queue.add(board[row][col]);
                }
            }
        }
        return level;
    }

    /**
     * 102. Binary Tree Level Order Traversal
     * @param root
     * @return
     */

    // basic bfs, need not level record and visit record
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            while (size-->0){
                TreeNode r = queue.poll();
                tmp.add(r.val);
                if(r.left!=null) queue.add(r.left);
                if(r.right!=null) queue.add(r.right);
            }
            res.add(tmp);
        }
        return res;
    }


    /**
     * 103. Binary Tree Zigzag Level Order Traversal
     * @param root
     * @return
     */
    // use level to realize zigzag
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            level++;
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            while (size-->0){
                TreeNode r = queue.poll();
                tmp.add(r.val);
                if(r.left!=null) queue.add(r.left);
                if(r.right!=null) queue.add(r.right);
            }
            if(level%2==0) Collections.reverse(tmp);
            res.add(tmp);
        }
        return res;


    }


}
