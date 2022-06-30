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

    public static void test3(){
        String meng = "bridge";
        TwoPointers result = new TwoPointers();
//        result.reverseVowels(meng);
        System.out.println(result.reverseVowels(meng));
    }

    public static void test4(){
        String meng = "abceaba";
        TwoPointers result =new TwoPointers();
        System.out.println(result.validPalindrome(meng));
    }

    public static void test5(){
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[]{2,5,6};
        int n = 3;
        TwoPointers result = new TwoPointers();
        result.merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }



    public static void main(String[] args){
//        test1();
//        test2();
//        test3();
//        test4();
        test5();
    }



}
