package AllTypes.Queue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueImpl {

    /**
     * 54. Spiral Matrix
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // use queue to get the direction
        // follow the first in first out
        // right -> down->left->up
        Queue<String> queue = new LinkedList<>();
        queue.add("→");
        queue.add("↓");
        queue.add("←");
        queue.add("↑");
        int cnt = matrix.length*matrix[0].length;
        boolean[][] visit = new boolean[matrix.length][matrix[0].length];
        List<Integer> res = new ArrayList<>();
        int row=0,col = 0;
        while (cnt-->0){
            String dir = queue.poll();
            while (dir == "→" && col<matrix[0].length &&visit[row][col]==false){
                res.add(matrix[row][col]);
                visit[row][col]=true;
                col++;
                cnt--;
            }
            col--;
            row++;
            queue.add("→");
            dir = queue.poll();
            while(dir == "↓" && row< matrix.length && visit[row][col]==false){
                res.add(matrix[row][col]);
                visit[row][col] = true;
                row++;
                cnt--;
            }
            row--;
            col--;
            queue.add("↓");
            dir = queue.poll();
            while(dir == "←" && col>=0 && visit[row][col] == false){
                res.add(matrix[row][col]);
                visit[row][col] = true;
                col--;
                cnt--;
            }
            col++;
            row--;
            queue.add("←");
            dir = queue.poll();
            while(dir == "↑" && row>=0 && visit[row][col] == false){
                res.add(matrix[row][col]);
                visit[row][col] = true;
                row--;
                cnt--;
            }
            row++;
            col++;
            queue.add("↑");
        }
    return res;
    }

    @Test
    public void testSpiralOrder(){
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }
}
