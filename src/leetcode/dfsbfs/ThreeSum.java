package leetcode.dfsbfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 15. 三数之和
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        int[] books = new int[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, books, new ArrayList<>(), result);
        return result;
    }

    public void dfs(int[] nums, int[] books, List<Integer> paths, List<List<Integer>> result) {

        if (paths.size() == 3) {
            int sum = 0;
            for (Integer path : paths) {
                sum += path;
            }
            if (sum == 0) {
                List<Integer> temp = new ArrayList<>(paths);
                temp.sort(null);
                if (!result.contains(temp)) {
                    result.add(new ArrayList<>(temp));
                }
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (books[i] == 0) {
                books[i] = 1;
                paths.add(nums[i]);
                dfs(nums, books, paths, result);
                books[i] = 0;
                paths.remove(paths.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = new int[]{0,-1,-2,1,2,3};
        System.out.println(threeSum.threeSum(nums));
    }

}
