package DailyPractice;

import java.util.*;

public class DailyPractice42 {


//    public List<Integer> findAnagrams(String s, String p) {
//        int n = p.length();
//        List<Integer> ret = new ArrayList<>();
//
//        for(int i =0;i<=s.length()-n;i++){
//            if(isAnagram(s.substring(i,i+n),p)){
//                ret.add(i);
//            }
//        }
//        return ret;
//    }
//    private boolean isAnagram(String s,String p){
//        int[] dict = new int[26];
//        for(char cs: s.toCharArray()){
//            dict[cs-'a']++;
//        }
//        for(char cp:p.toCharArray()){
//            dict[cp-'a']--;
//        }
//        for(int i:dict){
//            if(i!=0) return false;
//        }
//        return true;
//    }

    /**
     * 438. Find All Anagrams in a String
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;

        int[] hash = new int[256]; //character hash

        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right)] >= 1) {
                count--;
            }
            hash[s.charAt(right)]--;
            right++;

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) {
                list.add(left);
            }
            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() ) {

                if (hash[s.charAt(left)] >= 0) {
                    count++;
                }
                hash[s.charAt(left)]++;
                left++;

            }


        }
        return list;
    }


    /**
     * 1470. Shuffle the Array
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffle(int[] nums, int n) {
        int[] ret = new int[2*n];
        int p1 = 0,p2=n;
        for(int i =0;i<2*n;){
            ret[i++]=nums[p1++];
            ret[i++]=nums[p2++];
        }
        return ret;
    }

    /**
     * 904. Fruit Into Baskets
     * @param fruits
     * @return
     */
    public int totalFruit(int[] fruits) {

        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        int res = 0, i = 0;
        for (int j = 0; j < fruits.length; ++j) {
            count.put(fruits[j], count.getOrDefault(fruits[j], 0) + 1);
            while (count.size() > 2) {
                count.put(fruits[i], count.get(fruits[i]) - 1);
                if (count.get(fruits[i]) == 0) count.remove(fruits[i]);
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

    /**
     * 45. Jump Game II
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        int depth = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while (size--!=0){
                int index = q.poll();
                if(index == nums.length-1) return depth;
                for(int j = 1; j<=nums[index];j++){
                    int nextIndex = index+j;
                    if (nextIndex>nums.length-1) break;
                    if(visited[nextIndex]) continue;
                    q.add(nextIndex);
                    visited[nextIndex] =true;
                }
            }
            depth++;
        }
        return -1;
    }
}
