package String;

public class MyStringTest {
    public static void test1(){
        String input1 = new String("aassdd");
        String input2 = new String("aassdd");

        System.out.println(MyString.isAnagram(input1,input2));
    }

    public static void test2(){
        String input = "allsddvserrsa";
        System.out.println(MyString.longestPalindrome(input));
    }

    public static void main(String[] args){
//        test1();
//        System.out.println(3/2);
        test2();
    }

}
