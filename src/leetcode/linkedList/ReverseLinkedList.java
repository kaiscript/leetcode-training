package leetcode.linkedList;

/**
 * 206.
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {


    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = pre;
            //移动前标，当前坐标
            pre = current;
            current = next;
        }
        return pre;
    }

    public ListNode reverseListRecursively(ListNode cur) {
        if (cur == null || cur.next == null) {
            return cur;
        }
        ListNode newHead = reverseListRecursively(cur.next);
        cur.next.next = cur;
        cur.next = null;
        return newHead;
    }

}
