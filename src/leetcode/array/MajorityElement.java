package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            int c = map.getOrDefault(n, 0) + 1;
            map.put(n, c);
            if (c > nums.length / 2) {
                return n;
            }
        }
        return 0;
    }

    public int vote(int[] nums) {
        int count = 1;
        int candicate = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (candicate == nums[i]) {
                count++;
            } else if (--count == 0) {
                count = 1;
                candicate = nums[i];
            }
        }
        return candicate;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        MajorityElement me = new MajorityElement();
        System.out.println(me.vote(nums));
    }

}
