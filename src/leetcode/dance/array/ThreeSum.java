package leetcode.dance.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
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
 */
public class ThreeSum {

    /**
     * 维护 3个指针，k，i，j
     * 固定k，然后移动 i向右移动， j向左移动，算3个数字之和
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {

            if (nums[k] > 0) {
                break;
            }
            //跳过重复数字
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {

                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    //找不到sum=0的数，则移动指针，跳过重复的数
                    while (i < j && nums[i] == nums[++i]) ;
                }
                else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) ;
                }
                else{
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[k]);
                    res.add(nums[i]);
                    res.add(nums[j]);
                    ret.add(res);
                    //跳过重复的数
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }

        }
        return ret;

    }


    public List<List<Integer>> threeSumDfs(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] books = new int[nums.length];
        dfs(nums, books, new ArrayList<>(), res);
        return res;
    }

    /**
     * dfs 会超时 = =
     * @param nums
     * @param books
     * @param path
     * @param res
     */
    public void dfs(int[] nums, int[] books, List<Integer> path, List<List<Integer>> res) {

        if (path.size() == 3) {
            int sum = 0;
            for (Integer integer : path) {
                sum += integer;
            }
            if (sum == 0) {
                List<Integer> temp = new ArrayList<>(path);
                temp.sort(null);
                if (!res.contains(temp)) {
                    res.add(new ArrayList<>(temp));
                }
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (books[i] == 0) {
                books[i] = 1;
                path.add(nums[i]);
                dfs(nums, books, path, res);
                books[i] = 0;
                path.remove(path.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = new int[]{3,-9,3,9,-6,-1,-2,8,6,-7,-14,-15,-7,5,2,-7,-4,2,-12,-7,-1,-2,1,-15,-13,-4,0,-9,-11,7,4,7,13,14,-7,-8,-1,-2,7,-10,-2,1,-10,6,-9,-1,14,2,-13,9,10,-7,-8,-4,-14,-5,-1,1,1,4,-15,13,-12,13,12,-11,12,-12,2,-3,-7,-14,13,-9,7,-11,5,-1,-2,-1,-7,-7,0,-7,-4,1,3,3,9,11,14,10,1,-13,8,-9,13,-2,-6,1,10,-5,-6,0,1,8,4,13,14,9,-2,-15,-13};
        System.out.println(threeSum.threeSum(nums));
    }

}
