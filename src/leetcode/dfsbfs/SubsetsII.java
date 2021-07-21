package leetcode.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 */
public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(0,nums,res,new ArrayList<>());
        return res;
    }

    public void dfs(int start, int[] nums, List<List<Integer>> res, List<Integer> list){
        res.add(new ArrayList<>(list));
        for(int i=start; i < nums.length; i++){
            // 在对数组进行排序的前提下。进行回溯时，只用第一个重复的数字开始回溯，后面重复的数字忽略掉，不然会导致重复。
            // 比如，1,2,2,2; 只从第一个2 开始回溯，不从第二个2开始回溯，否则从第2个2开始的话，会出现第二个[1,2,2]
            if(i>start && nums[i]==nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            dfs(i+1,nums,res,list);
            list.remove(list.size()-1);

        }
    }

}
