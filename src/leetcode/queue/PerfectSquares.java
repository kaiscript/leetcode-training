package leetcode.queue;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *  Perfect Squares
 *  Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
public class PerfectSquares {

    public static void main(String[] args) {
        PerfectSquares ps = new PerfectSquares();
        System.out.println(ps.numSquares(12));
    }

    /**
     * bfs.
     * depth为深度.
     * 在每个depth里面，每个节点的值都是n减去平方数的差，故判断差值是否等于0,0则代表已经找到了答案
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int depth = 0;
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        queue.add(n);
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int j = 1; j <= Math.sqrt(cur); j++) {
                    int next = cur - j * j;
                    if (next == 0) {
                        return depth;
                    }
                    queue.add(next);
                }
            }

        }
        return -1;
    }

}
