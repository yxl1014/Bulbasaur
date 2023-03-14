package leetcode.jianzhioffer.II020;

/**
 * @author yxl
 * @date 2023/3/14 上午10:15
 */
public class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int sum = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            int l = i / 2;
            int r = l + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                sum++;
                l--;
                r++;
            }
        }
        return sum;
    }

    public int countSubstrings_V1(String s) {
        int n = s.length();
        int sum = 0;
        boolean[][] flag = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        sum++;
                        flag[i][j] = true;
                    } else if (flag[i + 1][j - 1]) {
                        sum++;
                        flag[i][j] = true;
                    }
                }

            }
        }
        return sum;
    }
}
