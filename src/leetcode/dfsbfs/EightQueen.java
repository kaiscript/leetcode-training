package leetcode.dfsbfs;

import java.util.ArrayList;
import java.util.List;

public class EightQueen {

    static List<int[][]> result = new ArrayList<>();

    public static void main(String[] args) {
        int size = 16;
        int[][] board = new int[size][size];
        long start = System.currentTimeMillis();
        find(board, 0);
        System.out.println("cost: " + (System.currentTimeMillis() - start));
        System.out.println(result.size());
    }

    public static void find(int[][] board, int row){
        if (row == board[0].length) {
            result.add(board);
//            for (int[] ints : board) {
//                for (int anInt : ints) {
//                    System.out.print(anInt + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("===============");
            return;
        }
        for (int i = 0; i < board[row].length; i++) {
            if (!isValid(board, row, i)) {
                continue;
            }
            board[row][i] = 1;
            find(board, row + 1);
            board[row][i] = 0;
        }

    }

    public static boolean isValid(int[][] board, int row, int col) {
        // 判断列上有没有皇后
        for (int i = 0; i < row; i++) {
            if(board[i][col] == 1)
                return false;
        }
        // 判断左斜上方有没有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 1)
                return false;
        }
        // 判断右斜上方有没有皇后
        for (int i = row - 1, j = col + 1; i >=0 && j < board[i].length; i--, j++) {
            if(board[i][j] == 1)
                return false;
        }
        return true;
    }

}
