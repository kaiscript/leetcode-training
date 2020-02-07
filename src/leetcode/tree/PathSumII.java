package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. Path Sum II
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class PathSumII {

    public List<List<Integer>> pathSum0(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs0(root, sum, new ArrayList<>(), result);
        return result;
    }

    public void dfs0(TreeNode root, int sum, List<Integer> curPaths, List<List<Integer>> result) {

        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            curPaths.add(root.val);
            result.add(new ArrayList<>(curPaths));
            curPaths.remove(curPaths.size() - 1);
            return;
        }
        sum -= root.val;
        curPaths.add(root.val);
        dfs0(root.left, sum, curPaths, result);
        dfs0(root.right, sum, curPaths, result);
        curPaths.remove(curPaths.size() - 1);
    }

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
        //到达叶子节点，判断是否满足条件
        if (root.left == null && root.right == null && remainSum == root.val) {
            paths.add(root.val);
            result.add(new ArrayList<>(paths));
            //dfs 回溯
            paths.remove(paths.size() - 1);
            return;
        }
        remainSum -= root.val;
        paths.add(root.val);
        dfs(root.left, remainSum, result, paths);
        dfs(root.right, remainSum, result, paths);
        //dfs 回溯
        paths.remove(paths.size() - 1);
    }

}
