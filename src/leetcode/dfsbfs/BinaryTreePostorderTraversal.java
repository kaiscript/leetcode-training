package leetcode.dfsbfs;

import java.util.LinkedList;
import java.util.List;

/**
 * 145. Binary Tree Postorder Traversal
 * Hard
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [3,2,1]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 */
public class BinaryTreePostorderTraversal {

    /**
     * 前序遍历是根左右。
     * 后续遍历是左右根。
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        //此处output如果是addLast，则结果是根右左。此处addFirst相当于逆序输出。变成了左右根，刚好是后序遍历的结果
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        TreeNode right = new TreeNode(2);
        TreeNode rightLeft = new TreeNode(3);
        root.right = right;
        right.left = rightLeft;
        BinaryTreePostorderTraversal btp = new BinaryTreePostorderTraversal();
        System.out.println(btp.postorderTraversal(root));
    }

}
