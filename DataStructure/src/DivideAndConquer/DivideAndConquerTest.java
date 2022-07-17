package DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DivideAndConquerTest {

    public static void test1(){
        String input = "2-1-1";
        List<Integer> output = new ArrayList<>();
        output.add(0);
        output.add(2);
        List<Integer> meng = DivideAndConquer.diffWaysToCompute(input);
        assertArrayEquals(output.toArray(), meng.toArray());
    }

    public static void main(String[] args){
        test1();
    }



}
