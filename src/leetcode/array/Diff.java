package leetcode.array;

import java.util.*;

public class Diff {


    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int[] ret = new int[nums1.length];
        int index = 0;
        for (int n : nums2) {
            int count = map.getOrDefault(n, 0);
            if (count > 0) {
                ret[index++] = n;
                count--;
                map.put(n,count);
            }
        }

        return Arrays.copyOfRange(ret, 0, index);
    }


}
