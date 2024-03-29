package leetcode.dfsbfs;

import java.util.Arrays;

/**
 * 698. 划分为k个相等的子集
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 */
public class CanPartitionKSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        for (; i < j; i++, j--) {
            // 交换 nums[i] 和 nums[j]
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        int[] bucket = new int[k];
        int sum = 0;
        for (int n : nums)
            sum += n;
        int target = sum / k;
        return backtrack(nums, bucket, 0, target);
    }

    public boolean backtrack(int[] nums, int[] bucket, int index, int target) {
        if (index == nums.length) {
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] != target)
                    return false;
            }
            return true;
        }

        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] + nums[index] > target)
                continue;
            // 做选择
            bucket[i] += nums[index];
            if (backtrack(nums, bucket, index + 1, target)) {
                return true;
            }
            // 撤销选择
            bucket[i] -= nums[index];
        }
        return false;
    }

}
