package DailyPractice;

import org.junit.Test;

import java.util.*;

public class DailyPractice12 {

    /**
     * 241. Different Ways to Add Parentheses
     */
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ways = new ArrayList<>();
        for(int i =0;i<expression.length();i++){
            char c = expression.charAt(i);
            if(c == '+'||c=='-'||c == '*'){
                List<Integer> left = diffWaysToCompute(expression.substring(0,i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));
                for(int l:left){
                    for(int r:right){
                        switch (c){
                            case '+':
                                ways.add(l+r);
                                break;
                            case '-':
                                ways.add(l-r);
                                break;
                            case '*':
                                ways.add(l*r);
                                break;
                        }
                    }
                }
            }

        }
        if(ways.size()==0){
            ways.add(Integer.valueOf(expression));
        }
    return ways;
    }

    @Test
    public void testDiffWaysToCompute(){
        System.out.println(diffWaysToCompute("2-1-1"));
    }

    /**
     * 1832. Check if the Sentence Is Pangram
     * @param sentence
     * @return
     */
    public boolean checkIfPangram(String sentence) {
        boolean[] arr = new boolean[26];

        for (int i=0;i<sentence.length();i++){
            arr[sentence.charAt(i) -'a'] = true;
        }
        for (int i=0;i<arr.length;i++){
            if (arr[i] == false) return false;
        }

        return true;
    }

    /**
     * 130. Surrounded Regions
     * @param board
     */
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int m, n;
    public void solve(char[][] board) {
        m= board.length;
        n=board[0].length;
        for (int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    dfs(board,i,j);
                }

            }
        }
    }

    private void dfs(char[][] board,int r, int c){
        if(r<0||r>=m||c<0||c>=n||board[r][c]=='x'){
            return;
        }
        boolean cap = true;
        for(int[]d:direction){
            int i=0;

            while(board[r+d[0]*i][c+d[1]*i]!='X'){
                i++;
                if(r+d[0]*i<0||r+d[0]*i>=m||c+d[1]*i<0||c+d[1]*i>=n){
                    cap=false;
                    break;
                }
            }
        }
        if(cap) board[r][c]='X';
        Queue<int[]> q =new LinkedList<>();
        Stack<int []> s = new Stack<>();
    }
}













