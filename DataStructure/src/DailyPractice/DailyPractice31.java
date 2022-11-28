package DailyPractice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DailyPractice31 {

    // sort

    /**
     * 56. Merge Intervals
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        // 先排序  按o[0] 升序

        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        List<int[]> list = new ArrayList<>();
        int low = intervals[0][0];
        int high = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=high){
                high = Math.max(high,intervals[i][1]);
            }else {
                list.add(new int[]{low,high});
                low = intervals[i][0];
                high = intervals[i][1];
            }
        }
        list.add(new int[]{low,high});
        int[][] ret =new int[list.size()][];
        int i=0;
        for(int[] arr:list){
            ret[i++] = arr;
        }
//        return list.toArray(new int[list.size()][]);
        return ret;
    }


    /**
     * 27. Remove Element
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        // 双指针    一个遍历数值中数值，一个指向位置
        int i=0;
        for(int num:nums){
            if(num==val){
                continue;
            }else nums[i++]=num;
        }
        return i;
    }


    /**
     * 179. Largest Number
     * @param nums
     * @return
     */

    public String largestNumber(int[] nums) {
        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String order1 = o1+o2;
                String order2 = o2+o1;
                return order2.compareTo(order1);  // this.compareTo(s) 顺序  this-s
                                                    // s.compareTo(this) 逆序 s- this
            }
        };

        //将int[] -> String[]
        String[] numss = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            numss[i] = String.valueOf(nums[i]);
        }

        // 给String[] 排序
        Arrays.sort(numss,cmp);
        // 第一个字符为0的话，结果为0；
        if(numss[0].equals("0")){
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        for(String s:numss){
            sb.append(s);
        }
        return new String(sb);

    }

    int a;
    static int b;

    @Test
    public void test(){
        System.out.println(a);


    }

    public static void main(String[] args){
        int val=-1;
        System.out.println(-val);
    }



















}
