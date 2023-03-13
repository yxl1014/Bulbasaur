package leetcode.number56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author yxl
 * @date 2023/3/13 下午2:06
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
//        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
//        int i = 0;
//        List<int[]> l = new ArrayList<>();
//        l.add(intervals[0]);
//        for (int j = 1; j < intervals.length; j++) {
//            if (l.get(i)[1]/*res[i][1]*/ >= intervals[j][0]) {
//                l.get(i)[1]/*res[i][1]*/ = Math.max(intervals[j][1], l.get(i)[1]/*res[i][1]*/);
//            } else {
//                ++i;
//                l.add(intervals[j]);
//            }
//        }
//        return l.toArray(new int[l.size()][]);
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[][] res = new int[intervals.length][2];
        int i = 0;
        res[0] = intervals[0];
        for (int j = 1; j < intervals.length; j++) {
            if (res[i][1] >= intervals[j][0]) {
                res[i][1] = Math.max(intervals[j][1], res[i][1]);
            } else {
                res[++i] = intervals[j];
            }
        }
        int[][] r = new int[i + 1][2];
        for (int j = 0; j <= i; j++) {
            r[j] = res[j];
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }
}
