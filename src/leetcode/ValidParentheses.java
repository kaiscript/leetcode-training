package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20.Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 * Created by kaiscript on 2019/4/28.
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Map<Character, Character> left = new HashMap<>();
        left.put('(', ')');
        left.put('{', '}');
        left.put('[', ']');
        Map<Character, Character> right = new HashMap<>();
        right.put(')', '(');
        right.put('}', '{');
        right.put(']', '[');
        Stack<Character> stack = new Stack<>();
        boolean ret = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (left.get(c) != null) {
                stack.push(c);
                continue;
            }
            if (right.get(c) != null) {
                Character pop = stack.empty()? '#' : stack.pop();
                if (pop != right.get(c)) {
                    return false;
                }
                else
                    ret = true;
            }
        }
        return ret && stack.size() == 0;
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid("]"));
    }

}
