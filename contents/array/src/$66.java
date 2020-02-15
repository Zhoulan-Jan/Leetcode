import java.util.Arrays;

/**
 * 从后往前模拟进位，循环判断直到没有进位则返回结果
 * 考虑99、999等，需扩展一位
 */
public class $66 {
    public static int[] plusOne(int[] digits) {
        // 123 89
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            //模拟进位
            digits[i] %= 10;
            //没有进位，则返回结果
            if (digits[i] != 0) return digits;
        }
        //需要扩展一位 如数字99
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    //将数组转为数字，+1后再转为数组：易造成数据越界
    public static int[] plusOne2(int[] digits) {
        int sum = 0;
        //将数组转为数字 数据越界
        for (int i = 0; i < digits.length; i++) {
            sum = sum * 10 + digits[i];
        }
        int num = sum + 1;
        //将 num 转为数组
        //确定新数组的长度
        int len = 0;
        int x = num;
        while (x != 0) {
            len++;
            x /= 10;
        }
        int[] nums = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            nums[i] = num % 10;
            num /= 10;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2};
        int[] arr2 = {9,9};
        int[] arr3 = {8,9};
        int[] arr4 = {9,8,7,6,5,4,3,2,1,0};
        System.out.println(Arrays.toString(plusOne(arr)));
        System.out.println(Arrays.toString(plusOne(arr2)));
        System.out.println(Arrays.toString(plusOne(arr3)));
        System.out.println(Arrays.toString(plusOne(arr4)));
    }
}
