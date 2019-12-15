package leetcode.binary;

/**
 * 374.Guess Number Higher or Lower
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 *
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 *
 * -1 : My number is lower
 *  1 : My number is higher
 *  0 : Congrats! You got it!
 * Example :
 *
 * Input: n = 10, pick = 6
 * Output: 6
 */
public class GuessNumberHigherOrLower {

    public int guessNumber(int n) {
        if (n == 0) {
            return 0;
        }
        int start = 1;
        int end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int guess = guess(mid);
            if (guess == 0){
                return mid;
            }
            if (guess == 1) {
                end = mid - 1;
            }
            if (guess == -1) {
                start = mid + 1;
            }
        }
        return start;
    }

    public int guess(int num){
        int target = 6;
        if (num > target) {
            return 1;
        }
        if (num < target) {
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        GuessNumberHigherOrLower gn = new GuessNumberHigherOrLower();
        System.out.println(gn.guessNumber(10));
    }

}
