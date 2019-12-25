package leetcode.tree;

import java.util.Stack;

/**
 * 230. Kth Smallest Element in a BST
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class KthSmallestElementInABST {

    /**
     * 利用中序遍历，BST的中序遍历其实就是排序好的数组了
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        stack.add(cur);
        int index = 1;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (index == k) {
                return cur.val;
            }
            cur = cur.right;
            index++;
        }
        return 0;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(4);
        TreeNode leftRight = new TreeNode(2);
        root.left = left;
        root.right = right;
        left.right = leftRight;

        KthSmallestElementInABST kthSmallestElementInABST = new KthSmallestElementInABST();
        System.out.println(kthSmallestElementInABST.kthSmallest(root, 3));

    }

}
