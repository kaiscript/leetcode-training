package leetcode.linkedList;

/**
 *  24. Swap Nodes in Pairs
 * Medium
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode current = temp;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            //完成pair与前后节点的链接
            //2个node旋转后的，first在第二个位置，连接后驱节点
            first.next = second.next;
            //2个node旋转后的，second在第1个位置。前驱节点连接second
            current.next = second;

            //将second的next指向first，完成旋转
            current.next.next = first;
            //移动到下个节点开始迭代
            current = current.next.next;
        }
        return temp.next;
    }

}
