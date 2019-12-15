package leetcode.binary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 349. Intersection of Two Arrays
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            if (binary(nums2, i)) {
                set.add(i);
            }
        }
        int[] result = new int[set.size()];
        int index = 0;
        for (Integer integer : set) {
            result[index++] = integer;
        }
        return result;
    }

    public boolean binary(int[] nums,int target) {
        int start = 0;
        int end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (target > nums[mid]) {
                start = mid + 1;
            }
            if (target < nums[mid]) {
                end = mid;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int[] nums1 = new int[]{1,2};
        IntersectionOfTwoArrays io = new IntersectionOfTwoArrays();
        for (int i : io.intersection(nums, nums1)) {
            System.out.println(i);
        }
    }

}
