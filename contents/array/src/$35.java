public class $35 {
    public static int searchInsert(int[] nums, int target) {
        int i = 0;
        for (; i < nums.length; i++) {
            if (target <= nums[i]) {
                break;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        System.out.println(searchInsert(arr, 2));
    }
}
