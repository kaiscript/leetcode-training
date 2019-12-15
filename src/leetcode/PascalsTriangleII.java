package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 119.
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 3
 * Output: [1,3,3,1]
 * Follow up:
 *
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        //结果有rowIndex个
        List<Integer> ret = new ArrayList<>();
        for (int i = 1; i <= rowIndex; i++) {
            ret.add(1);
            //从后往前，将上一层的j和j-1这2个位置的2个数相加，得到当前在j位置的值
            for (int j = i - 1; j > 0; j--) {
                ret.set(j, ret.get(j) + ret.get(j - 1));
            }
        }
        ret.add(1);
        return ret;
    }

    public List<Integer> getRow0(int rowIndex) {
        Integer[] ret = new Integer[rowIndex + 1];
        Arrays.fill(ret, 0);
        ret[0] = 1;
        //第一层只有一个，并且已赋值为1，所以循环从1开始,纵向循环
        for (int i = 1; i <= rowIndex; i++) {
            //横向循环
            for (int j = i; j > 0; j--) {
                ret[j] = ret[j] + ret[j - 1];
            }
        }
        return Arrays.asList(ret);
    }

    public static void main(String[] args) {
        PascalsTriangleII pt = new PascalsTriangleII();
//        System.out.println(pt.getRow(4));
        System.out.println(pt.getRow0(4));

    }

}
