package leetcode.dfsbfs;

/**
 * 104. Maximum Depth of Binary Tree
 * Easy
 *
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 */
public class MaximumDepthOfBinaryTree {

    public int max = Integer.MIN_VALUE;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 1);
        return max;
    }

    /**
     * dfs解法
     * @param node
     * @param step
     */
    public void dfs(TreeNode node, int step) {
        if (node == null) {
            return;
        }
        if (step > max) {
            max = step;
        }
        if (node.right != null) {
            step += 1;
            dfs(node.right, step);
            step -= 1;
        }
        if (node.left != null) {
            step += 1;
            dfs(node.left, step);
            step -= 1;
        }
    }

    public int maxDepthDivideConquer(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return divideConquer(root);
    }

    /**
     * 分治法。返回取左子树和右子树深度最大的高度+自身高度（1）
     * @param node
     * @return
     */
    public int divideConquer(TreeNode node) {

        if (node == null) {
            return 0;
        }
        int leftDepth = divideConquer(node.left);
        int rightDepth = divideConquer(node.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);

        TreeNode leftRight = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);
        root.left = left;
        root.right = right;
        right.left = leftRight;
        right.right = rightRight;
        MaximumDepthOfBinaryTree mdb = new MaximumDepthOfBinaryTree();
        System.out.println(mdb.maxDepth(root));
        System.out.println(mdb.maxDepthDivideConquer(root));
    }

}
