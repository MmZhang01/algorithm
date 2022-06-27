package TwoPointers;


import java.util.Arrays;

public class Test {
    public static void test1(){
        int[] ob1=new int[]{1,3,4,5,6,8,9};
        int ob2 = 11;
        TwoPointers result = new TwoPointers();
        result.TwoSum(ob1,ob2);
        System.out.println(Arrays.toString(result.TwoSum(ob1,ob2)));
    }

    public static void test2(){
        int ob1 = 10;
        TwoPointers result = new TwoPointers();
        result.judgeSquareSum(ob1);
        System.out.println(result.judgeSquareSum(ob1));
    }






    public static void main(String[] args){
//        test1();
        test2();
    }


}
