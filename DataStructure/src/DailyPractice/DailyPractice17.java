package DailyPractice;

import java.util.List;

public class DailyPractice17 {
    // Math base convert
    // dfs

    /**
     * 1239. Maximum Length of a Concatenated String with Unique Characters
     * @param arr
     * @return
     */

    // 使用dfs 复杂度2^n  两个子列结合后，立即使用结合后的新值与剩余值再次结和
      //      [a,b]   a->ab
          //          b
          //
        //    [a,b,c]    a ->ab->abc
            //              ->ac
          //              b ->bc
            //             c
     //       [a,b,c,d]  a->ab  ->abc ->abcd
    //                          ->abd
            //              ->ac->acd
     //                   b ->bc->bcd
            //              ->bd
//                        c  ->cd
            //             d

            //
    int res =0;
    public int maxLength(List<String> arr) {
        dfs("",arr,0);
        return res;
    }

    private void dfs(String s,List<String> list,int id){
        for(int i=id;i<list.size();i++){
            if(isUnique(s+list.get(i))){
                res = Math.max(res, s.length()+list.get(i).length());
                dfs(s+list.get(i),list,i+1);
            }
        }
    }
    private boolean isUnique(String s){
        boolean[] arr = new boolean[26];
        if(s.length()<=1) return true;
        if(s.length()>26) return false;
        for(char c:s.toCharArray()){
            if(arr[c-'a']) return false;
            arr[c-'a'] =true;
        }
        return true;
    }

    /**
     * 504. Base 7
     * @param num
     * @return
     */
    public String convertToBase7(int num) {
//        if (num == 0) return "0";
//        StringBuffer ret = new StringBuffer();
//        boolean postive = num>0;
//        num = Math.abs(num);
//        while(num>0){
//            ret.append(num%7);
//            num=num/7;
//        }
//        return postive==true?ret.reverse().toString():"-"+ret.reverse().toString();

        // use recursive
        if(num/7 ==0) {
            return String.valueOf(num%7);
        }
        return convertToBase7(num/7)+num%7;
    }

    /**
     * 405. Convert a Number to Hexadecimal
     * @param num
     * @return
     */
    public String toHex(int num) {
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        if(num == 0) return "0";
        StringBuffer sb = new StringBuffer();
        while(num!=0){
            // num 后四位与二进制1111做与运算，相当于取余16   因为二进制每四位最大表示16
            sb.append(map[num&0b1111]);
            // num 向右位移四位，前面补领  相当于除16
            num>>>=4;
        }
        return sb.reverse().toString();
    }

    /**
     * 168. Excel Sheet Column Title
     * @param columnNumber
     * @return
     */
    public String convertToTitle(int columnNumber) {
        if(columnNumber ==0) return "";
        StringBuffer sb = new StringBuffer();
        while(columnNumber!=0){
            columnNumber--;
            sb.append((char)(columnNumber%26+'A'));
            columnNumber/=26;
        }
        return sb.reverse().toString();
    }

    /**
     * 172. Factorial Trailing Zeroes
     * @param n
     * @return
     */

    public int trailingZeroes(int n) {
        // convert to how many 5 at n!
        // the number of 5 = n/5 + n/25 +n/125....
        int ret =0;
        while(n!=0){
            ret+=n/5;
            n/=5;
        }
        return ret;

    }















}
