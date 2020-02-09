package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 129. 求根到叶子节点数字之和
 *
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 *
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
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

    /**
     * 不太简洁的解法，记录路径再求和
     * @param root
     * @param paths
     * @param sum
     */
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
