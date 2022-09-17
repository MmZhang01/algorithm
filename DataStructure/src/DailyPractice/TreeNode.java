package DailyPractice;

import java.util.LinkedList;

public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

      public void addNext(TreeNode root,int m){

          if(root==null){
              this.val = m;
              return;
          }
          LinkedList<TreeNode> queue =new LinkedList<>();
          queue.add(root);
          while(!queue.isEmpty()){
              root = queue.peek();
              queue.remove();
              if(root.left==null){
                  root.left=new TreeNode(m);
                  break;
              }else {
                  queue.add(root.left);
              }
              if(root.right==null){
                  root.right=new TreeNode(m);
                  break;
              }else {
                  queue.add(root.right);
              }
          }
      }

}
