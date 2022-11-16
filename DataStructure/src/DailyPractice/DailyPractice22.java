package DailyPractice;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class DailyPractice22 {
    // hash table
    /**
     * 1293. Shortest Path in a Grid with Obstacles Elimination
     * @param grid
     * @param k
     * @return
     */

    // bfs  多出一个维度k 记录消除障碍的次数

    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int shortestPath(int[][] grid, int k) {
        int n =grid.length,m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visted = new boolean[n][m][k+1];// 记录是否浏览过 三维 分别记录行/列 以及 消除障碍数
        visted[0][0][0]=true; // 第一步的位置
        queue.offer(new int[]{0,0,0}); // 第一步进入
        int res = 0;  // 记录步数
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->=0){
                int[] info = queue.poll(); // 取出队列中的数据 即当前的位置
                int r = info[0], c = info[1],curK = info[2];
                if(r==n-1&&c== m-1) return res;
                for(int[] dir:dirs){
                    int nexR = r + dir[0];
                    int nexC = c+ dir[1];
                    int nexK = curK;
                    if(nexR>=0&&nexR<n&&nexC>=0&&nexC<m){
                        if(grid[nexR][nexC]==1){
                            nexK++;
                        }
                        if(nexK<=k&&!visted[nexR][nexC][nexK]){
                            visted[nexR][nexC][nexK]=true;
                            queue.offer(new int[]{nexR,nexC,nexK});
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }

    public static void main(String[] args){
        int i=5;
        while(i-->0){
            System.out.println(i);
        }
    }

    /**
     * 242. Valid Anagram
     * @param s
     * @param t
     * @return
     */
    // 判断两个字符串所含字母是否一致，将字母按照一个字符串存到hashmap中，存储字母及数量，按另一个字符串取出 并 值--
    // 符号范围有限 使用array也可，让符号作为下标
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ct: t.toCharArray()){
            int value = map.getOrDefault(ct,0)+1;
            map.put(ct,value);
        }
        for(char cs:s.toCharArray()){
            if(map.containsKey(cs)){
                if(map.get(cs)==0) return false;
                map.put(cs,map.get(cs)-1);
            }else return false;
        }
        return true;
    }


    /**
     * 409. Longest Palindrome
     * @param s
     * @return
     */

    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap();
        for(char cs:s.toCharArray()){
            int value = map.getOrDefault(cs,0)+1;
            map.put(cs,value);
        }
        int res=0;
        for(int i : map.values()){
            if(i%2==0){
                res+=i;
            }else res+=i-1;
        }

        if(res!=s.length()){
            return res+1;
        }
        return res;
    }

    /**
     * 205. Isomorphic Strings
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        //  char[] 存下标为s的字符，对应t中的字符，如果存在不同则报错
        if (s.length()!=t.length()){
            return false;
        }
        HashSet set = new HashSet<>(); // 因为一个字符自能对应一个，t中的字符被对应后，应移除
        for(char ct:t.toCharArray()){
            set.add(ct);
        }
        char[] cs = new char[128]; // contains all ascii characters
        for(int i=0;i<s.length();i++){
            if(cs[s.charAt(i)]!='\u0000'){
                if(cs[s.charAt(i)] != t.charAt(i)) return false;
            }else{
                cs[s.charAt(i)] = t.charAt(i);
                if(!set.remove(t.charAt(i))) return false;
            }
        }
        return true;
    }


}
