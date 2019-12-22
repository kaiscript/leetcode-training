package leetcode.dfsbfs;

import leetcode.tree.TreeNode;

import java.util.*;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean order = true;
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //如果是偶数层，则按顺序加入。奇数层则逆序加入
                if (order)
                    list.add(node.val);
                else
                    list.add(0, node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
            order = order ? false : true;
        }
        return result;
    }

    public List<List<Integer>> zigzagLevelOrder0(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //通过高度和addFirst先进后出，来实现锯齿形遍历
        int depth = 0;
        while (!queue.isEmpty()) {
            List<Integer> res = new ArrayList<>();
            int size = queue.size();
            List<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                list.add(queue.poll());
            }
            for (TreeNode node : list) {
                res.add(node.val);
                if (depth % 2 == 0) {
                    if (node.left !=null) {
                        queue.addFirst(node.left);
                    }
                    if (node.right != null) {
                        queue.addFirst(node.right);
                    }
                }
                else{
                    if (node.right != null) {
                        queue.addFirst(node.right);
                    }
                    if (node.left !=null) {
                        queue.addFirst(node.left);
                    }
                }
            }
            result.add(res);
            depth++;
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal bt = new BinaryTreeZigzagLevelOrderTraversal();
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode rightLeft = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);
        root.left = left;
        root.right = right;
        right.left = rightLeft;
        right.right = rightRight;
        System.out.println(bt.zigzagLevelOrder(root));
    }

}
