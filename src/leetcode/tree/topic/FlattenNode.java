package leetcode.tree.topic;

import leetcode.tree.TreeNode;

/**
 * 114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class FlattenNode {

    /**
     * 后序遍历的思想。将父节点左右子树都铺平成链表，然后连接左右子树已经铺平的链表
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        // 此时左右子树已经铺平成链表
        TreeNode right = root.right;
        TreeNode left = root.left;
        // 将根节点的左子树置为空，将左链表接到根节点右子树
        root.left = null;
        root.right = left;
        // 获取右子树最右的节点，将右链表接到这个节点上
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;

    }

}
