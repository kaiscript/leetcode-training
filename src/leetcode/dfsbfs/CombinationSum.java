package leetcode.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. Combination Sum
 * Medium
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return new ArrayList<>();
        }
        //先排序
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public void dfs(int[] candidates, int remainTarget, int startIndex, List<Integer> combination, List<List<Integer>> result) {


        //拿到结果了
        if (remainTarget == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            //剩余的数大于remainTarget，无法组合了
            if(remainTarget < candidates[i])
                break;
            //前个数跟后个数重复时跳过，区分重复的数。
            //重复的情况已经在dfs里面的参数i体现了
            //这一步去掉也能ac其实
            if (i != 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }

            combination.add(candidates[i]);
            //这里i的原因是因为可重复
            dfs(candidates, remainTarget - candidates[i], i, combination, result);
            combination.remove(combination.size() - 1);
        }

    }


    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] nums = new int[]{2, 2, 3};

        System.out.println(cs.combinationSum(nums, 7));
    }

}
