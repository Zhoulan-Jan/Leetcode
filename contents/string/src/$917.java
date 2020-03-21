/**
 * 采用快排的思想
 * i 从前往后指向字母，j 从后往前指向字母
 * 将所指的字母交换
 * 注意点：字符串转向字符数组：char[] A = S.toCharArray();
 *         字符数组转向字符串：String S = String.valueOf(A);
 */

public class $917 {
    public static String reverseOnlyLetters(String S) {
        int i = 0;
        int j = S.length() - 1;
        char[] A = S.toCharArray();
        while (i < j) {
            //i 从前往后指向字母
            //j 从后往前指向字母
            while (i < j && !isLetter(A[i])) {
                i++;
            }
            while (i < j && !isLetter(A[j])) {
                j--;
            }
            swap(i, j , A);
            i++;
            j--;
        }
        //将字符数组转为字符串
        S = String.valueOf(A);
        return S;
    }

    //判断是否为字母
    public static boolean isLetter(char ch) {
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            return true;
        }
        return false;
    }

    //交换两个字母
    public static void swap(int i, int j, char[] A) {
        char tmp = A[i];
        A[i] = A[j];  //A.charAt(i) = A.charAt(j)错误
        A[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("ab-cd") + " dc-ba");
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj") + " j-Ih-gfE-dCba");
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!") + " Qedo1ct-eeLg=ntse-T!");
    }
}
