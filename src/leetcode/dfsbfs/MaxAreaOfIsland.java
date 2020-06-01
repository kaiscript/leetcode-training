package leetcode.dfsbfs;

import java.util.Stack;

/**
 * 695. 岛屿的最大面积
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 *
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 *
 *
 *
 * 示例 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
 *
 * 示例 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 *
 *
 *
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 */
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        int max = 0;
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count = 0;
                    Stack<Integer> stack = new Stack<>();
                    stack.add(c * i + j);
                    while (!stack.isEmpty()) {
                        Integer num = stack.pop();
                        count++;
                        int x = num / c;
                        int y = num % c;
                        grid[x][y] = 0;
                        //down
                        if (x + 1 < r && grid[x + 1][y] == 1) {
                            stack.add((x + 1) * c + y);
                            grid[x + 1][y] = 0;
                        }
                        //up
                        if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                            stack.add((x - 1) * c + y);
                            grid[x - 1][y] = 0;
                        }
                        //right
                        if (y + 1 < c && grid[x][y + 1] == 1) {
                            stack.add(x * c + y + 1);
                            grid[x][y + 1] = 0;
                        }
                        //left
                        if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                            stack.add(x * c + y - 1);
                            grid[x][y - 1] = 0;
                        }
                    }

                }
                if (count > max) {
                    max = count;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        System.out.println(maxAreaOfIsland.maxAreaOfIsland(nums));

    }

}
