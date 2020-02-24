package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[][]{};
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        List<int[]> list = new ArrayList<>();
        int[] pre = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            //无交集
            if (pre[1] < cur[0]) {
                list.add(pre);
            }
            //有交集
            else{
                cur[0] = pre[0];
                cur[1] = Math.max(cur[1], pre[1]);
            }
            pre = cur;
        }
        //环最后一个区间上面的遍历没有处理到，要加入一下
        list.add(pre);
        int[][] ret = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            int[] ints = list.get(i);
            ret[i][0] = ints[0];
            ret[i][1] = ints[1];
        }
        return ret;
    }

    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
        int[][] ints = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        for (int[] ints1 : mi.merge(ints)) {
            for (int i = 0; i < ints1.length; i++) {
                System.out.println(ints1[i]);
            }
        }
    }

}
