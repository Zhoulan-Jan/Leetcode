import java.util.HashMap;
import java.util.Map;

/**
 * 只出现一次的数字
 * 法一：遍历数字，并保存到map中，key对应nums[i]，value对应个数
 * 法二：全部数字异或，最终结果就是只出现一次的数字
 */
public class $136 {
    //法一：map
    public static int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int x : nums) {
            int count = map.getOrDefault(x,0);
            map.put(x, count+1); //为什么count++错了
        }
        //遍历map，找到count为 1 的key
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    //法二：异或
    public int singleNumber2(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
