package Tree;

import javax.transaction.TransactionRequiredException;
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
              root.val=m;
              return;
          }
          LinkedList<TreeNode> queue =new LinkedList<>();
          queue.offer(root);
          while(!queue.isEmpty()){
              TreeNode node =queue.poll();
              if(node.left!=null){
                  queue.offer(node.left);
              }else{node.}
              if(node.right!=null){
                  queue.offer(node.right);
              }
          }

//          if(this==null){
//              this.val=m;
//              return this;
//          }else if(this.left==null){
//              this.left.val=m;
//              return this;
//          }
//          else if(this.right==null){
//              this.right.val=m;
//              return this;
//          }
//          addNext(this.left,m);
//          return this;
      }

}
