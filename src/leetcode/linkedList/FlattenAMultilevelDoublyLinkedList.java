package leetcode.linkedList;

/**
 * You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer,
 * which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on,
 * to produce a multilevel data structure, as shown in the example below.
 *
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
 *
 *
 * Example:
 *
 * Input:
 *  1---2---3---4---5---6--NULL
 *          |
 *          7---8---9---10--NULL
 *              |
 *              11--12--NULL
 *
 * Output:
 * 1-2-3-7-8-11-12-9-10-4-5-6-NULL
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
