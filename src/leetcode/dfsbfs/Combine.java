package leetcode.dfsbfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Combine {

    public static void main(String[] args) {
        Combine combine = new Combine();
        List<List<Integer>> ret = combine.combine(4, 2);
        System.out.println(ret);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(new ArrayList<>(), 1, n, k, res);
        return res;
    }

    public void dfs(List<Integer> list, int start, int n, int k, List<List<Integer>> res) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            // 进行选择
            list.add(i);
            // 在剩余列表中进行选择
            dfs(list, i + 1, n, k, res);
            // 撤回选择
            list.remove(new Integer(i));
        }
    }

}
