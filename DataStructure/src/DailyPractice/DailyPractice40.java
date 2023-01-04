package DailyPractice;

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
}
