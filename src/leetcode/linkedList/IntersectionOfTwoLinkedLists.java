package leetcode.linkedList;

/**
 * 160
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNodeWithCount(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int i = 0;
        int j = 0;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != null) {
            i++;
            nodeA = nodeA.next;
        }
        while (nodeB != null) {
            j++;
            nodeB = nodeB.next;
        }
        int diff = i > j ? i - j : j - i;
        if (i > j) {
            for (int k = 0; k < diff; k++) {
                headA = headA.next;
            }
        }
        else{
            for (int k = 0; k < diff; k++) {
                headB = headB.next;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    /**
     * 反转链表再求intersectionNode会修改数据结构，不符合要求
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        reverseNodeList(headA);
        reverseNodeList(headB);
        while (headA.next != null && headB.next != null) {
            headA = headA.next;
            headB = headB.next;
            if (headA == headB) {
                return headA;
            }
        }
        return null;
    }

    /**
     * 迭代法反转链表
     * @param head
     */
    public void reverseNodeList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
    }

}
