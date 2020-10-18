package leetcode.tree.topic;

import leetcode.tree.TreeNode;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class BuildTree {

    /**
     * 前序遍历。
     * 核心逻辑是确定根节点，然后找到左右子树各自的父节点，将根节点与左右子树各自的父节点相连，故递归的逻辑就是要找到中间根节点
     * 先处理逻辑，再对左右子树分别处理.
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    /**
     * 主要是确定根节点的位置，然后缩小在前序遍历序列和中序遍历序列中搜索的范围
     * @param preorder
     * @param inorder
     * @param preStart
     * @param preEnd
     * @param inStart
     * @param inEnd
     * @return
     */
    public TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int val = preorder[preStart];
        TreeNode root = new TreeNode(val);
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (val == inorder[i]) {
                index = i;
                break;
            }
        }
        int leftSize = index - inStart;
        root.left = build(preorder, inorder, preStart + 1, preStart + leftSize, inStart, index - 1);
        root.right = build(preorder, inorder, preStart + leftSize + 1, preEnd, index + 1, inEnd);
        return root;
    }


}
