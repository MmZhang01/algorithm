package DailyPractice;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DailyPractice5 {

    /**
     *42. Trapping Rain Water
     */
    /*
    Two Pointers
     */
    public int trap(int[] height) {
        int left = 0, right =height.length-1;
        int left_max = 0,right_max =0;
        int ans = 0;
        while (left<right){
            if(height[left]<height[right]){
                if(height[left]>=left_max){
                    left_max = height[left];
                }else{
                    ans+=left_max-height[left];
                }
                left++;
            }else{
                if(height[right]>=right_max){
                    right_max=height[right];
                }else{
                    ans+=right_max-height[right];
                }
                right--;
            }
        }
        return ans;
    }

    private Set<Character> vowels = new HashSet<Character>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public String reverseVowels(String s) {
        int i=0,j=s.length()-1;
        char[] result = s.toCharArray();
        while(i<j){
            if(vowels.contains(result[i])){
                if(vowels.contains(result[j])){
                    char tmp = result[i];
                    result[i] = result[j];
                    result[j] = tmp;
                    i++;
                    j--;
                }else j--;
            }else i++;
        }

        return new String(result);
    }
    @Test
    public void testReverseVowels(){
        System.out.println(reverseVowels("hello"));
    }

}
