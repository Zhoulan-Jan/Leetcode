/**
 * 1.去除字符串的空格
 * 2.判断第一个非空字符是否为 +、-、数字，否则返回0，注意全是空格的情况
 * 3.数字累计，注意数据是否越界，注意中间是否有非数字字符
 */
public class $8 {
    public static int myAtoi(String str) {
        if (str.equals("")) {
            return 0;
        }
        int res = 0;
        int i = 0;
        int sign = 1; //判断正负数 -1表示负数
        while (str.charAt(i) == ' ') {
            i++;
            if (i == str.length() ) { //全是空格
                return 0;
            }
        }

        if (str.charAt(i) == '-') { //正数
            sign = -1;
            i++;
        } else if (str.charAt(i) == '+') { //负数
            i++;
        }
        for (; i < str.length(); i++) {
            //不为数字
            if (str.charAt(i) > '9' || str.charAt(i) < '0') {
                break;
            }
            //环境只能存储 32 位大小的有符号整数，因此，需要提前判断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (str.charAt(i) - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (str.charAt(i) - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + sign * (str.charAt(i) - '0');
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("") + " 0");
        System.out.println(myAtoi(" ") + " 0"); //全是空格
        System.out.println(myAtoi(" +42") + " 42"); //正数
        System.out.println(myAtoi("   -42") + " -42"); //负数
        System.out.println(myAtoi("-91283472332") + " -2147483648"); //超出32位有符号整数范围
        System.out.println(myAtoi("  91283472332") + " 2147483647"); //超出32位有符号整数范围
        System.out.println(myAtoi("  912 hello 332") + " 912"); //含有英文字母
        System.out.println(myAtoi(" hello 12323") + " 0"); //非数字及正负号字符开头
    }
}
