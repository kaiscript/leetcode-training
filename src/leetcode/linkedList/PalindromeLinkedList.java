package leetcode.linkedList;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //找到后半个链表的起点
        fast = slow.next;
        slow.next = null;
        //反转后半部分链表
        ListNode pre = null;
        while (fast != null) {
            ListNode next = fast.next;
            fast.next = pre;

            pre = fast;
            fast = next;
        }
        slow = dummy.next;
        while (pre != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }




    public boolean isPalindrome0(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            if (fast.next!= null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        ListNode reverseNode = reverseList(slow);

        while (reverseNode != null && head != null) {
            if (reverseNode.val == head.val) {
                reverseNode = reverseNode.next;
                head = head.next;
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }

    public ListNode reverseList(ListNode node) {
        ListNode pre = null;
        ListNode current = node;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = pre;

            pre = current;
            current = next;
        }
        return pre;
    }

}
