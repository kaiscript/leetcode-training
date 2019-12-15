package leetcode.binary;

/**
 * 162. Find Peak Element
 *
 * A peak element is an element that is greater than its neighbors.
 *
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 *
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 *
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 *              or index number 5 where the peak element is 6.
 * Note:
 *
 * Your solution should be in logarithmic complexity.
 *
 */
public class FindPeakElement {

    /**
     * 二分法。定位到在山顶的左边山腰，则说明山顶在右边，则start=mid+1。定位到在山顶的右边山腰，则说明山顶在左边，则end = mid
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        //要使得start和end等于时才推出循环，也就是在山顶的时候。如果start<=end ，则会导致退出条件是山顶的下一个坐标
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            }
            else {
                //搜索区间[start,end),故end = mid
                end = mid;
            }
        }
        return start;
    }

}
