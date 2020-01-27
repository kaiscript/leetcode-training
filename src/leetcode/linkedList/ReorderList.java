package leetcode.linkedList;

/**
 * 143. Reorder List
 * 重排链表
 * Medium
 *
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
