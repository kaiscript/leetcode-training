package leetcode.linkedList;

/**
 * 61. Rotate List
 * Medium
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 *
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */
public class RotateList {


    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy;
        ListNode fast = dummy;
        dummy.next = head;
        int length = 0;

        while (fast != null && fast.next != null) {
            length++;
            fast = fast.next;
        }
        k = length - k % length;
        for (int i = 0; i < k; i++) {
            slow = slow.next;
        }

        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;

    }


    //快指针指向头结点，前个指针指向空
    public ListNode rotateRight0(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        //虚拟节点
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy;
        ListNode fast = dummy;
        int length = 0;
        while (fast.next != null) {
            length++;
            fast = fast.next;
        }
        int step = length - k % length;
        for (int i = 0; i < step; i++) {
            slow = slow.next;
        }
        fast.next = dummy;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }

}
