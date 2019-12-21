package leetcode.tree;

import leetcode.dfsbfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 *
 * Input: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumRootToLeafNumbers {

    int total = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return total;
    }

    /**
     * 更简洁的解法
     * @param root
     * @param sum
     */
    public void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            total += sum * 10 + root.val;
            return;
        }
        dfs(root.left, sum * 10 + root.val);
        dfs(root.right, sum * 10 + root.val);
    }

    public int sumNumbers0(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> result = new ArrayList<>();
        dfs0(root, new ArrayList<>(), result);
        int sum = 0;
        for (Integer integer : result) {
            sum += integer;
        }
        return sum;
    }

    public void dfs0(TreeNode root, List<Integer> paths,List<Integer> sum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            paths.add(root.val);
            int s = 0;
            for (int i = paths.size() - 1; i >= 0; i--) {
                s += Math.pow(10, i) * paths.get((paths.size() - 1 - i));
            }
            sum.add(s);
            paths.remove(paths.size() - 1);
            return;
        }

        paths.add(root.val);
        dfs0(root.left, paths, sum);
        dfs0(root.right, paths, sum);
        paths.remove(paths.size() - 1);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        SumRootToLeafNumbers srt = new SumRootToLeafNumbers();
        System.out.println(srt.sumNumbers(root));
    }

}
