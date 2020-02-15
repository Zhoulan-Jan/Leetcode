import java.util.ArrayList;
import java.util.Arrays;

/**
 * 类似大数计算
 *
 */
public class $67 {
    public static String addBinary(String a, String b){
        StringBuffer ans = new StringBuffer();
        //翻转a， b
        a = reverse(a);
        b = reverse(b);
        //相加
        int i = 0;
        int j = 0;
        int ci = 0; //进位标志 1 表示进位
        while (i < a.length() && j < b.length()) {
            int sum = a.charAt(i) - '0' + b.charAt(j) - '0' + ci;
            System.out.println("sum = " + sum);
            if (sum == 2) {
                ci = 1;
                ans.append(0);
            } else if (sum == 3) {
                ci = 1;
                ans.append(1);
            }
            else {
                ci  = 0;
                ans.append(sum);
            }
            i++;
            j++;
        }

        //当 a 未取完
        while (i < a.length()) {
            int sum = ci + a.charAt(i) - '0';
            if (sum == 2) {
                ans.append(0);
                ci = 1;
            } else if (sum == 1){
                ans.append(1);
                ci = 0;
            } else {
                ans.append(0);
                ci = 0;
            }
            i++;
        }
        //当 b 未取完
        while (j < b.length()) {
            int sum = ci + b.charAt(j) - '0';
            if (sum == 2) {
                ans.append(0);
                ci = 1;
            } else if(sum == 1){
                ans.append(1);
                ci = 0;
            } else {
                ans.append(0);
                ci = 0;
            }
            j++;
        }


        if (ci == 1) {
            ans.append(1);
        }
        //反转结果
        return reverse(ans.toString());
    }

    //翻转字符串
    public static String reverse(String str) {
        String res = "";
        int i = 0;
        int j = str.length() - 1;
        char[] s = str.toCharArray();
        while (i < j) {
            swap(i, j, s);
            i++;
            j--;
        }
        res = String.valueOf(s);
        return res;
    }

    public static void swap(int i, int j, char[] s) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11","1") + " 100");
        System.out.println(addBinary("1010", "1011") + " 10101");
        System.out.println(addBinary("100", "110010") + " 110110");

//        char[] arr1 = {1,0,4,7,2};
//        String b = "4566hello315";
//        char[] arr2 = b.toCharArray();
//        System.out.println(String.valueOf(arr1)); //字符数组转为字符串错误
//        System.out.println(Arrays.toString(arr2));
//        System.out.println(String.valueOf(arr2)); //只有之前用toCharArray()得到的字符数组才能够转为字符串
    }
}
