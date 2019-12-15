package leetcode.stringAndArray.twoPoint;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem
 * Given an Array of non negative Integers and a number. You need to print all the starting and ending indices of Subarrays having their sum equal to the given integer.
 * For Example :-
 *
 * Input-int[] arr = {2, 3, 6, 4, 9, 0, 11};
 * int num = 9
 * Output-
 * starting index : 1, Ending index : 2
 * starting index : 5, Ending index : 5
 * starting index : 5, Ending index : 6
 *
 * Explanation :
 * [3, 6]
 * [9],
 * [9,0]
 * These all are the subarrays with their sum equal to 9.
 */
public class FindSubArraysWithGivenSum {

    /**
     * 双指针法-滑动窗口
     * @param arr
     * @param target
     */
    public void solve(int[] arr, int target) {
        int sum = 0;
        int start = 0;//start也是一个指针
        //外层循环，向右移动的指针
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum < target) {
                continue;
            }
            while (sum > target) {
                sum -= arr[start++];
            }
            if (sum == target) {
                System.out.println(arr[start] + "-" + arr[i]);
                continue;
            }
        }
    }

    /**
     * 维护start、end两个指针，滑动这个窗口进行计算
     * @param arr
     * @param target
     * @return
     */
    public List<List<Integer>> solveEfficient(int[] arr, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        int start = 0;
        int end = 0;
        int sum = 0;
        while (start < arr.length && end < arr.length) {
            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                for (int i = start; i < end; i++) {
                    list.add(arr[i]);
                }
                ret.add(list);
                sum += arr[end++];
            } else {
                if (sum < target) {
                    sum += arr[end++];
                } else if (sum > target) {
                    sum -= arr[start++];
                }
            }

        }
        return ret;
    }

    public static void main(String[] args) {
        FindSubArraysWithGivenSum fg = new FindSubArraysWithGivenSum();
        int[] arr = {2, 3, 6, 4, 9, 0, 11};
        System.out.println(fg.solveEfficient(arr, 9));
        fg.solve(arr, 9);
    }

}
