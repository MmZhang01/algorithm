package ArrayAndMatrix;

import java.util.Arrays;
import java.util.LinkedList;

public class ArrayAndMatrix {
    /**
     * 283. Move Zeroes (Easy)
     */
    public static void moveZeroes(int[] nums) {
        int j =0;
        for (int num : nums) {
            if(num!=0){
                nums[j]=num;
                j++;
            }
        }
        for(int i=j;i<nums.length;i++) {
            nums[i] = 0;
        }
        }

    /**
     * 566. Reshape the Matrix (Easy)
     */
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] ret = new int[r][c];
        int m =mat.length,n=mat[0].length;
        if(r*c!=n*m) return mat;
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ret[i][j]=mat[index/n][index%n];
                index++;
            }
        }
        return ret;
    }

    /**
     * 485. Max Consecutive Ones (Easy)
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int ret = 0;
        int max = 0;
        for (int num : nums) {
            if(num == 0){
                ret = 0;
            }
            ret++;
            max = Math.max(max,ret);
        }
        return max;
    }

    /**
     *240. Search a 2D Matrix II (Medium)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int r=matrix.length-1,c=0;
        while(r>=0 && c <matrix[0].length){
            if(target==matrix[r][c]){
                return true;
            }else if(target>matrix[r][c]){
                c++;
            }else r--;
        }
        return false;
    }

    /**
     * 378. Kth Smallest Element in a Sorted Matrix ((Medium))
     */
    /*
    二分法  指针的值不断趋近于 满足count 的数值
     */
    public static int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int lo = matrix[0][0], hi = matrix[m - 1][n - 1];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n && matrix[i][j] <= mid; j++) {
                    cnt++;
                }
            }
            if (cnt <k) lo = mid + 1;    // cnt 符合的时候，l不变
            else hi = mid -1 ;
        }
        return hi;
    }


    int[] arr1 = new int[5];
    LinkedList<Integer> a=new LinkedList<>();
}
