package leetcode.tree;

import leetcode.linkedList.ListNode;

/**
 * 109. Convert Sorted List to Binary Search Tree
 * 有序链表转换二叉搜索树
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConvertSortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return bst(head);
    }

    public TreeNode bst(ListNode head) {
        if (head == null) {
            return null;
        }
        //不需要再搞一个dummy来协助遍历，用dummy的话是查找中间节点的前一个节点
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //这里一定要断开啊,找到中间节点就断开链表，不然会造成死循环
        if (pre != null) {
            pre.next = null;
        }
        TreeNode root = new TreeNode(slow.val);
        if (slow == head) {
            return root;
        }
        TreeNode left = bst(head);
        TreeNode right = bst(slow.next);
        root.left = left;
        root.right = right;

        return root;
    }

}
