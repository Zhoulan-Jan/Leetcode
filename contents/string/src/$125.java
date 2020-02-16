public class $125 {
    //双指针
    public static boolean isPalindrome(String s) {
        //只保留字母和数字字符
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z')
                    ||(ch >= 'A' && ch <= 'Z')) {
                str.append(ch);
            }
        }
        String newStr = str.toString().toLowerCase();
        //i 从前往后指， j 从后往前指
        int i = 0;
        int j = newStr.length() - 1;
        while (i <= j) {
            if (newStr.charAt(i) != newStr.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {
        //只保留字母和数字字符
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z')
            ||(ch >= 'A' && ch <= 'Z')) {
                str.append(ch);
            }
        }
        String oldStr = str.toString().toLowerCase();
        //旋转字符串
        String newStr = str.toString().toLowerCase();
        String revStr = reverse(newStr);
        System.out.println("rev " + revStr);
        //与原字符串是否相等
        if (revStr.equals(oldStr)) {
            return true;
        }
        return false;
    }

    public static String reverse(String str) {
        int i = 0;
        int j = str.length() - 1;
        char[] s = str.toCharArray();
        while (i < j) {
            swap(i, j, s);
            i++;
            j--;
        }
        return String.valueOf(s);
    }

    public static void swap(int i, int j, char[] s) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    public static void main(String[] args) {
        //System.out.println(reverse("hello world"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }
}
