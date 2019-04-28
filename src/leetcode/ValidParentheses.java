package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20
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
