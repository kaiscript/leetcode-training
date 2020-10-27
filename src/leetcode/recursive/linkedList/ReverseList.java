package leetcode.recursive.linkedList;

import leetcode.linkedList.ListNode;

public class ReverseList {

    /**
     * 递归反转链表
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }


    public ListNode processer;

    /**
     * 递归反转前N个节点
     */
    public ListNode reverseN(ListNode head) {
        return reverseNDetail(head, 3);
    }

    public ListNode reverseNDetail(ListNode head, int n) {
        if (n == 1) {
            processer = head.next;
            return head;
        }
        ListNode last = reverseNDetail(head.next, n - 1);
        head.next.next = head;
        head.next = processer;
        return last;
    }

    // ===================

    /**
     * 递归反转中间m到n个节点
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseNDetail(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

}
