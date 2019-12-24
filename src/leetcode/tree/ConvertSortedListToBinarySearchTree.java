package leetcode.tree;

import leetcode.linkedList.ListNode;

/**
 * 109. Convert Sorted List to Binary Search Tree
 *
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted linked list: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
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
