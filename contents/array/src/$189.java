/**
 * 当旋转步数大于数组长度时，和之前旋转方式相同。
 * 1.申请额外空间:
 *     先将后 k 个元素保存在数组 n
 *     前 len - k 个元素向后移动 k 个位置  (注意从后往前移动)
 *     原数组前面的位置放置数组 n 的元素
 * 2.使用翻转
 *     整个数组翻转
 *     翻转前 k 个元素
 *     翻转后 len - k 个元素
 */

import java.util.Arrays;

public class $189 {
    public static void rotate(int[] nums, int k) {
        //当旋转步数大于数组长度时，和之前旋转方式相同
        if (k > nums.length) {
            k = k % nums.length;
        }
        if (k == 0) {
            return;
        }
        int[] n = new int[k];
        //先将后 k 个元素保存在数组 n
        int len = k;
        for (int i = nums.length - 1; i >= nums.length - k; i--) {
            n[--len] = nums[i];
        }
        //前len - k 个元素向后移动 k 个位置  注意从后往前移动
        for (int i = nums.length - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
        //原数组前面的位置放置数组 n 的元素
        for (int i = 0; i < k; i++) {
            nums[i] = n[i];
        }
    }

    public static void rotate2 (int[] nums, int k) {
        if (k > nums.length) {
            k = k % nums.length;
        }
        if (k == 0) {
            return;
        }
        //翻转整个数组
        reverse(nums, 0, nums.length - 1);
        //翻转前 k 个元素
        reverse(nums, 0,k - 1);
        //翻转后 len - k 个元素
        reverse(nums, k, nums.length - 1);
    }

    //反转函数
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate2(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
