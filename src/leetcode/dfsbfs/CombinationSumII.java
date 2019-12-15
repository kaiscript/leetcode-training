package leetcode.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 * Medium
 *
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * @author chenkai
 * @date: 2019-12-11
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null) {
            return new ArrayList<>();
        }
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    public void dfs(int startIndex, int[] candidates, int remainTarget,List<Integer> combination,List<List<Integer>> result) {

        if (remainTarget == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (remainTarget < candidates[i]) {
                break;
            }
            //
            //如果有连续的相同的数，则选取数字时必须从头取到尾来避免重复的组合，不能跳着选取数字
            //所以用 i > startIndex来表示：第一个数可以选，第二个数开始要进行判断，如果是相同的数则跳过。由第一个数来进行dfs
            //比如1,1,1,2 选等于4的，则只可以选前2个1
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            combination.add(candidates[i]);
            dfs(i + 1, candidates, remainTarget - candidates[i], combination, result);
            combination.remove(combination.size() - 1);
        }

    }

    public static void main(String[] args) {
        CombinationSumII cs = new CombinationSumII();
        int[] nums = new int[]{10, 1, 2, 7, 6, 1, 5};
        System.out.println(cs.combinationSum2(nums, 8));
    }

}
