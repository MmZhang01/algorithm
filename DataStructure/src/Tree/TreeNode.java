package Tree;

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

      public TreeNode addNext(TreeNode root,int m){
          if(this==null){
              this.val=m;
          }else if(this.left==null){
              addNext(this.left,m);
          }
          else if(this.right==null){
              addNext(this.right,m);
          }
          return this;
      }

}
