package leetcode.dfsbfs;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        List<String> strings = gp.generateParenthesis(3);
        System.out.println(strings);

    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        List<String> canSelectList = new ArrayList<>();
        canSelectList.add("(");
        canSelectList.add(")");
        backtrack(n, n, "", res, canSelectList);
        return res;
    }

    public void backtrack(int leftCur, int rightCur,String now, List<String> res, List<String> canSelectList) {
        if (rightCur < leftCur) {
            return;
        }
        if (rightCur < 0 || leftCur < 0) {
            return;
        }
        if (rightCur == 0 && leftCur == 0) {
            res.add(now);
            return;
        }
        for (int i = 1; i <= canSelectList.size(); i++) {
            now = now + canSelectList.get(i - 1);
            backtrack(leftCur + (i == 1 ? -1 : 0), rightCur + (i == 2 ? -1 : 0), now, res, canSelectList);
            now = now.substring(0, now.length() - 1);
        }

    }

}
