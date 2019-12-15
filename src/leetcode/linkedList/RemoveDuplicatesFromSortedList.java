package leetcode.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 83. Remove Duplicates from Sorted List
 * Easy
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == cur.val)
                cur.next = cur.next.next;
            else
                cur = cur.next;
        }
        return head;

    }


    public ListNode deleteDuplicates0(ListNode head) {
        if (head == null) {
            return head;
        }
        Set<Integer> set = new HashSet<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy.next;
        ListNode pre = dummy;
        while (node != null) {
            if (!set.add(node.val)) {
                node = node.next;
                if (node == null) {
                    pre.next = node;
                }
                continue;
            }
            pre.next = node;
            pre = node;
            node = node.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        RemoveDuplicatesFromSortedList rd = new RemoveDuplicatesFromSortedList();
        ListNode node = rd.deleteDuplicates(n1);
        System.out.println("");
    }

}
