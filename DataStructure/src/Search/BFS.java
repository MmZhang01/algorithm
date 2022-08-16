package Search;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;

/*
将题目转化为求最短路径，但是路径不含权重
BFS按层次遍历
用队列来储存每一层的节点，并标记  先进先出

 */

public class BFS {
    public int shortestPathBinaryMatrix(int[][] grids) {
        if (grids == null || grids.length == 0 || grids[0].length == 0) {
            return -1;
        }
        int[][] direction = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        int m = grids.length, n = grids[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, 0));
        int pathLength = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();    //  size指当前步长 所有可能在的位置的数目
            pathLength++;
            while (size-- > 0) {    //  清空当前步长
                Pair<Integer, Integer> cur = queue.poll();
                int cr = cur.getKey(), cc = cur.getValue();
                if (grids[cr][cc] == 1) {
                    continue;
                }
                if (cr == m - 1 && cc == n - 1) {
                    return pathLength;
                }
                grids[cr][cc] = 1; // 标记
                for (int[] d : direction) {
                    int nr = cr + d[0], nc = cc + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }
                    queue.add(new Pair<>(nr, nc));
                }
            }
        }
        return -1;
    }

    /**
     * 279. Perfect Squares (Medium)
     */

    private List<Integer> generateSquares(int n){
        List<Integer> ret = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while(square<n){
            ret.add(square);
            square+=diff;
            diff+=2;
        }
        return ret;
    }
    public int numSquares(int n){
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n + 1];
        queue.add(n);
        marked[n] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                int cur = queue.poll();
                for (int s : squares) {
                    int next = cur - s;
                    if (next < 0) {
                        break;
                    }
                    if (next == 0) {
                        return level;
                    }
                    if (marked[next]) {
                        continue;
                    }
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return n;
    }

    /**
     * 127. Word Ladder (Medium)
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> used = new HashSet<>();
        queue.add(beginWord);
        used.add(beginWord);
        int level=1;
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            while(size-->0){
                String cur = queue.poll();
                for (String word : wordList) {
                    if(used.contains(word)) continue;
                    if(isConnect(cur,word)){
                        if(word==endWord) return level;
                        queue.add(word);
                        used.add(word);
                    }
                }
            }

        }
        return 0;
    }

    private boolean isConnect(String s,String m){
        char[] s1=s.toCharArray();
        char[] s2=m.toCharArray();
        int diff=0;
        int i=0,j=0;
        while(i<s1.length&&j<s2.length){
            if(s1[i]!=s2[j]) diff++;
            i++;
            j++;
        }
        return diff==1;
    }



    @Test
    public void test(){
        String begin = "hit";
        String end = "cog";
        List<String> word = new ArrayList<>();
        word.add("hot");
        word.add("dot");
        word.add("dog");
        word.add("lot");
        word.add("log");
        word.add("cog");
        System.out.println(ladderLength(begin,end,word));
    }
}
