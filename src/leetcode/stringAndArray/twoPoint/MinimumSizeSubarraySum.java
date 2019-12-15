package leetcode.stringAndArray.twoPoint;

/**
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class MinimumSizeSubarraySum {

    /**
     * 滑动窗口法
     * 1.增大计算区间，判断是否大于s，外层循环则可满足
     * 2.当大于s之后，逐渐缩短左侧区间下标，找到满足大于s的最小区间
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        //外层循环逐渐增大区间右侧游标
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                min = Math.min(min, i - left + 1);
                //移动左侧坐标，缩小计算区间，找出满足条件的最小区间
                sum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLenBruteForce(int s, int[] nums) {
        int min = nums.length;
        if (min == 0) {
            return 0;
        }
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s && (j - i + 1) <= min) {
                    min = j - i + 1;
                    flag = true;
                    break;
                }
            }
        }
        return flag ? min : 0;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum mss = new MinimumSizeSubarraySum();
        int[] nums = new int[]{2,3,1,2,4,3};
        System.out.println(mss.minSubArrayLenBruteForce(7, nums));
        System.out.println(mss.minSubArrayLen(7, nums));
    }

}