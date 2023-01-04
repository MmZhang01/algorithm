package DailyPractice;

import org.junit.Test;

import java.util.*;

public class DailyPractice39 {

    /**
     * 290. Word Pattern
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {
        String[] cs = s.split(" ");
        char[] cp = pattern.toCharArray();
        if(cs.length!= pattern.length()) return false;
        Map<String,Character> dict = new HashMap<>();
        Map<Character,String> dict2 = new HashMap<>();
        for(int i=0;i<cs.length;i++){
            if(!dict.containsKey(cs[i])&&!dict2.containsKey(cp[i])){
                dict.put(cs[i],cp[i]);
                dict2.put(cp[i],cs[i]);
            } else if (dict.containsKey(cs[i])&&dict2.containsKey(cp[i])) {
                if(dict.get(cs[i])!=cp[i]) return false;
            }else return false;
        }
        return true;
    }

    @Test
    public void testWordPattern(){
        System.out.println(wordPattern("abba","dog cat cat dog"));
    }


    /**
     * 520. Detect Capital
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
        // if the first letter is non-capital, all the rest letters are non-capital

        // if the first letter is capital, two situation, first all the rest are capital, second all the rest are non-capital
        if(word.length()==1) return true;
        char[] cw = word.toCharArray();
        if(cw[0]>95){
            for(char c:cw){
                if(c<95) return false;
            }
        }else {
            if(cw[1]<=95){
                for(char c:cw){
                    if(c>95) return false;
                }
            }else {
                for(int i=1;i<cw.length;i++){
                    if(cw[i]<=95) return false;
                }
            }
        }
        return true;
    }

    @Test
    public void testDetectCapitalUse(){
        System.out.println('A'-1);
    }


    // two pointers

    /**
     * 125. Valid Palindrome
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int i = 0,j = s.length()-1;
        while(i<j){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            else if(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            else if(Character.toLowerCase(s.charAt(i))==Character.toLowerCase(s.charAt(j))){
                i++;
                j--;
            }else return false;
        }
        return true;
    }


    /**
     * 5. Longest Palindromic Substring
     */
    private int lo, maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }
    // get the longest palindrome from j,k to its two sides
    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }

    /**
     * 647. Palindromic Substrings
     * @param s
     * @return
     */

    int count = 0;
    public int countSubstrings(String s) {
        for(int i=0;i<s.length();i++){
            findPalindrome(s,i,i);
            findPalindrome(s,i,i+1);
        }
        return count+1;

    }
    private void findPalindrome(String s,int i,int j ){
        while (i>=0 && j<s.length()&&s.charAt(i) == s.charAt(j)){
            i--;
            j++;
            count++;
        }
    }

    /*
     //  use dp    the longest palindrome
    public int countSubstrings(String s) {
    int n = s.length();
    int res = 0;
    boolean[][] dp = new boolean[n][n];
    for (int i = n - 1; i >= 0; i--) {
        for (int j = i; j < n; j++) {
            dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i  + 1 < 3 || dp[i + 1][j - 1]);
            if(dp[i][j]) ++res;
        }
    }
    return res;
}
     */


    /**
     * 944. Delete Columns to Make Sorted
     * @param strs
     * @return
     */
    public int minDeletionSize(String[] strs) {
        if(strs.length<=1) return 0;
        int n = strs[0].length();
        int cnt =0;
        for(int i = 0;i<n;i++){
            for(int j = 1;j<strs.length;j++){
                if(strs[j].charAt(i)<strs[j-1].charAt(i)){
                    cnt++;
                    break;
                }

            }
        }
        return cnt;
    }
@Test
    public void testMinDeletionSize(){
        String[] test = new String[]{"rrjk","furt","guzm"};
        System.out.println(minDeletionSize(test));
    }













}


