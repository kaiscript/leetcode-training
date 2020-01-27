package leetcode.linkedList;

/**
 * 86. Partition List
 * 分隔链表:
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode dummy;
        ListNode connect;
        ListNode before = new ListNode(0);
        ListNode after = new ListNode(0);
        connect = after;
        dummy = before;
        while (head != null) {
            if (head.val < x) {
                before.next = new ListNode(head.val);
                before = before.next;
            }
            else{
                after.next = new ListNode(head.val);
                after = after.next;
            }
            head = head.next;
        }
        before.next = connect.next;
        return dummy.next;
    }

}
