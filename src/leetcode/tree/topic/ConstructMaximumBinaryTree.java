package leetcode.tree.topic;

import leetcode.tree.TreeNode;

/**
 * 654. 最大二叉树
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 *
 *
 * 示例 ：
 *
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 *
 *
 * 提示：
 *
 * 给定的数组的大小在 [1, 1000] 之间。
 *
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 */
public class ConstructMaximumBinaryTree {

    /**
     * 前序遍历
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return build(nums, 0, nums.length);
    }

    public TreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int index = -1;
        int max = 0;
        // 找出数组中最大的节点，即为父节点
        for (int i = start; i < end; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                index = i;
            }
        }
        if (index == -1) {
            return null;
        }
        TreeNode node = new TreeNode(nums[index]);
        node.left = build(nums, start, index);
        node.right = build(nums, index + 1, end);
        return node;
    }

}
