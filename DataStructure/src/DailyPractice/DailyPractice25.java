package DailyPractice;

import org.junit.Test;

import java.util.*;

public class DailyPractice25 {
    //双指针  /贪心
    /**
     *
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        // array.asList 接受的是 char 封装成Character， 接受 char[] 封装char
        HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o','u','A','E','I','O','U'));
        int i=0,j=s.length()-1;
        char[] string = s.toCharArray();
        while (i<j){
            if(set.contains(string[i])&& set.contains(string[j])){
                char tmp = string[i];
                string[i]=string[j];
                string[j]=tmp;
                i++;
                j--;
                continue;
            }
            if(!set.contains(string[i])) i++;
            if(!set.contains(string[j])) j--;

        }
        return new String(string);
    }

    @Test
    public void testReverseVowels(){
//        System.out.println(reverseVowels("hello"));

        System.out.println(Arrays.asList('a', 'e', 'i', 'o','u').contains('i'));
    }

    /**
     * 34. Find First and Last Position of Element in Sorted Array
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        // 两次二分查找
        if(nums==null||nums.length==0) return new int[]{-1,-1};
        int l = -1,r =nums.length;
        while(l+1!=r){
            int mid = (l+r)/2;
            if(nums[mid]<target){
                l = mid;
            }else r=mid; // r 为target左下标
        }
        int l2 = -1,r2 = nums.length;
        while(l2+1!=r2){
            int mid = (l2+r2)/2;
            if(nums[mid]<=target){
                l2=mid;
            }else r2=mid;   // r2-1 为target最右边下标
        }
        if(r==nums.length|| nums[r] != target){
            return new int[]{-1,-1};
        }
        return new int[]{r,r2-1};
    }

    /**
     * 524. Longest Word in Dictionary through Deleting
     * @param s
     * @param dictionary
     * @return
     */
    public String findLongestWord(String s, List<String> dictionary) {
        int max = 0;
        HashMap<Integer,List<String>> map = new HashMap<>();
        map.put(max,new ArrayList<>());
        map.get(max).add("");
        for(String s1:dictionary){
            if(isSub(s,s1)){
                if(s1.length()>=max){
                    max = s1.length();
                    List<String> tmp = map.getOrDefault(max,new ArrayList<>());
                    tmp.add(s1);
                    map.put(max,tmp); // 如果返回是默认值，新列表，需要重新进入map中
                }
            }
        }
        Collections.sort(map.get(max));
        return map.get(max).get(0);
    }
    private boolean isSub(String s, String s1){
        //双指针
        int i = 0, j =0;
        while(i<s.length() && j<s1.length()){
            if(s1.charAt(j) == s.charAt(i)){
                i++;
                j++;
            }else i++;
        }
        if( j == s1.length()){
            return true;
        }else return false;
    }

    @Test
    public void testFindLongestWord(){
//        String[] arr = new String[]{"ale","apple","monkey","plea"};
//        List<String> list = new ArrayList<>(Arrays.asList(arr));
////        System.out.println(list);
//        System.out.println(findLongestWord("11",list));
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        map.getOrDefault(1,new ArrayList<Integer>()).add(3);
        System.out.println(map.get(1));
    }

    /**
     * 15. 3Sum
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 三个指针
        // nums排序之后， 一个指针遍历nums  另两个指针遍历nums之后的数字
        // 找到数组之后进入set
        Set<List<Integer>> res  = new HashSet<>();
        if(nums.length==0) return new ArrayList<>(res);
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++){
            int j =i+1;
            int  k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                // 列表的哈希值与列表的值和顺序有关
                if(sum==0)res.add(Arrays.asList(nums[i],nums[j++],nums[k--])); // 集合添加列表根据列表哈希值判断是否重复
                else if (sum >0) k--;
                else if (sum<0) j++;
            }

        }
        return new ArrayList<>(res);



    }











}
