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
        paths(root, ret, "");
        return ret;
    }

    /**
     * 递归
     * @param root
     * @param paths
     * @param path
     */
    public void paths(TreeNode root, List<String> paths, String path) {
        if (root == null) {
            return;
        }
        //将当前节点加到路径
        path += root.val;
        //如果是叶子节点则添加结果
        if (root.left == null && root.right == null) {
            paths.add(path);
        }
        else {
            path += "->";
            paths(root.left, paths, path);
            paths(root.right, paths, path);
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
