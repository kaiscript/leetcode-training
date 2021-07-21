package leetcode.dfsbfs;

public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        backtrack(0, 0, board);

    }

    public boolean backtrack(int r, int c, char[][] board) {
        // 遍历到最后一列，就跳到下一行
        if (c == board.length)
            return backtrack(r + 1, 0, board);
        // 到最后一行的下一行了，说明有解了
        if (r == board.length) {
            return true;
        }
        for (int i = r; i < board.length; i++) {
            for (int j = c; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    return backtrack(i, j + 1, board);
                }
                for (char ch = '1'; ch <= '9'; ch++) {
                    // valid
                    if (!isValid(i, j, board, ch)) {
                        continue;
                    }
                    // 做选择
                    board[i][j] = ch;
                    // 回溯下一行，有解则立即返回
                    if (backtrack(i, j + 1, board)) {
                        return true;
                    }
                    // 撤销选择
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return false;
    }

    public boolean isValid(int r, int c, char[][] board, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == ch)
                return false;
            if (board[i][c] == ch)
                return false;
            if (board[(r / 3) * 3 + i / 3][(c / 3) * 3 + i % 3] == ch)
                return false;
        }
        return true;

    }

}
