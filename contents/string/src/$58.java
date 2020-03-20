/**
 * 注意测试用例出现全为空格的情况
 */
public class $58 {
    public static int lengthOfLastWord(String s) {
        String[] str = s.split(" ");
        //字符串全为空格，不存在最后一个空格
        if (str.length == 0) {
            return 0;
        }
        return str[str.length - 1].length();
    }

    public static void main(String[] args) {
        System.out.println( lengthOfLastWord("      "));
    }
}
