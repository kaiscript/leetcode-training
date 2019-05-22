package leetcode;

/**
 *
 * Created by kaiscript on 2019/5/22.
 */
public class RemoveDuplicates {


    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        int num = 1;
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] != nums[i]) {
                num++;
                nums[index++] = nums[i];
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,1,3,3,5};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(removeDuplicates.removeDuplicates(nums));
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
