package leetcode.linkedList;

/**
 *
 * 430. 扁平化多级双向链表
 *
 * 您将获得一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表。
 * 这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 *
 * 扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。
 *
 * 示例:
 *
 * 输入:
 *  1---2---3---4---5---6--NULL
 *          |
 *          7---8---9---10--NULL
 *              |
 *              11--12--NULL
 *
 * 输出:
 * 1-2-3-7-8-11-12-9-10-4-5-6-NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class FlattenAMultilevelDoublyLinkedList {

    // flattentail: flatten the node "head" and return the tail in its child (if exists)
    // the tail means the last node after flattening "head"

    // Five situations:
    // 1. null - no need to flatten, just return it
    // 2. no child, no next - no need to flatten, it is the last element, just return it
    // 3. no child, next - no need to flatten, go next
    // 4. child, no next - flatten the child and done
    // 5. child, next - flatten the child, connect it with the next, go next
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        if (head.child == null) {
            if (head.next == null) {
                return head;
            }
            return flatten(head.next);
        }
        else {
            Node child = head.child;
            head.child = null;

            Node next = head.next;
            Node childNode = flatten(child);

            head.next = child;
            child.prev = head;

            if (next != null) {
                childNode.next = next;
                next.prev = childNode;
                return flatten(next);
            }
            return childNode;
        }
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

}
