package leetcode.tree;

import leetcode.dfsbfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. Path Sum II
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 */
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, sum, result, new ArrayList<>());
        return result;
    }

    public void dfs(TreeNode root, int remainSum, List<List<Integer>> result, List<Integer> paths) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && remainSum == root.val) {
            paths.add(root.val);
            result.add(new ArrayList<>(paths));
            paths.remove(paths.size() - 1);
            return;
        }
        remainSum -= root.val;
        paths.add(root.val);
        dfs(root.left, remainSum, result, paths);
        dfs(root.right, remainSum, result, paths);
        paths.remove(paths.size() - 1);
    }

}
