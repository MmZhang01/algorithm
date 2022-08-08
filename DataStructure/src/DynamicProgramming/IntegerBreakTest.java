package DynamicProgramming;

import org.junit.Test;

public class IntegerBreakTest {
    @Test
    public void test1(){
        int input = 4;
        IntegerBreak meng=new IntegerBreak();
        System.out.println(meng.numSquares(4));
    }
    @Test
    public void test2(){
        String input="226";
        System.out.println(IntegerBreak.numDecodings(input));
    }
}
