package leetcode.binary;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class FindFirstAndLastPositionOfElementInSortedArray {


    /**
     * 找target最左边的数，再找比target+1最左边的数，两者的区间就是target所在的区间
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int start = binary(nums, target);
        //target可能大过数组所有数，此时返回的下标等于length
        //假如返回下标是0，判断0下标的数是否等于target，不是的话代表找不到target
        if (nums.length == start || nums[start] != target) {
            return new int[]{-1, -1};
        }
        int end = binary(nums, target + 1);
        return new int[]{start, end - 1};
    }

    public int binary(int[] nums, int target) {
        //搜索区间[start,end),当end=length-1时停止搜索
        int start = 0;
        int end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            }
            if (target > nums[mid]) {
                start = mid + 1;
            }
            //因为搜索区间为[start,end),二分后分割为2个区间[start,mid)[mid+1,end),此处为向左缩小搜索区间，故取区间[start,mid)
            else if (target < nums[mid]) {
                end = mid;
            }
        }
        return start;
    }

    /**
     * 非 O(log n)
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRangeIterative(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int slow = -1;
        int fast = -1;
        boolean first = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                continue;
            }
            if (!first) {
                slow = i;
                fast = i - 1;
                first = true;
            }
            fast++;
        }
        return new int[]{slow, fast};
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] nums = new int[]{2, 2};
        FindFirstAndLastPositionOfElementInSortedArray fa = new FindFirstAndLastPositionOfElementInSortedArray();
        for (int i : fa.searchRange(nums, 3)) {
            System.out.println(i);
        }
    }

}
