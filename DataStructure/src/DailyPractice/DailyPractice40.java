package DailyPractice;

import org.junit.Test;

import java.util.*;

public class DailyPractice40 {
    // tree

    /**
     * 98. Validate Binary Search Tree
     * @param root
     * @return
     */

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder1(root,list);
        int last = list.get(0);
        for(int i=1;i<list.size();i++){
            if(last>=list.get(i)){
                return false;
            }else last=list.get(i);
        }
        return true;
    }
    private void inOrder1(TreeNode root,List last){
        if(root==null) return;
        inOrder1(root.left,last);
        last.add(root.val);
        inOrder1(root.right,last);
    }


    // daily code

    /**
     * 2244. Minimum Rounds to Complete All Tasks
     * @param tasks
     * @return
     */
    public int minimumRounds(int[] tasks) {
        // count the task for each level
        Map<Integer,Integer> map = new HashMap<>();
        for(int task:tasks){
            int tmp = map.getOrDefault(task,0)+1;
            map.put(task,tmp);
        }
        // heap add the count
//        PriorityQueue<Integer> counts = new PriorityQueue<>();
//        for(int value: map.values()){
//            counts.add(value);
//        }


        //get the same level task and judge if they can be completed and cal the minimum round
        // if count % 3 ==0 then round = count/3
        // if count %3 ==1/2 then round = count/3+1
        // if count ==1 return -1
        int round = 0;
        for(int count: map.values()){
            if(count==1) return -1;
            if(count%3==0){
                round+=count/3;
            }else round +=count/3+1;
        }
        return round;
    }


    /**
     * 452. Minimum Number of Arrows to Burst Balloons
     * @param points
     * @return
     */
    //greedy
    public int findMinArrowShots(int[][] points) {
        // sort the array by x end asc
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if((long)o1[1]-o2[1]<0) return -1;
                else return 1;
            }
        });
//        Arrays.sort(points,(a,b)->-(-a[1]+b[1]));
        // count the overlap
        int ret = 1;
        int end = points[0][1];
        for(int i=1;i< points.length;i++){
            if(points[i][0]>end){
                end = points[i][0];
                ret++;
            }
        }
        return ret;
    }
@Test
    public void testFindMinArrowShots(){
        System.out.println(findMinArrowShots(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}}));
//    System.out.println((long)-2147483645-2147483647);
    }


    /**
     * 1833. Maximum Ice Cream Bars
     * @param costs
     * @param coins
     * @return
     */
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ret = 0;
        for(int cost:costs){
            if(cost>coins) break;
            coins-=cost;
            ret++;
        }
        return ret;
    }


    public int maxPoints(int[][] points) {
        // if there is only two points return 2
        int n = points.length;
        if(n<=2) return n;
        int ans = 2;

        // iterate every two point, fix one, move one, record the slope for the two points
        for(int[] point1:points){
            // use map to record the slop
            Map<Double, Integer> map = new HashMap<>();
            for(int[] point2:points){
                if(point1==point2){
                    continue;
                }
                double slope = 0;
                // vertical points
                if(point2[0]-point1[0]==0){
                    slope = Double.POSITIVE_INFINITY;
                }else slope = (double) (point2[1]-point1[1])/(point2[0]-point1[0]);
                int tmp=map.getOrDefault(slope,1)+1;
                map.put(slope,tmp) ;
                ans = Math.max(ans,tmp);
            }
        }
        return ans;
    }

    @Test
    public void testMaxPoints(){
        maxPoints(new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}});
    }

    /**
     * 144. Binary Tree Preorder Traversal
     * @param root
     * @return
     */

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root,list);
        return list;
    }
    private void preOrder(TreeNode root,List<Integer> list){
        if (root==null) return;
        list.add(root.val);
        preOrder(root.left,list);
        preOrder(root.right,list);
    }

//    boolean ret = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
//        postOrder(p,q);
//        return ret;
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;
        if(p.val!=q.val) return false;

        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
//    private void postOrder(TreeNode root1,TreeNode root2){
//        if (root1==null&&root2==null) return;
//        if(root1==null){
//            ret=false;
//            return;
//        }
//        if(root2==null){
//            ret =false;
//            return;
//        }
//        if(root1.val!= root2.val) ret =false;
//        postOrder(root1.left,root2.left);
//        postOrder(root1.right,root2.right);
//    }
}
