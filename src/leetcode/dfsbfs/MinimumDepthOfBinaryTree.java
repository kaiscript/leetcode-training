package leetcode.dfsbfs;

import javafx.util.Pair;
import leetcode.tree.TreeNode;

import java.util.Stack;

/**
 * 111. Minimum Depth of Binary Tree
 * Easy
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
 * return its minimum depth = 2.
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth0(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth0(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth0(root.left) + 1;
        }
        return Math.min(minDepth0(root.left),minDepth0(root.right)) + 1;
    }

    /**
     * dfs
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth(root.left), minDepth);
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth(root.right), minDepth);
        }
        return minDepth + 1;
    }

    /**
     * bfs的栈实现.
     * 不断地将节点入栈。遇到叶子节点就判断当前深度是否小于最小深度。非叶子节点就深度+1不断入栈
     * @param root
     * @return
     */
    public int minDepthDfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.add(new Pair<>(root, 1));
        int min = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            Integer depth = pair.getValue();
            if (node.left == null && node.right == null) {
                min = Math.min(min, depth);
            }
            if (node.left != null) {
                stack.push(new Pair<>(node.left, depth + 1));
            }
            if (node.right != null) {
                stack.push(new Pair<>(node.right, depth + 1));
            }
        }
        return min;
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
        MinimumDepthOfBinaryTree mdb = new MinimumDepthOfBinaryTree();
        System.out.println(mdb.minDepthDfs(root));
    }
}
