package leetcode.number.number54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yxl
 * @date 2023/2/18 下午9:58
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int l = 0, r = matrix[0].length - 1, t = 0, e = matrix.length - 1;
        while (l <= r || t <= e) {
            for (int i = l; i <= r; i++) {
                res.add(matrix[t][i]);
            }
            for (int i=t+1; i<=e;i++) {
                res.add(matrix[i][r]);
            }
            if (l<r&&t<e){
                for (int i=r-1;i>=l;i--){
                    res.add(matrix[e][i]);
                }
                for (int i=e-1;i>=t+1;i--){
                    res.add(matrix[i][l]);
                }
            }
            l++;
            r--;
            t++;
            e--;
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
//        System.out.println(new Solution().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(new Solution().spiralOrder(new int[][]{{1, 2, 3}}));
    }
}
