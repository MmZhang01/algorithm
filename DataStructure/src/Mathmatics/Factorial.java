package Mathmatics;

public class Factorial {
    /**
     * 172. Factorial Trailing Zeroes (Easy)
     */

    /*
    阶乘尾部0的个数，相当与找到1-n中 含有因数5的个数
    对于一个数 N，它所包含 5 的个数为：N/5 + N/52 + N/53 + ...，
    其中 N/5 表示不大于 N 的数中 5 的倍数贡献一个 5，N/52 表示不大于 N 的数中 52 的倍数再贡献一个 5 ...。
     */
    public int trailingZeroes(int n) {
        if(n==0) return 0;
        return n/5+trailingZeroes(n/5);
    }
}
