public class $9 {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        //数字逆序相乘是否与原数相等
        int tmp = x;
        int res = 0;
        while (tmp != 0) {
            res = res * 10 + tmp % 10;
            tmp /= 10;
        }
        if (res == x) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(1211));
        System.out.println(isPalindrome(-121));
    }
}
