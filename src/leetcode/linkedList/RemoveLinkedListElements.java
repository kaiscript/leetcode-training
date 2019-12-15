package leetcode.linkedList;

/**
 * 203. Remove Linked List Elements
 * Easy
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class RemoveLinkedListElements {


    public ListNode removeElements(ListNode head, int val) {
        //利用dummy记录改变后的链表节点位置，因为head可能被remove
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            }
            else
                pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }


}
