package AllTypes.TwoPointers;

import org.junit.Test;

import java.util.*;


/**
 * palindrome problem
 *          judge a palindrome
 *              from a position/two close positions to its two side, judge if the letter is same
 *
 * 如果找最长子回文字符串，双指针从中间向两侧
 * 如果直接判断字符串是否为回文，直接从两侧向中间
 *
 *
 */
public class OppositeDirection {
    /**
     * 409. Longest Palindrome
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int res = 0;
        boolean r=false;
        for(int i:map.values()){
            if(i%2==1){
                res+=i-1;
                r=true;
            }else res+=i;
        }
        return r==true?res+1:res;
    }

    /**
     * 125. Valid Palindrome
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int i= 0,j=s.length()-1;
        while(i<j){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }else if(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }else if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))){
                return false;
            }else {
                i++;
                j--;
            }
        }
        return true;
    }

    /**
     * 680. Valid Palindrome II
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {

        int i =0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return isPalindrome(s,i,j-1) || isPalindrome(s,i+1,j);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 5. Longest Palindromic Substring
     * @param s
     * @return
     */
    int lo,max;
    public String longestPalindrome1(String s) {
        // from a postion of the string,judge if the char is the same from its two side,then it is a palindrome
        int n = s.length();
        if(n<2) return s;

        // loop the char in the string.

        for(int i =0;i<n-1;i++){
            extantPalindrome(s,i,i);
            extantPalindrome(s,i,i+1);
        }

        return s.substring(lo,lo+max);
    }

    private void extantPalindrome(String s, int i, int j) {
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        if(j-i-1>max){
            lo= i+1;
            max= j-i-1;
        }
    }

    /**
     * 1. Two Sum
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] ret = new int[2];
        for(int i =0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                ret[0] = map.get(nums[i]);
                ret[1] = i;
                return ret;
            }else map.put(nums[i],i);
        }
        return ret;
    }

    @Test
    public void testTwoSum(){
        int[] num = new int[]{2,3};
        System.out.println(twoSum(num,6));
    }

    /**
     * 15. 3Sum
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        if(nums.length==0) return new ArrayList<>(set);
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if (sum == 0 ) set.add(new ArrayList<>(Arrays.asList(nums[i],nums[j++],nums[k--])));
                else if(sum>0){
                    k--;
                }else j++;
            }
        }
        return new ArrayList<>(set);
    }

    /**
     * 16. 3Sum Closest
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ret=0;
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length-2;i++){
            int j=i+1,k= nums.length-1;
            while (j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum>target){
                    k--;
                }else if(sum<target){
                    j++;
                }else return target;

                int diff = Math.abs(target-sum);
                if(diff<minDiff){
                    ret = sum;
                    minDiff=diff;
                }
            }
        }
        return ret;
    }

    /**
     * 18. 4Sum
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        if(nums.length<4) return new ArrayList<>(set);
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            for(int j=i+1;j<nums.length-2;j++){
                int l = j+1,m = nums.length-1;
                while (l<m){
                    long sum = (long)nums[i]+nums[j]+nums[l]+nums[m];
                    if(sum == target){
                        set.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[l++],nums[m--])));
                    }else if (sum<target) l++;
                    else m--;
                }
            }
        }
        return new ArrayList<>(set);
    }

    @Test
    public void testFourSum(){
        int[] nums = new int[]{1,0,-1,0,-2,2};
        System.out.println(fourSum(nums,0));
    }

    /**
     * 454. 4Sum II
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int k : nums3)
            for(int l : nums4)
                map.put(k + l, map.getOrDefault(k + l, 0) + 1);
        int count = 0;
        for(int i : nums1)
            for(int j : nums2)
                count += map.getOrDefault(-(i + j), 0);
        return count;
    }
}
