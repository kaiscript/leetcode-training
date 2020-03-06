package leetcode.stringAndArray.windows;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 *
 * 限制：
 *
 * 1 <= target <= 10^5
 *
 * @author chenkai
 * @date: 2020-03-06
 */
public class FindContinuousSequence {

    public int[][] findContinuousSequence(int target) {
        int start = 1;
        int cur = start + 1;
        List<int[]> ret = new ArrayList<>();
        while (start <= target - 1 && cur <= target - 1) {
            int sum = (start + cur) * (cur - start + 1) / 2;
            if (sum == target) {
                int[] arr = new int[cur - start + 1];
                for (int i = start; i <= cur; i++) {
                    arr[i - start] = i;
                }
                ret.add(arr);
                cur++;
            }
            if (sum < target) {
                cur++;
            }
            else if(sum > target){
                start++;
            }
        }
        int[][] res = new int[ret.size()][];
        for (int i = 0; i < ret.size(); i++) {
            res[i] = ret.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        FindContinuousSequence findContinuousSequence = new FindContinuousSequence();
        int[][] continuousSequence = findContinuousSequence.findContinuousSequence(9);
        for (int[] ints : continuousSequence) {
            for (int anInt : ints) {
                System.out.println(anInt);
            }
        }
    }

}
