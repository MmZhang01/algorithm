package String;

import java.text.CharacterIterator;
import java.util.HashMap;

public class MyString {

    /**
     * 242. Valid Anagram (Easy)
     */
//    public static boolean isAnagram(String s, String t) {
//        int[] cnts = new int[26];
//        for (char c : s.toCharArray()) {
//            cnts[c - 'a']++;
//        }
//        for (char c : t.toCharArray()) {
//            cnts[c - 'a']--;
//        }
//        for (int cnt : cnts) {
//            if (cnt != 0) {
//                return false;
//            }
//        }
//        return true;
//    }

    /*
    use HashMap
     */
    public static boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> cnts = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            cnts.put(s.charAt(i),cnts.getOrDefault(s.charAt(i),0)+1);
        }
        for (int i = 0; i < t.length(); i++) {
            cnts.put(t.charAt(i),cnts.getOrDefault(t.charAt(i),0)-1);
        }
        for (Character character : cnts.keySet()) {
            if(cnts.get(character)!=0) return false;
        }
        return true;
    }

    /**
     * 409. Longest Palindrome (Easy)
     */
    public static int longestPalindrome(String s){
        int[] cnts= new int[256];
        for (char c : s.toCharArray()) {
            cnts[c]++;
        }
        int palindrome = 0;
        for (int cnt : cnts) {
            palindrome+=(cnt/2)*2;
        }
        if (palindrome<s.length()) {
            palindrome++;
        }
        return palindrome;
    }




}
