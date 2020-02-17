import java.util.Arrays;

/**
 * 原地修改数组，用一个新的变量len来记录当前数组要存放的新东西，（注意不要再引用已修改的数组数据）
 * left指向原字符，right变量不断向右指，当两者不相等或者right一指到尽头了，则数组更新字符
 * 当两指针之间距离大于1，则更新数字 （数字转为字符数组：String.valueOf(right - left).toCharArray()）
 */
public class $443 {
    public static int compress(char[] chars) {
        int left = 0;
        int right = 0;
        int len = 0; //新数组长度
        while (right <= chars.length) {
            if (right == chars.length || chars[right] != chars[left]) {
                chars[len++] = chars[left]; //更新字符
                if (right - left > 1) { //更新数字
                    for (char c : String.valueOf(right - left).toCharArray()) {
                        chars[len++] = c;
                    }
                }
                left = right;
            }
            right++;
        }
        return len;
    }


    public static void main(String[] args) {
        char[] arr1 = {'a','a','b','b','c','c','c'};
        char[] arr2 = {'a','b','b','b','b','b','b','b','b'};
        System.out.println(compress(arr1) + Arrays.toString(arr1) + " 6 a 2 b 2 c 3");
        System.out.println(compress(arr2) + Arrays.toString(arr2) + " 3 a b 8");
    }
}
