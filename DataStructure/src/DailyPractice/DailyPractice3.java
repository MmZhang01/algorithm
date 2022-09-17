package DailyPractice;



import java.util.HashSet;
import java.util.Set;

public class DailyPractice3 {
    /**
     * 1457. Pseudo-Palindromic Paths in a Binary Tree
     */
    int ans = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        Set<Integer> nodes = new HashSet<>();
        dfs(root,nodes);
        return ans;
    }
    private void dfs(TreeNode cur, Set<Integer> nodes){
        if(cur == null) return;
        if(nodes.contains(cur.val)){
            nodes.remove(cur.val);
        }else{
            nodes.add(cur.val);
        }
        if(cur.left==null&&cur.right==null){
            if(nodes.size()<=1) ans++;
        }
        dfs(cur.left,new HashSet<>(nodes));
        dfs(cur.right,new HashSet<>(nodes));
    }
}
