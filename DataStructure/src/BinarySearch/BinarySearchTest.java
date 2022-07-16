package BinarySearch;

import static org.junit.Assert.assertEquals;

public class BinarySearchTest {


    public static void test1(){
        int input1 =4;
        int input2=8;
        int m=2;
        int output=BinarySearch.mySqurt(input1);
        assertEquals(m,output);

    }


    public static void main(String[] args){
        test1();
    }
}
