package com.monkey.sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2:
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * @author tao
 * @date 2021/1/27 10:06 上午
 */
public class T56MergeIntervals {

    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {
            return new int[0][2];
        }

        // 排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // 合并
        ArrayList<int[]> merged = new ArrayList<int[]>();
        for (int[] interval : intervals) {

            int left = interval[0];
            int right = interval[1];

            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < left) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], right);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        T56MergeIntervals t56MergeIntervals = new T56MergeIntervals();
        
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}, {1, 4}, {7, 8}};
        System.out.println(Arrays.deepToString(t56MergeIntervals.merge(intervals)));
    }
}
