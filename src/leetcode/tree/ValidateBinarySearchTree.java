package leetcode.tree;

/**
 * 98. Validate Binary Search Tree
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *  
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {

        return helper(root, null, null);
    }

    /**
     * 递归分治求解。当需要判断当前节点是否大于左子树上界及小于右子树的下界
     * @param root
     * @param lower
     * @param upper
     * @return
     */
    public boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        //当前节点小于等于下界则不满足平衡树
        if (lower != null && val <= lower) {
            return false;
        }
        //当前节点大于等于上界则不满足平衡树
        if (upper != null && val >= upper) {
            return false;
        }
        if (!helper(root.left, lower, val)) {
            return false;
        }
        if (!helper(root.right, val, upper)) {
            return false;
        }
        return true;

    }

}
