package leetcode.dfsbfs;

import java.util.Stack;

/**
 * 200. Number of Islands
 * Medium
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class NumberOfIslands {


    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {

            return 0;
        }
        int r = grid.length;
        int c = grid[0].length;
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int x, int y) {
        int r = grid.length;
        int c = grid[0].length;
        if (x < 0 || y < 0 || x >= r || y >= c || grid[x][y] == '0') {
            return;
        }

        grid[x][y] = '0';
        dfs(grid, x, y + 1);
        dfs(grid, x + 1, y);
        dfs(grid, x, y - 1);
        dfs(grid, x - 1, y);

    }

    public int numberOfIslandsBfs(char[][] grid) {

        if (grid == null || grid[0].length == 0) {
            return 0;
        }
        int r = grid.length;
        int c = grid[0].length;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    Stack<Integer> stack = new Stack<>();
                    stack.add(i * c + j);
                    grid[i][j] = '0';
                    count++;
                    while (!stack.empty()) {
                        Integer pop = stack.pop();
                        int x = pop / c;
                        int y = pop % c;
                        grid[x][y] = '0';
                        //right
                        if (y + 1 < c && grid[x][y + 1] == '1') {
                            stack.add(x * c + (y + 1));
                        }
                        //down
                        if (x + 1 < r && grid[x + 1][y] == '1') {
                            stack.add((x + 1) * c + y);
                        }
                        //left
                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            stack.add(x * c + y - 1);
                        }
                        //up
                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            stack.add((x - 1) * c + y);
                        }
                    }

                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfIslands noi = new NumberOfIslands();
        char[][] grid = new char[4][5];
        grid[0][0] = '1';
        grid[0][1] = '1';
        grid[0][2] = '1';
        grid[0][3] = '1';
        grid[0][4] = '0';

        grid[1][0] = '1';
        grid[1][1] = '1';
        grid[1][3] = '1';

        grid[2][0] = '1';
        grid[2][1] = '1';
//        System.out.println(noi.numIslands(grid));
        System.out.println(noi.numberOfIslandsBfs(grid));
    }

}
