package Tree;

public class RecursiveTreeTest {
    public static void test5(){
        TreeNode input1;
        input1=null;
        input1.addNext(input1,2);
//        input1.addNext(input1,2);
//        input1.addNext(input1,3);
        System.out.println(input1.val);
//        System.out.println(input1.left.val);
//        System.out.println(input1.right.val);
//        System.out.println(input1.left.left.val);
    }

    public static void main(String[] args){
        test5();
    }
}
