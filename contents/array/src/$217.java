import java.util.Arrays;

public class $217 {
    //数组排序，判断相邻的数字是否相同
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) return false;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }

    //哈希

}
