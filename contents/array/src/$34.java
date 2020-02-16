import java.util.Arrays;

public class $34 {
    //二分查找
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        if (nums.length == 0) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }


        if (left > right) { //找不到
            res[0] = -1;
            res[1] = -1;
            return res;
        } else { //找得到
            //往左找 往右找
            int i = mid;
            int j = mid;
            while (i >= 0 && nums[i] == target) {
                --i;
            }
            while (j < nums.length && nums[j] == target) {
                ++j;
            }
            res[0] = i + 1;
            res[1] = j - 1;
            return res;
        }
    }

    //线性查找
    //i 从前往后找到第一个等于target的下标； j 从后往前找
    // 注意两指针不能越界
    public static int[] searchRange2(int[] nums, int target) {
        int[] res = new int[2];
        if (nums.length == 0) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i < nums.length && nums[i] < target) {
            i++;
        }
        while (j >= 0 && nums[j] > target) {
            j--;
        }
        if (i <= j) {
            res[0] = i;
            res[1] = j;
            return res;
        }
        res[0] = -1;
        res[1] = -1;
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int[] arr2 = {};
        int[] arr3 = {1};
        System.out.println(Arrays.toString(searchRange(arr, 8)) + " [3,4]");
        System.out.println(Arrays.toString(searchRange(arr, 6)) + " [-1,-1]");
        System.out.println(Arrays.toString(searchRange(arr2, 0)) + " [-1,-1]");
        System.out.println(Arrays.toString(searchRange(arr3, 0)) + " [-1,-1]");
    }
}
