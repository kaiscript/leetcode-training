package leetcode.dfsbfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] books = new int[nums.length];
        dfs(nums, 0, result, new ArrayList<>(), books);
        return result;
    }

    /**
     * dfs 。 抽象出 选择列表nums，及决策路径paths
     *
     * @param nums
     * @param step
     * @param result
     * @param paths
     */
    public void dfs(int[] nums, int step, List<List<Integer>> result, List<Integer> paths, int[] books) {
        if (step == nums.length) {
            result.add(new ArrayList<>(paths));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //排列过的不需要再排列了
            if (books[i] != 0) {
                continue;
            }
            paths.add(nums[i]);
            books[i] = 1;
            dfs(nums, step + 1, result, paths, books);
            //回溯
            paths.remove(paths.size() - 1);
            books[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Permutations permutations = new Permutations();
        System.out.println(permutations.permute(nums));
    }

}
