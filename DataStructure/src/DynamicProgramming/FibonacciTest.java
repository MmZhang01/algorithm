package DynamicProgramming;

import org.junit.Test;

public class FibonacciTest {
    @Test
    public void test1(){
        int input = 8;
        System.out.println(Fibonacci.climbStairs(input));
    }

    @Test
    public void test2(){
        int[] input = new int[]{2,1,1,2};
        System.out.println(Fibonacci.rob(input));
    }
}
