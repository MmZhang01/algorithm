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
    public static void main(String[] args){
        test1();

    }

}
