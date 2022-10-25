package DailyPractice;


import org.junit.Test;

import java.util.*;

public class DailyPractice14 {
    /**
     * 692. Top K Frequent Words
     * @param words
     * @param k
     * @return
     */

    public List<String> topKFrequent(String[] words, int k) {

        // insert into hash map time: O(n) space:O(n)
        Map<String,Integer> wordsCount = new HashMap<>();
        for(String word : words){
            if(wordsCount.containsKey(word)){
                int cnt = wordsCount.get(word);
                wordsCount.put(word,cnt+1);
            }else wordsCount.put(word,1);
        }

        Queue<String> queue = new PriorityQueue<>(
                (n1,n2) -> wordsCount.get(n1) == wordsCount.get(n2) ? n1.compareTo(n2) : wordsCount.get(n2) - wordsCount.get(n1));

        for(String word:wordsCount.keySet()){
            queue.add(word);
        }

        List<String> result = new LinkedList<>();
        while(k>0){
            result.add(queue.poll());
            k--;
        }
        return result;
    }

//    public List<String> topKFrequent(String[] words, int k) {
//        Map<String, Integer> map = new HashMap();
//        Queue<String> queue = new PriorityQueue<>(
//                (n1,n2) -> map.get(n1) == map.get(n2) ? n1.compareTo(n2) : map.get(n2) - map.get(n1));
//
//        for(String s : words)
//            map.put(s, map.getOrDefault(s, 0) + 1);
//
//        for(String s : map.keySet())
//            queue.add(s);
//
//        List<String> list = new ArrayList();
//        while(k > 0)
//        {
//            list.add(queue.poll());
//            k--;
//        }
//        return list;
//
//    }

    /**
     * 12. Integer to Roman
     *
     * @param num
     * @return
     */
    public java.lang.String intToRoman(int num) {
        if (num < 1 || num > 3999) return "";

        StringBuilder result = new StringBuilder();

        java.lang.String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        int i = 0;
        //iterate until the number becomes zero, NO NEED to go until the last element in roman array
        while (num >0) {
            while ( num >= values[i]) {
                num -= values[i];
                result.append(roman[i]);
            }
            i++;
        }
        return result.toString();
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
//        Set<Integer> set = new HashSet<Integer>();
//        for(int i = 0; i < nums.length; i++){
//            if(i > k) set.remove(nums[i-k-1]);
//            if(!set.add(nums[i])) return true;
//        }
//        return false;


//        for(int i =0;i<nums.length;i++){
//            for(int j =1;j<=k;j++){
//                if(i+j>nums.length-1) break;
//                if(nums[i] == nums[i+j]){
//                    return true;
//                }
//            }
//        }
//        return false;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.add(nums[i])){
                if(set.size()==k+1){
                    set.remove(nums[i-k]);
                }
            }else {return true;}
        }
        return false;
    }

    @Test
    public void testContainsNearbyDuplicate(){
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3},2));
    }
















}
