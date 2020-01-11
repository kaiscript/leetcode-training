package leetcode.linkedList;

/**
 * 92. Reverse Linked List II
 * Medium
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class ReverseLinkedListII {

    ListNode processer = null;

    public ListNode reverserN(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        //记录连接的节点
        if (n == 1) {
            processer = head.next;
            return head;
        }
        //在head的下一个节点拿到满足条件的链表。所以要n-1
        ListNode last = reverserN(head.next, n - 1);
        head.next.next = head;
        head.next = processer;
        return last;
    }

    public ListNode reverseBetweenRecursively(ListNode head, int m, int n) {
        if (m == 1) {
            return reverserN(head, n);
        }
        head.next = reverseBetweenRecursively(head.next, m - 1, n - 1);
        return head;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        ListNode pre = null;
        //找到需要开始翻转的节点的前一个节点 connect
        while (m > 1) {
            pre = cur;
            cur = cur.next;
            m--;
            n--;
        }
        ListNode connect = pre;
        //翻转后需要将尾部连接的节点tail
        ListNode tail = cur;

        ListNode next;
        while (n > 0) {
            next = cur.next;
            //反转链表
            cur.next = pre;

            pre = cur;
            cur = next;
            n--;
        }

        if (connect != null) {
            //将 开始翻转的节点的前一个节点 connect 与“反转的链表的最后一个节点相连”
            connect.next = pre;
        }
        else
            head = pre;

        tail.next = cur;
        return head;
    }

}
