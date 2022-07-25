package Tree;

import java.util.List;

public class TraversalTest {
    public static void test1(){
        TreeNode input = new TreeNode(3);
        input.left = new TreeNode(9);
        input.right=new TreeNode(20);
        input.left.left=new TreeNode(15);
        input.left.right=new TreeNode(7);

        List<Double> output =  LevelTraversal.averageOfLevels(input);
        System.out.println(output);

    }
    public static void test2(){
        TreeNode input = new TreeNode(1);
        input.left = new TreeNode(2);
        input.right=new TreeNode(3);
        input.left.left=new TreeNode(4);
        input.left.right=new TreeNode(5);
        input.right.left=new TreeNode(6);
//        input.right.left.left=new TreeNode(7);

        int output = LevelTraversal.findBottomLeftValue(input);
        System.out.println(output);
    }

    public static void test3(){
        TreeNode input = new TreeNode(4);
        input.left = new TreeNode(2);
        input.right=new TreeNode(6);
        input.left.left=new TreeNode(1);
        input.left.right=new TreeNode(3);
        input.right.left=new TreeNode(5);
        input.right.right=new TreeNode(7);
//        PreorderTraversal.preorder(input);
//        InorderTraversal.inorder(input);
        PostorderTraversal.postorder(input);
//        System.out.println(PreorderTraversal.preorderTraversal(input));
        System.out.println(PostorderTraversal.postorderTraversal(input));
    }

    public static void main(String[] args){
//        test1();
//        test2();
        test3();
    }
}
