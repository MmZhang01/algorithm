package DailyPractice;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class DailyPractice26 {
    // Greedy and dp

    /**
     * 561. Array Partition
     * @param nums
     * @return
     */
    //  题目要求将nums分成两两一对，然后求和每一对的最小值 使得结果最大
    // 贪心思想，从小到大排序后，奇数位置即为目标值
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ret = 0;
        for(int i=0;i<nums.length;i+=2){
            ret+=nums[i];
        }
        return ret;

    }

    /**
     * 1323. Maximum 69 Number
     * @param num
     * @return
     */
    public int maximum69Number (int num) {
        // with change int to string
        // check the remainder every time /10
        // record the last 6
        // add 3* 10 to its the index of 6
        int tmp = num;
        int indexSix = -1;
        int curIdex = 0;
        while(tmp!=0){
            if(tmp%10==6){
                indexSix=curIdex;
            }
            tmp=tmp/10;
            curIdex++;
        }
        if(indexSix!=-1){
            num+= 3*Math.pow(10,indexSix);
        }
        return num;

//  method2: change to string
//        // Convert the input 'num' to a string builder 'numSB'.
//        StringBuilder numSB = new StringBuilder();
//        numSB.append(num);
//
//        // Iterate over the string builer (from high to low).
//        for (int i = 0; i < numSB.length(); ++i) {
//            // If we find the first '6', replace it with '9' and break the loop.
//            if (numSB.charAt(i) == '6') {
//                numSB.setCharAt(i, '9');
//                break;
//            }
//        }
//
//        // Convert the modified string builder to integer and return it.
//        return Integer.parseInt(numSB.toString());


//method3:
        // change to string and use build-in function
        // Convert the input 'num' to the string 'numString'.
//        String numString = "" + num;
//
//        // Use the built-in function to replace the first '6' with '9'.
//        // Return the integer converted from the modified 'numString'.
//        return Integer.parseInt(numString.replaceFirst("6", "9"));

    }

    /**
     * 605. Can Place Flowers
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 从头开始数可以种植的数目
        // 需要记录当前位置前一个是否种植，后一个是否种植，前后都没种植，把当前位置种上，并标记
        int len = flowerbed.length;
        int cnt = 0;
        for(int i =0; i<len && cnt<n; i++){
            if(flowerbed[i]==1){
                continue;
            }
            int pre = i==0?0:flowerbed[i-1];
            int next = i==len-1?0:flowerbed[i+1];
            if(pre==0&&next==0){
                cnt++;
                flowerbed[i]=1;
            }
        }
        return cnt>=n;
    }

    /**
     * 1544. Make The String Great
     * @param s
     * @return
     */
    // stack
    //使字符一个个进栈，如果连续进入的两个是bad取出删除
    // 后进先出原则
    public String makeGood(String s) {
        if(s.length()<=1) return s;
        Stack<Character> stack = new Stack<>();
        for(int i =0;i<s.length();i++){
            if(stack.isEmpty()){
                stack.add(s.charAt(i));
                continue;
            }
            if(s.charAt(i)>'Z'){
                if(stack.peek()+32==s.charAt(i)){
                    stack.pop();
                } else stack.add(s.charAt(i));
            }else {
                if(stack.peek()-32==s.charAt(i)){
                    stack.pop();
                }else stack.add(s.charAt(i));
            }
        }
        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return new String(sb.reverse());

//        for(Character c:stack){
//            System.out.println(c);
//        }
//        return String.valueOf(stack);

    }

    @Test
    public void testMakeGood(){
        System.out.println(makeGood("leEeetcode"));
//        System.out.println('E'-'e');
    }

}
