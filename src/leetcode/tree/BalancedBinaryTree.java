package leetcode.tree;

/**
 * 110. Balanced Binary Tree
 * Easy
 *
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 *
 *
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 *
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 *
 */
public class BalancedBinaryTree {


    /**
     * 递归解法,分治法。
     * 分别判断左右子树是否满足平衡树的条件，递归求解
     * @param treeNode
     * @return
     */
    public int depth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = depth(treeNode.left);
        if (left == -1) {
            return -1;
        }
        int right = depth(treeNode.right);
        if (right == -1) {
            return -1;
        }
        //如果高度没相差1则证明是平衡树，返回左右子树的最高高度加上本身节点的高度1
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;

    }


    class ResultType{
        boolean isBalance;
        int depth;

        public ResultType(boolean isBalance, int depth) {
            this.isBalance = isBalance;
            this.depth = depth;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalance;
    }

    /**
     * 分治法
     * @param node
     * @return
     */
    public ResultType helper(TreeNode node) {
        if (node == null) {
            return new ResultType(false, -1);
        }
        ResultType left = helper(node.left);
        ResultType right = helper(node.right);
        //任何一个子树不是平衡树则整棵树都不是
        if (!left.isBalance || !right.isBalance) {
            return new ResultType(false, -1);
        }
        //左右子树高度相差大于1，则不是平衡树
        if (Math.abs(left.depth - right.depth) > 1) {
            return new ResultType(false, -1);
        }
        //如果满足条件，则返回当前node节点所在的子树的高度
        return new ResultType(true, Math.max(left.depth, right.depth) + 1);
    }

}
