package com.monkey.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 *
 * @author tao
 * @date 2021/1/30 10:27 上午
 */
public class T20ValidParentheses {

    public boolean isValid(String s) {
        int n = s.length();

        // 奇数直接返回false
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<>() {
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char sh = s.charAt(i);
            if (pairs.containsKey(sh)) {
                if (stack.isEmpty() || !stack.peek().equals(pairs.get(sh))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(sh);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        T20ValidParentheses t20ValidParentheses = new T20ValidParentheses();

        String s1 = "()";
        System.out.println(t20ValidParentheses.isValid(s1));

        String s2 = "()[]{}";
        System.out.println(t20ValidParentheses.isValid(s2));

        String s3 = "(]";
        System.out.println(t20ValidParentheses.isValid(s3));

        String s4 = "([)]";
        System.out.println(t20ValidParentheses.isValid(s4));

        String s5 = "{[]}";
        System.out.println(t20ValidParentheses.isValid(s5));
    }

}
