package DailyPractice;

public class DailyPractice23 {
    //Array and Matrix

    /**
     * 766. Toeplitz Matrix
     * @param matrix
     * @return
     */
    int m,n;
    int[][] grid;
    public boolean isToeplitzMatrix(int[][] matrix) {

        // 逆向思维，对每一个单元查询其左上角 O(m*n) O(1)
//        for (int r = 0; r < matrix.length; ++r)
//            for (int c = 0; c < matrix[0].length; ++c)
//                if (r > 0 && c > 0 && matrix[r-1][c-1] != matrix[r][c])
//                    return false;
//        return true;

        m=matrix.length;
        n=matrix[0].length;
        grid=matrix;
        if(m==1&&n==1) return true;
        for(int i =0 ;i<n;i++){
            if(!dfs(0,i)) return false;
        }
        for(int i=1;i<m;i++){
            if(!dfs(i,0)) return false;
        }
        return true;
    }
    private  boolean dfs(int r,int c){
        int nextR = r+1;
        int nextC = c+1;
        if(nextC==n||nextR==m) return true;
        if(grid[r][c]!=grid[nextR][nextC]){
            return false;
        }else return dfs(nextR,nextC);
    }

    /**
     * 283. Move Zeroes
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        //两个指针 一个指针指向当前位置（0），另一个指针向后移动，直到非零，交换  O(n^2)
        int n =nums.length;
        if (n<=1) {
            return;
        }
        for(int i=0;i<n-1;i++){
            if(nums[i]!=0) continue;
            for(int j=i+1;j<n;j++){
                if(nums[j]==0) continue;
                nums[i]=nums[j];
                nums[j]=0;
                break;
            }
        }

//      找队列中非0的数，添加到当前队列中，剩余的数字就是0  O(n)
//        int idx = 0;
//        for (int num : nums) {
//            if (num != 0) {
//                nums[idx++] = num;
//            }
//        }
//        while (idx < nums.length) {
//            nums[idx++] = 0;
//        }
    }

    /**
     * 566. Reshape the Matrix
     * @param mat
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m= mat.length,n=mat[0].length;
        if(m*n!=r*c) return mat;
        int [][] ret= new int[r][c];
        //同理也可以遍历新的矩阵
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int tep = n*i+j; // 计算下标  也可以index++
                int tepR=(tep)/c;
                int temC=(tep)%c;
                ret[tepR][temC] = mat[i][j];
            }
        }
        return ret;
    }

    /**
     * 485. Max Consecutive Ones
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        // 记录最大值    记录当前连续值
        int max=0;
        int cur = 0;
        for(int num:nums){
            if (num==0) {
                cur=0;
            }else cur++;
            max = Math.max(cur,max);
        }
        return max;
    }

    /**
     * 240. Search a 2D Matrix II
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // 从右上角 或者 左下角 开始找
        // 目标值比当前值大下移，比当前值小左移
        int m = matrix.length,n=matrix[0].length;
        for(int i=0,j=n-1;i<m&&j>=0;){
            if(target==matrix[i][j]){
                return true;
            } else if (target>matrix[i][j]) {
                i++;
            }else j--;
        }
        return false;
    }

    /**
     * 378. Kth Smallest Element in a Sorted Matrix
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        // binary search 找到第k个数
        //
        // 红蓝条件   蓝 比中值数(即目标值)小的个数小于k 红 else  返回蓝
//        int l= matrix[0][0],r = matrix[matrix.length-1][matrix[0].length-1];
        int l=Integer.MIN_VALUE,r= Integer.MAX_VALUE;
        while(l+1!=r){
            int m = (r+l)/2;
            int cnt=0; //小于中值的个数
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    if(matrix[i][j]<m) cnt++;
                }
            }
            if(cnt<k){
                l=m;
            }else r=m;
        }
        return l;

    }
























}
