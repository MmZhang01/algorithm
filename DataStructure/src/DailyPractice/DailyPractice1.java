package DailyPractice;

public class DailyPractice1 {
    /**
     * 48. Rotate Image
     */
    public void rotate(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return;
        int[][] ret = new int[matrix.length][matrix[0].length];
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                ret[i][j] = matrix[i][j];
            }
        }
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                matrix[i][j] = ret[matrix.length-1-j][i];
            }
        }
    }


}
