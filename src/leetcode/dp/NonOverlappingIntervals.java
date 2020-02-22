package leetcode.dp;

import java.util.Arrays;

/**
 *
 * 435. 无重叠区间
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 *
 * 输入: [ [1,2], [1,2], [1,2] ]
 *
 * 输出: 2
 *
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 *
 * 输入: [ [1,2], [2,3] ]
 *
 * 输出: 0
 *
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        //先根据end排序
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        int end = intervals[0][1];
        int count = 1;
        //找出没有重叠的区间数量
        for (int[] interval : intervals) {
            int start = interval[0];
            //区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠
            if (start >= end) {
                count++;
                end = interval[1];
            }
        }
        //长度-没有重叠的区间数量=使得区间没有重叠需要移除的区间数量
        return intervals.length - count;
    }

}
