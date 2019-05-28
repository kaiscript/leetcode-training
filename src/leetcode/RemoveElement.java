package leetcode;

/**
 * 27.
 *
 *
 * Created by kaiscript on 2019/5/28.
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (val!= num) {
                nums[index++] = num;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        RemoveElement removeElement = new RemoveElement();
        System.out.println(removeElement.removeElement(nums, 0));
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
