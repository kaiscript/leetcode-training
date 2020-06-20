package leetcode.tree;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 第K大数
 */
public class Kth {

    /**
     * 用Java的PriorityQueue实现大顶堆
     * 添加删除之后，大顶堆根节点肯定是最大的。把超过k数量的节点都删除掉，剩下的k个节点就是最小的k个节点
     * poll出来就是第k大数
     *
     * @param nums
     * @param k
     * @return
     */
    public Integer heapKth(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int num : nums) {
            if (heap.isEmpty() || heap.size() < k || num < heap.peek()) {
                heap.offer(num);
            }
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();

    }

    public Integer quickSortKth(int[] nums, int start, int end, int k) {

        int i = start;
        int j = end;
        int pivot = nums[i];
        while (i < j) {
            while (i < j && nums[j] > pivot) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (i < j && nums[i] < pivot) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = pivot;
        if (i == k - 1) {
            return nums[i];
        } else if (i > k - 1) {
            return quickSortKth(nums, start, i, k);
        } else
            return quickSortKth(nums, i + 1, end, k);

    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        Kth kth = new Kth();
//        System.out.println(kth.heapKth(nums, 3));
        System.out.println(kth.quickSortKth(nums, 0, nums.length - 1, 3));
    }

}
