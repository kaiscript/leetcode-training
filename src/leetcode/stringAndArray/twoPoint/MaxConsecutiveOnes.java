package leetcode.stringAndArray.twoPoint;

/**
 * Max Consecutive Ones
 * Solution
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 *
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 *     The maximum number of consecutive 1s is 3.
 * Note:
 *
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 */
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int k = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                k++;
                if (k > max) {
                    max = k;
                }
            }
            else
                k = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes mco = new MaxConsecutiveOnes();
        int[] nums = new int[]{1,0,1,1,0,1};
        System.out.println(mco.findMaxConsecutiveOnes(nums));
    }

}
