package leetcode.queue;

import java.util.Stack;

/**
 * 200.
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

    public static void main(String[] args) {
        NumberOfIslands oi = new NumberOfIslands();
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
        System.out.println(oi.numIslands(grid));
    }

    public int numIslandsDfs(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * dfs寻找，并将找到的陆地置零，直到没陆地为止
     * @param grid
     * @param x
     * @param y
     */
    private void dfs(char[][] grid, int x, int y) {
        if (x >= grid.length || x < 0 || y >= grid[x].length || y < 0 || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }

    /**
     * bfs
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        char[][] visited = new char[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                visited[i][j] = 0;
            }
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Stack<Mark> stack = new Stack<>();
                boolean add = false;
                //not visited
                if (visited[i][j] == 0) {
                    visited[i][j] = '1';
                    stack.add(new Mark(i, j));
                    while (!stack.empty()) {
                        Mark pop = stack.pop();
                        int x = pop.x;
                        int y = pop.y;
                        if (grid[x][y] == '1') {
                            if (!add) {
                                add = true;
                                count++;
                            }
                            //right
                            if (y + 1 < grid[i].length && visited[x][y + 1] == 0 && grid[x][y + 1] == '1') {
                                stack.add(new Mark(x, y + 1));
                                visited[x][y + 1] = '1';
                            }
                            //bottom
                            if (x + 1 < grid.length && visited[x + 1][y] == 0 && grid[x + 1][y] == '1') {
                                stack.add(new Mark(x + 1, y));
                                visited[x + 1][y] = '1';
                            }
                            //left
                            if (y - 1 >= 0 && visited[x][y - 1] == 0 && grid[x][y - 1] == '1') {
                                stack.add(new Mark(x, y - 1));
                                visited[x][y - 1] = '1';
                            }
                            //up
                            if (x - 1 >= 0 && visited[x - 1][y] == 0 && grid[x - 1][y] == '1') {
                                stack.add(new Mark(x - 1, y));
                                visited[x - 1][y] = '1';
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
        return count;
    }

    class Mark{
        int x;
        int y;
        public Mark(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
