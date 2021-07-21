package leetcode.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. Permutations II
 *
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int[] books = new int[nums.length];
        //排序的目的是为了判断重复数字是否选过
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), result, books);
        return result;
    }

    //递归定义
    public void dfs(int[] nums, List<Integer> paths, List<List<Integer>> result,int[] books) {
        //递归出口
        if (paths.size() == nums.length) {
            result.add(new ArrayList<>(paths));
            return;
        }
        //递归拆解，从选择列表中选择符合条件的数字
        for (int i = 0; i < nums.length; i++) {
            if (books[i] == 1) {
                continue;
            }
            // 选代表：为了避免重复，只选择第一个重复的数字进行dfs
            //如果当前数跟前一个数相等，判断前一个数是否选择过，是的话跳过，证明前面已经选过重复的数字了

            // 在重复的数字中，只选择第一个数字进行回溯。故当第二个重复的数字开始回溯时，判断前一个是否排列过，没有排列过则说明正在进行回溯，跳过
            // 例如，[1,1,2]中。 选择第2个1，开始遍历第1个1时，跳过
            if (i >= 1 && nums[i] == nums[i - 1] && books[i - 1] == 0) {
                continue;
            }
            paths.add(nums[i]);
            books[i] = 1;
            dfs(nums, paths, result, books);
            //回溯
            paths.remove(paths.size() - 1);
            books[i] = 0;
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        PermutationsII permutationsII = new PermutationsII();
        System.out.println(permutationsII.permuteUnique(nums));
    }

}
