package DailyPractice;

import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DailyPractice13 {
    public String countAndSay(int n) {
        if (n==1) return "1";
        // count data
//        List<Pair<Character,Character>> count = new ArrayList<>();
        String say = countAndSay(n-1);
        char cur=say.charAt(0);
        int cnt=1;
        StringBuffer ret = new StringBuffer();
        for(int i =1;i<say.length();i++){
            if(say.charAt(i)!=cur){
                // add to count
//                count.add(new Pair<>((char)cnt,cur));
                ret.append(cnt);
                ret.append(cur);
                cur=say.charAt(i);
                cnt=1;
            }else{
            cnt++;}
        }
        ret.append(cnt);
        ret.append(cur);

        return new String(ret);
    }

    @Test
    public void testCountAndSay(){
        System.out.println(countAndSay(4));
    }

    /**
     * 417. Pacific Atlantic Water Flow
     * @param heights
     * @return
     */
    private int m, n;
    private int[][] matrix;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ret= new ArrayList<>();
        if(heights==null) return ret;
        matrix=heights;
        m=heights.length;
        n=heights[0].length;
        boolean[][] canReachP = new boolean[m][n];
        boolean[][] canReachA = new boolean[m][n];

        for(int i =0;i<m;i++){
            dfs(i,0,canReachP);
            dfs(i,n-1,canReachA);
        }
        for(int i=0;i<n;i++){
            dfs(0,i,canReachP);
            dfs(m-1,i,canReachA);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachP[i][j] && canReachA[i][j]) {
                    ret.add(Arrays.asList(i, j));
                }
            }
        }
        return ret;


    }
    private void dfs(int r,int c,boolean[][] canReach){
        if(canReach[r][c]) return;

        canReach[r][c]=true;
        for(int[] d: direction){
            int nextRow=r+d[0];
            int nextCollum = c+d[1];
            if(nextRow<0||nextRow>=m||nextCollum<0||nextCollum>=n||matrix[r][c]>matrix[nextRow][nextCollum]){
                continue;
            }
            dfs(nextRow,nextCollum,canReach);
        }
    }

    /**
     * 213. House Robber II
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int n=nums.length;
        if(n==1) return nums[0];

        return Math.max(rob(0,n-2,nums),rob(1,n-1,nums));


    }

    private int rob(int first,int last,int[]nums){
        int pre1=0,pre2=0,cur;
        for(int i=first;i<=last;i++){
            cur = Math.max(pre1,pre2+nums[i]);
            pre2=pre1;
            pre1=cur;

        }
        return pre1;
    }

    @Test
    public void testRob(){
        System.out.println(rob(new int[]{1,2,3,1}));
    }
}
