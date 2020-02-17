import java.util.Arrays;

/**
 * 法一：排序法：与已排序好的数组对比，看有几个数字无法对应，找到最左和最右的数字即为边界
 * 法二：暴力法：当 i < j，出现nums[i] > nums[j] 时，说明不满足升序要求，记录 i，j
 *              找到最小的i，j即为边界
 */
public class $581 {
    //排序
    public static int findUnsortedSubarray(int[] nums) {
        int[] arr = Arrays.copyOf(nums,nums.length);
        Arrays.sort(arr);
        int start = nums.length - 1;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != arr[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return end - start <= 0 ? 0 : end - start + 1;
    }

    //暴力
    public static int findUnsortedSubarray3(int[] nums) {
        int l = nums.length;
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    l = Math.min(l,i);
                    r = Math.max(r,j);
                }
            }
        }
        return r - l < 0 ? 0 : r - l +1;
    }

    //错误 无法解决数字重复的问题
    public static int findUnsortedSubarray2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        //left 从前往后找到一个下标，其对应的数字大于后一个数字
        //right 从后往前找到一个下标，其对应的数字小于前一个数字
        for (; left < nums.length - 1; left++) {
            if (nums[left] > nums[left+1]) {
                break;
            }
        }
        if (left == right) {
            return 0;
        }
        for (; right >= 0; right--) {
            if (nums[right] < nums[right-1]) {
                break;
            }
        }
        System.out.println("left: " + left);
        System.out.println("right: " + right);
        return right - left + 1;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 6, 4, 8, 10, 9, 15};
        int[] arr2 = {1,2,3,4};
        int[] arr3 = {1,3,2,2,2}; //重复数字
        int[] arr4 = {1};
        System.out.println(findUnsortedSubarray(arr1) + " 5");
        System.out.println(findUnsortedSubarray(arr2) + " 0");
        System.out.println(findUnsortedSubarray(arr3) + " 4");
        System.out.println(findUnsortedSubarray(arr4) + " 0");
    }
}
