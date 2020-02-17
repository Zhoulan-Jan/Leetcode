import java.util.Stack;

public class $150 {
    public static int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            return 0;
        }
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        Stack<String> stack = new Stack<>();
        int cnt = 0;
        while (cnt < tokens.length) {
            //为操作数，入栈
            while (!isOperator(tokens[cnt])) {
                stack.push(tokens[cnt]);
                cnt++;
            }
            //遇到操作符，取出两个栈顶元素计算
            String operator = tokens[cnt];
            int a = Integer.parseInt(stack.pop()); //String -> int
            int b = Integer.parseInt(stack.pop());
            int res = cal(b, a, operator); //注意操作数顺序
            //将结果放到栈中
            stack.push(String.valueOf(res));
            cnt++;
        }
        return Integer.parseInt(stack.pop());
    }

    //计算
    public static int cal(int a, int b, String op) {
        if (op.equals("+")) {
            return a + b;
        } else if (op.equals("-")) {
            return a - b;
        } else if (op.equals("*")) {
            return a * b;
        } else if (op.equals("/")) {
            return a / b;
        }
        return -1;
    }

    //判断是否为操作符
    public static boolean isOperator(String s) {
        if (s.equals("+") || s.equals("-") ||
        s.equals("*") || s.equals("/")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] str1 = {"2", "1", "+", "9", "*"};
        String[] str2 = {"4", "13", "5", "/", "+"};
        String[] str3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        String[] str4 = {"18"};
        String[] str5 = {};
        System.out.println(evalRPN(str1) + " 27");
        System.out.println(evalRPN(str2) + " 6");
        System.out.println(evalRPN(str3) + " 22");
        System.out.println(evalRPN(str4) + " 18");
        System.out.println(evalRPN(str5) + " 0");
    }
}
