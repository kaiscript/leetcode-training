package leetcode.tree;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author chenkai
 * @date: 2019-12-24
 */
public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return bst(nums, 0, nums.length);
    }

    public TreeNode bst(int[] nums, int start, int end) {
        if (start == end) {
            return null;
        }
        //因为end = nums.length ，所以搜索区间为 [start,end).==> [start,mid),[mid,end).因为是求中间节点root，连接左右子树，所以right的搜索区间为 [mid+1,end)
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = bst(nums, start, mid);
        TreeNode right = bst(nums, mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }

}
