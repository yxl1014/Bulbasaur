package leetcode.number50.fast_power;

/**
 * @author yxl
 * @date 2023/2/8 下午8:06
 */
public class Solution {
    public double myPow(double x, int n) {
        double res = 1.0d;
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2.000000, 10));
    }
}
