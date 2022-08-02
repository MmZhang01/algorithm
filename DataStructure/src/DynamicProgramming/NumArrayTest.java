package DynamicProgramming;

import org.junit.Test;

public class NumArrayTest {
    @Test
    public void test1(){
        int[] input=new int[]{1,2,3,4,5,6};
        NumArray meng=new NumArray(input);
        System.out.println(meng.sumRange(0,2));
    }
}
