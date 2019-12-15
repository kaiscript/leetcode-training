package leetcode.linkedList;

/**
 * 143. Reorder List
 * Medium
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class ReorderList {

    /**
     *
     * 拆成2个链表：
     * L0->L1->L2
     * L5->L4->L3
     * 合并链表：
     * L0->L5->L1->L4->L2->L3
     * @param head
     */
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //拿到后半部分链表的头结点
        fast = slow.next;
        //将前半部分和后半部分链表断开
        slow.next = null;
        ListNode pre = null;
        ListNode next = null;
        //反转后半部分链表
        while (fast != null) {
            next = fast.next;
            fast.next = pre;

            pre = fast;
            fast = next;
        }
        slow = head;
        dummy.next = slow;
        //合并链表
        ListNode node = dummy;
        int carry = 0;
        while (slow != null && pre != null) {
            if (carry == 0) {
                node.next = slow;
                slow = slow.next;
            } else {
                node.next = pre;
                pre = pre.next;
            }
            carry ^= 1;
            node = node.next;
        }
        //处理链表奇数节点的情况
        node.next = slow != null ? slow : pre;
        head = dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ReorderList rl = new ReorderList();
        rl.reorderList(node1);
        System.out.println("");
    }

}
