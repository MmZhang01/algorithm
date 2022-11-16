package DailyPractice;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class DailyPractice29 {
    // search

    /**
     * 947. Most Stones Removed with Same Row or Column
     * @param stones
     * @return
     */

    // dfs
    // 使用集合标记坐标是否已抵达
    // 发现尚未抵达的坐标，对其进行遍历  把与其横坐标或纵坐标相等的坐标进行 递归标记
    public int removeStones(int[][] stones) {
        Set<int[]> visited = new HashSet<>();
        int numOfIslands = 0;
        for(int[] s1:stones){
            if(!visited.contains(s1)){
                dfs1(s1,visited,stones);
                numOfIslands++;
            }
        }
        return stones.length-numOfIslands;

    }
    private void dfs1(int[] s1, Set<int[]> visited, int[][] stones){
        visited.add(s1);
        for(int[] s2:stones){
            if(!visited.contains(s2)){
                if( s1[0]==s2[0]||s1[1]==s2[1]){
                    dfs1(s2,visited,stones);
                }

            }
        }
    }



    public int countNodes(TreeNode root) {
        if(root ==null) return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }

    /**
     * 374. Guess Number Higher or Lower
     * @param n
     * @return
     */
    // binary search
    public int guessNumber(int n) {
        long l=0,r= (long)n+1;
        while(l+1!=r){
            long m = l+(r-l)/2;
            if(guess((int)m)<0){
                r=m;
            }else l=m;
        }
        return (int)l;
    }

    private int guess(int n){
        int pick=3;
        if(n>pick) return -1;
        else if (n<pick) {
            return 1;
        }
        else return 0;
    }

    @Test
    public void testGuessNumber(){
        System.out.println(guessNumber(2147483647));
    }
}
