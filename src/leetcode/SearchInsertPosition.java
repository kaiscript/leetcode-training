package leetcode;

/**
 * 35.
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Example 1:

 Input: [1,3,5,6], 5
 Output: 2
 Example 2:

 Input: [1,3,5,6], 2
 Output: 1
 Example 3:

 Input: [1,3,5,6], 7
 Output: 4
 Example 4:

 Input: [1,3,5,6], 0
 Output: 0
 * Created by kaiscript on 2019/6/16.
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int[] nums = new int[]{0,1,2,3,4,5,6};
        System.out.println(searchInsertPosition.searchInsert(nums, 3));
    }

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (target <= num) {
                return i;
            }
            if (target > num && i != nums.length - 1 && target < nums[i + 1]) {
                return i + 1;
            }
            if (i == nums.length - 1) {
                if (target == nums[i]) {
                    return i;
                }
                else{
                    return nums.length;
                }
            }
        }
        return 0;
    }

    /**
     * 二分法，找到第一个大于等于target的下标
     * @param nums
     * @param target
     * @return
     */
    public int binary(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) >> 1;
        while (left <= right) {
            int num = nums[mid];
            if (target <= num) {
                right = mid - 1;
            }
            else
                left = mid + 1;
            mid = (left + right) >> 1;
        }
        return left;
    }

}
