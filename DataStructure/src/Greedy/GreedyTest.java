package Greedy;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class GreedyTest {
    public static void test1(){
        int[] grid= new int[]{1,3};
        int[] size= new int[]{1,2,4};
        int m = Greedy.findContentChildren(grid,size);
        assertEquals(2,m);
//        System.out.println(Greedy.findContentChildren(grid,size));
    }

    public static void test2(){
        int[][] input = new int[][]{{1,2},{4,5},{3,4}};
        int m = Greedy.eraseOverlapIntervals(input);
        assertEquals(2,m);
    }

    public static void test3(){
        int[][] input = new int[][]{{10,16},{2,8},{1,6},{7,12}};
        int m = Greedy.findMinArrowShots(input);
        assertEquals(2,m);
    }

    public static void test4(){
        int[][] input = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] output = new int[][]{{5,0},{7,0},{5,2},{6,1},{4,4},{7,1}};
        int [][] m=Greedy.reconstructQueue(input);
        assertArrayEquals(output,m);
    }

    public static void test5(){
        int[] input = new int[]{7,1,5,3,6,4};
        int output = Greedy.maxProfit(input);
        assertEquals(5,output);
    }



    public static void main(String[] args){
//        test1();
//        test2();
//        test3();
        test4();
//        test5();
    }



}
