package leetcode.linkedList;

/**
 * 142.
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to.
 * If pos is -1, then there is no cycle in the linked list.
 *
 * Note: Do not modify the linked list.
 *
 * method:https://java2blog.com/find-start-node-of-loop-in-linkedlist/
 */
public class LinkedListCycleII {


    public ListNode detectCycle0(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean ifExist = false;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                ifExist = true;
                break;
            }
        }

        if (ifExist) {
            slow = head;
            while (fast != null) {
                if (fast == slow) {
                    return slow;
                }
                slow = slow.next;
                fast = fast.next;
            }
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean isExist = false;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                isExist = true;
                break;
            }
        }
        if (isExist) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }

}
