package leetcode.dance.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class RestoreIpAddresses {

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return new ArrayList<>();
        }
        List<String> ret = new ArrayList<>();
        dfs(0, 0, s, new ArrayList<>(), ret);
        return new ArrayList<>(ret);
    }

    /**
     * 不剪枝会超时
     * @param index
     * @param splitTime
     * @param s
     * @param list
     * @param res
     */
    public void dfs(int index, int splitTime, String s, List<String> list, List<String> res) {
        if (list.size() == 4 && index == s.length()) {
            res.add(String.join(".", list));
            return;
        }

        //剪枝.剩下的字符不够分配了，或者剩下的字符大于 3*可以分配的次数，不符合ip地址条件
        if (s.length() - index < (4 - splitTime) || s.length() - index > 3 * (4 - splitTime)) {
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (index + i > s.length()) {
                continue;
            }
            String pip = s.substring(index, index + i);
            int check = check(s, index, index + i, pip);
            if (check == -1) {
                break;
            }
            list.add(pip);
            dfs(index + i, splitTime + 1, s, list, res);
            list.remove(list.size() - 1);
        }

    }

    public int check(String s, int start, int end, String pip) {
        int length = end - start;
        //第一位不可以为 0
        if (length > 1 && s.charAt(start) == '0') {
            return -1;
        }
        Integer num = Integer.valueOf(pip);
        if (num > 255) {
            return -1;
        }

        return num;
    }

    public static void main(String[] args) {
        RestoreIpAddresses ria = new RestoreIpAddresses();
        System.out.println(ria.restoreIpAddresses("25525511135"));
    }

}
