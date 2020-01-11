package leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 887. Super Egg Drop
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 *
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 *
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 *
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 *
 * 你的目标是确切地知道 F 的值是多少。
 *
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：K = 1, N = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
 * 如果它没碎，那么我们肯定知道 F = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
 * 示例 2：
 *
 * 输入：K = 2, N = 6
 * 输出：3
 * 示例 3：
 *
 * 输入：K = 3, N = 14
 * 输出：4
 *  
 *
 * 提示：
 *
 * 1 <= K <= 100
 * 1 <= N <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-egg-drop
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SuperEggDrop {

    Map<Integer, Integer> memo = new HashMap();

    /**
     * K个鸡蛋，N层楼:
     * 在i层楼投，则有2个状态，蛋碎或不蛋碎。然后会进入2个阶段其中之一。
     * dp(K-1,i-1) : 蛋碎了
     * dp(K,N-i)   : 蛋没碎
     * 那么状态转移方程则是：
     * dp(K,N) = 1 + max(dp(K-1,i-1) + dp(K,N-i))
     * @param k
     * @param n
     * @return
     */
    public int superEggDrop(int k, int n) {
        return dp(k, n);
    }

    public int dp(int k, int n) {
        if (k == 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        }
        if (memo.get(n * 100 + k) != null) {
            return memo.get(n * 100 + k);
        }
        int res = Integer.MAX_VALUE;
        int start = 1;
        int end = n;

        //保证start + 1 < end 的目的是：求出 mid，使得mid=n-1，mid也就是最优解，即当前是在第几层楼投鸡蛋的。
        // 状态方程则变成 1 + dp(k-1,mid-1) + dp(k,n-mid). 1 是在mid层楼投了一次
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int t1 = dp(k - 1, mid - 1);
            int t2 = dp(k, n - mid);
            if (t1 < t2) {
                start = mid;
            } else if (t1 > t2) {
                end = mid;
            } else
                start = end = mid;

        }
        res = 1 + Math.min(
                Math.max(dp(k - 1, start - 1), dp(k, n - start)),
                Math.max(dp(k - 1, end - 1), dp(k, n - end))
        );
        memo.put(n * 100 + k, res);
        return res;
    }

}
