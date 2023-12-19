/**
 * 1.遍历字符串
 * 2.遇到左括号则入栈
 * 3.遇到右括号，若栈空，返回 false，否则取出栈顶元素，若不匹配则返回 false
 * 4.当字符串遍历完且栈为空，返回 true
 */

import java.util.Stack;

public class $20 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            //遇到左括号入栈
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else { //遇到右括号则取出栈顶元素观察是否匹配
                if (stack.isEmpty()) {
                    return false;
                }
                char x = stack.pop();
                //System.out.println("c = " + c + " x = " + x);
                if (!isMatch(x, c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    //检查两个符号是否匹配
    public static boolean isMatch(char a, char b) {
        if (a == '(' && b == ')') {
            return true;
        }
        if (a == '[' && b == ']') {
            return true;
        }
        return a == '{' && b == '}';
    }

    public static void main(String[] args) {
        System.out.println(isValid("()") + " true");
        System.out.println(isValid("()[]{}") + " true");
        System.out.println(isValid("(]") + " false");
        System.out.println(isValid("([)]") + " false");
        System.out.println(isValid("{[]}") + " true");
    }
}
