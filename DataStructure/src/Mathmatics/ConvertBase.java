package Mathmatics;

/*
对于转换成小于十进制base的形式
先构建一个stringbuilder  将十进制的的取余值依次填入  然后逆序

进制转换 取余结果总是逆序的
 */

public class ConvertBase {

    /**
     * 504. Base 7 (Easy)
     */
//    public static String convertToBase7(int num) {
//        if(num == 0){return "0";}
//        StringBuilder sb = new StringBuilder();
//        boolean isNegative = num<0;
//        if(isNegative){num=-num;}
//        while(num>0){
//            sb.append(num%7);
//            num/=7;
//        }
//        String ret=sb.reverse().toString();
//        return isNegative?"-"+ret:ret;
//    }

    public static String convertToBase7(int num) {
        return Integer.toString(num, 7);
    }

    /**
     * 405. Convert a Number to Hexadecimal (Easy)
     */
//    public static String toHex(int num){
//        char[] map={'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
//        if(num == 0){return "0";}
//        StringBuilder sb = new StringBuilder();
//        while (num!=0){
//            sb.append(map[num & 0b1111]);
//            num>>>=4;
//        }
//        return sb.reverse().toString();
//    }

    public static String toHex(int num){
        char[] map={'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        while(num>0){
            sb.append(map[num%16]);
            num/=16;
        }
        String ret = sb.reverse().toString();
        return ret;
    }



    /**
     * 168. Excel Sheet Column Title (Easy)
     */
    public String convertToTitle(int num){
        if(num==0){
            return "";
        }
        num--;
        return convertToTitle(num/26)+(char)(num%26+'A');
    }
}

