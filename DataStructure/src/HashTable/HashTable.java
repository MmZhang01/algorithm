package HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


/*
使用hashset/hashmap 牺牲空间复杂度 降低 时间复杂度
 */

public class HashTable {


    /**
     * 1. Two Sum (Easy)
     */
    public int[] twoSum(int[] nums,int target){
        HashMap<Integer,Integer> indexForNum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(indexForNum.containsKey(target-nums[i])){
                return new int[]{indexForNum.get(target-nums[i]),i};
            }else indexForNum.put(nums[i],i);
        }return null;
    }

    /**
     * 217. Contains Duplicate (Easy)
     */
    public boolean containsDuplicate(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size()!=nums.length;
    }

    /**
     * 594. Longest Harmonious Subsequence (Easy)
     */
    public int findHS(int[] nums){
        Map<Integer,Integer> countForNum = new HashMap<>();
        for (int num : nums) {
            countForNum.put(num,countForNum.getOrDefault(num,0)+1);
        }
        int longest = 0;
        for (int num : countForNum.keySet()) {
            if (countForNum.containsKey(num+1)){
                longest = Math.max(longest,countForNum.get(num)+countForNum.get(num+1));
            }
        }
        return longest;
    }

}
