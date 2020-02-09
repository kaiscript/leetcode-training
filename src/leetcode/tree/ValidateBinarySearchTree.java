package leetcode.tree;

/**
 * 98. Validate Binary Search Tree
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
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
