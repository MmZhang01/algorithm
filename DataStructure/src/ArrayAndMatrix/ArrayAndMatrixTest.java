package ArrayAndMatrix;

import java.util.Arrays;

public class ArrayAndMatrixTest {
    public static void test1(){
        int[] input = new int[]{0,1,2,3,0,4};
        ArrayAndMatrix.moveZeroes(input);
        System.out.println(Arrays.toString(input));
    }

    public static void test2(){
        int[][] input= new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(Arrays.deepToString(ArrayAndMatrix.matrixReshape(input,6,2)));
    }

    public static void test3(){
        int[] input = new int[]{1,1,1,0,1,1};
        System.out.println(ArrayAndMatrix.findMaxConsecutiveOnes(input));
    }

    public static void test4(){
        int[][] input = new int[][]{{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(ArrayAndMatrix.kthSmallest(input,2));
    }
    public static void main(String[] args){
//        test1();
//        test2();
//        test3();
        test4();
    }

}
