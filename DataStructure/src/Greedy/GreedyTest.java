package Greedy;
import org.junit.Test;

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




    public static void main(String[] args){
//        test1();
        test2();
    }

}
