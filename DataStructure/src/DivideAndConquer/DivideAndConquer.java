package DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

/**
 * 分治算法
 */


public class DivideAndConquer {


    /**
     *241. Different Ways to Add Parentheses (Medium)
     */
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {   // 遇到运算符号，将算式拆成左右两侧
                List<Integer> left = diffWaysToCompute(input.substring(0, i));// 符号左侧计算返回值
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));//符号右侧计算返回值
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (ways.size() == 0) {   //  循环之后，ways中还没有值 表明，input是单一数值，无需计算直接将该值返回
            ways.add(Integer.valueOf(input));
        }
        return ways;
    }
}
