package Mathmatics;

public class StringOperate {
    /**
     * 67. Add Binary (Easy)
     */
    /*
    二进制加减法 每二进一
     */
    public String addBinary(String a, String b) {
        StringBuilder str=new StringBuilder();
        int i =a.length()-1,j=b.length()-1,carry=0;
        while(i>=0||j>=0||carry==1){
            if(a.charAt(i--)=='1'&&i>=0){
                carry++;
            }
            if(b.charAt(j--)=='1'&&j>=0){
                carry++;
            }
            str.append(carry%2);
            carry/=2;
        }
        return str.reverse().toString();
    }

    /**
     * 415. Add Strings (Easy)
     */

    public static String addStrings(String num1, String num2) {
        int i = num1.length()-1,j=num2.length()-1,carry=0;
        StringBuilder str = new StringBuilder();
        while(i>=0||j>=0||carry==1){
            if(i>=0){
                carry+=num1.charAt(i--)-'0';
            }
            if(j>=0){
                carry+=num2.charAt(j--)-'0';
            }
            str.append(carry%10);
            carry/=10;
        }
        return str.reverse().toString();
    }

}
