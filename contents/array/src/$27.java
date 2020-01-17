/**
 * 双指针法
 *   当和给定值相等时，就跳过该值
 *   否则，两个索引均递增并保存
 */

import java.util.Arrays;

public class $27 {
    public static int removeElement(int[] nums, int val) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[cnt] = nums[i];
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,2,3};
        System.out.println(removeElement(arr, 3));
        System.out.println(Arrays.toString(arr));
    }
}
