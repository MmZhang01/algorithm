package AllTypes.Stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class StackImpl {

    /**
     * 150. Evaluate Reverse Polish Notation
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        // use stack store the number or forward result
        // during the process, if we meet an operator, we retrieve the number from the stack
        Stack<String> stack = new Stack<>();
        Set<String> set = new HashSet<>(Arrays.asList("+","-","*","/"));

        for(String s:tokens){
            if(set.contains(s)){
                if(s.equals("+")){
                    int tmp = Integer.parseInt(stack.pop())+Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(tmp));
                }else if(s.equals("-")){
                    int tmp1 = Integer.parseInt(stack.pop());
                    int tmp2 =  Integer.parseInt(stack.pop());
                    stack.add(String.valueOf(tmp2-tmp1));
                } else if (s.equals("*")) {
                    int tmp = Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop());
                    stack.add(String.valueOf(tmp));
                } else if (s.equals("/")) {
                    int tmp1 = Integer.parseInt(stack.pop()) ;
                    int tmp2 = Integer.parseInt(stack.pop());
                    stack.add(String.valueOf(tmp2/tmp1));
                }}
            else stack.push(s);
            }
        return Integer.parseInt(stack.pop()) ;
        }

    /**
     * 224. Basic Calculator
     * @param s
     * @return
     */
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = 10 * number + (int)(c - '0');
            }else if(c == '+'){
                result += sign * number;
                number = 0;
                sign = 1;
            }else if(c == '-'){
                result += sign * number;
                number = 0;
                sign = -1;
            }else if(c == '('){
                //we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;
                result = 0;
            }else if(c == ')'){
                result += sign * number;
                number = 0;
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

            }
        }
        if(number != 0) result += sign * number;
        return result;
    }

}

