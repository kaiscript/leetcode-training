package leetcode.tree;


import leetcode.dfsbfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. Binary Tree Paths
 * Easy
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 *
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        dfs(root, String.valueOf(root.val), ret);
        return ret;
    }

    /**
     *
     * @param root
     * @param paths
     * @param path
     */
    public void dfs(TreeNode root, String path, List<String> paths) {
        if (root == null) {
            return;
        }
        //dfs出口，叶子节点
        if (root.left == null && root.right == null) {
            paths.add(path);
            return;
        }
        if (root.left != null) {
            dfs(root.left, path + "->" + root.left.val, paths);
        }
        if (root.right != null) {
            dfs(root.right, path + "->" + root.right.val, paths);
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode leftRight = new TreeNode(5);
        root.left = left;
        root.right = right;
        left.right = leftRight;
        BinaryTreePaths btp = new BinaryTreePaths();
        System.out.println(btp.binaryTreePaths(root));

    }

}
