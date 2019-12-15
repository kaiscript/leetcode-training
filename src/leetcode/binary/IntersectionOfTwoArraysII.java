package leetcode.binary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 350. Intersection of Two Arrays II
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 *
 */
public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        //统计数字出现次数
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i : nums1) {
            if (map1.get(i) == null) {
                map1.put(i, 0);
            }
            map1.put(i, map1.get(i) + 1);
        }

        for (int i : nums2) {
            if (map1.get(i) != null && map1.get(i) > 0) {
                map1.put(i, map1.get(i) - 1);
                list.add(i);
            }
        }

        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }



    public static void main(String[] args) {
        IntersectionOfTwoArraysII io = new IntersectionOfTwoArraysII();
        int[] num1 = new int[]{1, 2, 2, 1};
        int[] num2 = new int[]{2};
        for (int i : io.intersect(num1, num2)) {
            System.out.println(i);
        }
    }

}
