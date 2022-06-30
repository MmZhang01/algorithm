package TwoPointers;

import java.util.Arrays;
import java.util.HashSet;

public class TwoPointers {

    /*
    * 167. Two Sum II - Input array is sorted (Easy)
    * */
    public int[] TwoSum(int[] numbers, int target){
        if (numbers == null){return null;}
        int i =0;
        int j = numbers.length-1;
        while (i<j){
            if (numbers[i]+numbers[j]==target){
                return new int[]{i+1,j+1};
            }
            else if (numbers[i]+numbers[j]< target){
                i++;
            }
            else {
                j--;
            }
        }
        return null;
    }

    /*
    * 633. Sum of Square Numbers (Easy)
    * */
    public boolean judgeSquareSum(int target){
        if (target < 0){return false;}

        int i = 0, j =(int)Math.sqrt(target);
        while(i<j){
            int powSum = i*i+j*j;
            if (powSum==target){
                return true;
            }else if (powSum<target){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }

    /**
     * 345. Reverse Vowels of a String (Easy)
     */
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s){
        if (s == null) {
            return null;
        }
        int i=0,j=s.length()-1;
        char[] result = new char[s.length()];
        while(i<=j){
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if(!vowels.contains(ci)){
                result[i++]=ci;
            }else if (!vowels.contains(cj)){
                result[j--]=cj;
            }else{
                result[i++]=cj;
                result[j--]=ci;
            }
        }

    return new String(result);}

    /*
    680. Valid Palindrome II (Easy)
     */
    private boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if (s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }return true;
    }
    public boolean validPalindrome(String s){
        for (int i=0,j=s.length()-1;i<j;i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                return(isPalindrome(s,i+1,j)||isPalindrome(s,i,j-1));
            }
        }return true;
    }

    /**
     * 88. Merge Sorted Array (Easy)
     */
    public void merge(int[] nums1,int m, int[] nums2, int n){
        int index1 = m-1,index2=n-1;
        int indexMerge = m+n-1;
        while(index1>=0){
            if (index1<0){
                nums1[indexMerge--]=nums2[index2--];
            }else if(index2<0){
                nums1[indexMerge--]=nums1[index1--];
            }else if(nums1[index1]<nums2[index2]){
                nums1[indexMerge--]=nums2[index2--];
            }else{
                nums1[indexMerge--]=nums1[index1--];
            }
        }
    }

    /**
     * 141. Linked List Cycle (Easy)
     */
    
}
