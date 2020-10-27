package leetcode.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * 969. 煎饼排序
 * 给定数组 A，我们可以对其进行煎饼翻转：我们选择一些正整数 k <= A.length，然后反转 A 的前 k 个元素的顺序。我们要执行零次或多次煎饼翻转（按顺序一次接一次地进行）以完成对数组 A 的排序。
 *
 * 返回能使 A 排序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * A.length 范围内的有效答案都将被判断为正确。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[3,2,4,1]
 * 输出：[4,2,4,3]
 * 解释：
 * 我们执行 4 次煎饼翻转，k 值分别为 4，2，4，和 3。
 * 初始状态 A = [3, 2, 4, 1]
 * 第一次翻转后 (k=4): A = [1, 4, 2, 3]
 * 第二次翻转后 (k=2): A = [4, 1, 2, 3]
 * 第三次翻转后 (k=4): A = [3, 2, 1, 4]
 * 第四次翻转后 (k=3): A = [1, 2, 3, 4]，此时已完成排序。
 * 示例 2：
 *
 * 输入：[1,2,3]
 * 输出：[]
 * 解释：
 * 输入已经排序，因此不需要翻转任何内容。
 * 请注意，其他可能的答案，如[3，3]，也将被接受。
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 100
 * A[i] 是 [1, 2, ..., A.length] 的排列
 */
public class PancakeSort {

    List<Integer> list = new ArrayList<>();

    public List<Integer> pancakeSort(int[] arr) {
        sort(arr, arr.length - 1);
        return list;
    }

    public void sort(int[] arr, int n) {
        if (n == 1) {
            return;
        }
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        swag(arr, 0, maxIndex);
        list.add(maxIndex + 1);
        swag(arr, 0, n -1);
        list.add(n);
        sort(arr, n - 1);
    }

    public void swag(int[] arr, int start, int n) {
        while (start < n) {
            int temp = arr[start];
            arr[start] = arr[n];
            arr[n] = temp;
            start++;
            n--;
        }
    }

}
