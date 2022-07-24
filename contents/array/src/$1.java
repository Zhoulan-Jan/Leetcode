import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
两数之和
法一：暴力求解
法二：哈希表
    遍历数组，若map中存在target-nums[i]的值即可返回，否则保存nums[i]和其下标
    单次遍历即可
-> 两数的乘积 考虑浮点数的情况
 */
public class $1 {
    //法一：暴力求解
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    //法二：哈希表
    public int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])) {
                res[0] = i;
                res[1] = map.get(target-nums[i]);
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }

    //两数的乘积
    public int[] twoMul(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            double tmp = target/nums[i]*1.0;
            if (map.containsKey(tmp)) {
                res[0] = i;
                res[1] = map.get(tmp);
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        $1 a = new $1();
        int[] nums = {4,3,5,6,9};
        System.out.println(Arrays.toString(a.twoMul(nums, -5)));

    }
}
