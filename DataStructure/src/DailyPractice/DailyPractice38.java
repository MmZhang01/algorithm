package DailyPractice;

import org.junit.Test;

import java.util.*;

public class DailyPractice38 {


    /**
     * 2279. Maximum Bags With Full Capacity of Rocks
     * @param capacity
     * @param rocks
     * @param additionalRocks
     * @return
     */
    // greedy
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n  = capacity.length;
        int[] left = new int[n];
        for(int i=0;i<n;i++){
            left[i] = capacity[i]-rocks[i];
        }
        Arrays.sort(left);
        int ret  = 0;
        for(int i=0;i<n;i++){
            if(left[i]<=additionalRocks){
                ret++;
                additionalRocks-=left[i];
            }else break;
        }
        return ret;
    }

    /**
     * 55. Jump Game
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] reach = new boolean[n];
        int i = 0;
        reach[i] = true;
        while(i<n&&reach[i]){
            int l = nums[i];
            for(int j = 0;j<=l;j++){
                if(i+j>n-1) return true;
                reach[i+j] = true;
            }
            i++;
        }
        return reach[n-1];



        /*
        // dp  if current position + current jump> last position
        //  it means last position is reachable by current position, so set last position to current position
        //  if all position is reachable then last position equals 0 at the end
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
         */
    }

    /**
     * 1962. Remove Stones to Minimize the Total
     * @param piles
     * @param k
     * @return
     */
    public int minStoneSum(int[] piles, int k) {

        // heap   space O(k)   time O(nlogk)
        PriorityQueue<Integer> queue = new PriorityQueue<>(k,(a,b)->(b-a));
        int sum = 0;
        for(int pile:piles){
            queue.add(pile);
            sum+=pile;
        }
        while(k--!=0){
            int tmp = queue.poll();
            sum-= tmp/2;
            queue.add(tmp-tmp/2);
        }
        return sum;
        /*
         // time limit exceeded    O(k*n)
        while(k--!=0){
            int max = piles[0];
            int index=0;
            for (int i = 0; i < piles.length; i++) {
                if(piles[i]>max){
                    max = piles[i];
                    index=i;
                }
            }
            piles[index] -= (int)Math.floor(((double) piles[index])/2);
        }
        int sum=0;
        for(int pile:piles){
            sum+=pile;
        }
        return sum;
         */
    }

    @Test
    public void testMinStoneSum(){
        System.out.println(minStoneSum(new int[]{10},10));
    }


    /**
     * 1834. Single-Threaded CPU
     * @param tasks
     * @return
     */
    public int[] getOrder(int[][] tasks) {
        // heap  put tasks into heap when enqueue time is satisfied
//        Arrays.sort(tasks,(a,b)->(a[0]-b[0]));

        /*
                int time = 1;
        int[] ret = new int[tasks.length];
        PriorityQueue<Map.Entry<List<Integer>,Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<List<Integer>, Integer>>() {
            @Override
            public int compare(Map.Entry<List<Integer>, Integer> o1, Map.Entry<List<Integer>, Integer> o2) {
                return o1.getKey().get(1)==o2.getKey().get(1)?o1.getKey().get(1)-o2.getKey().get(1):o1.getValue()-o2.getValue();
            }
        });
        int i = 0,j=0;
        while(i<tasks.length){
            while(tasks[i][0]<=time){
                Map.Entry<List<Integer>,Integer> tmp = new AbstractMap.SimpleEntry<>(Arrays.asList(tasks[i][0],tasks[i][1]),i);
                queue.add(tmp);
//                time+=tasks[i][1];
                i++;
            }
            Map.Entry<List<Integer>,Integer> tmp2 = queue.poll();
            time+= tmp2.getKey().get(1);
            ret[j++] = tmp2.getValue();
        }
        return ret;

         */
        PriorityQueue<List<Integer>> q = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0)==o2.get(0)?o1.get(1)-o2.get(1):o1.get(0)-o2.get(0);
            }
        });
        int index = 0;
        for(int[]task:tasks){
            List<Integer> tmp  = new ArrayList<>();
            tmp.add(task[0]);
            tmp.add(task[1]);
            tmp.add(index++);
            q.add(tmp);
        }
        int time = 0;
        int[] ret = new int[tasks.length];
        int j=0;
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(1)==o2.get(1)?o1.get(2)-o2.get(2) :o1.get(1)-o2.get(1);
            }
        });

        while(!q.isEmpty()){
            while(!q.isEmpty()&& q.peek().get(0)<=time){
                queue.add(q.poll());
            }
            if(queue.isEmpty()){
                time = q.peek().get(0);
                continue;
            }
            List<Integer> tmp ;
            tmp = queue.poll();
            time+=tmp.get(1);
            ret[j++] = tmp.get(2);
        }
        while(j<tasks.length){
            ret[j++]=queue.poll().get(2);
        }
        return ret;


//        int i = 0,j=0;
//        while(i<tasks.length){
//            while(i<tasks.length&&tasks[i][0]<=time){
//
//                List<Integer> tmp = new ArrayList<>();
//                tmp.add(tasks[i][0]);
//                tmp.add(tasks[i][1]);
//                tmp.add(i);
//                queue.add(tmp);
////                time+=tasks[i][1];
//                i++;
//            }
//            List<Integer> tmp2 = queue.poll();
//            time+= tmp2.get(1);
//            ret[j++] = tmp2.get(2);
//        }
//        while(j<tasks.length){
//            ret[j++]=queue.poll().get(2);
//        }
//        return ret;
    }

    @Test
    public void testGetOrder(){
        int[][] test = new int[][]{{7,10},{7,12},{7,5},{7,4},{7,2}};
        System.out.println(getOrder(test));
    }


    /**
     * 797. All Paths From Source to Target
     * @param graph
     * @return
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int node = 0;
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        path.add(node);
        dfsSearch(graph,node,res,path);
        return res;
    }

    private void dfsSearch(int[][] graph, int node, List<List<Integer>> res, List<Integer> path){
        if(node == graph.length-1) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int nextNode: graph[node]){
            path.add(nextNode);
            dfsSearch(graph,nextNode,res,path);
            path.remove(path.size()-1);
        }
    }































}
