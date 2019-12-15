package leetcode.dfsbfs;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 *
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class SurroundedRegions {

    /**
     * 对边界每个元素进行dfs，查找可用节点，标记为好的'G'.然后再遍历grid，将'G'还原成'O',原来的'O'标记为X
     * @param board
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int r = board.length;
        int c = board[0].length;
        //对第一列和最后一列进行dfs
        for (int i = 0; i < r; i++) {
            dfs(board, i, 0);
            dfs(board, i, c - 1);
        }
        //对第一行和最后一行每个元素进行dfs
        for (int i = 0; i < c; i++) {
            dfs(board, 0, i);
            dfs(board, r - 1, i);
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('G', 'O');
        map.put('X', 'X');
        map.put('O', 'X');
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = map.get(board[i][j]);
            }
        }
    }

    public void dfs(char[][] board, int x, int y) {
        int r = board.length;
        int c = board[0].length;
        if (x < 0 || y < 0 || x >= r || y >= c || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'G';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x , y-1);
    }

    public static void main(String[] args) {
        SurroundedRegions sr = new SurroundedRegions();
        char[][] c = new char[][]{{'X', 'O', 'X', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X', 'O', 'X'}, {'X', 'O', 'X', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X', 'O', 'X'}};
        sr.solve(c);
    }

}
