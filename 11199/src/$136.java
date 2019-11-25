import java.util.HashMap;
import java.util.Map;

public class $136 {
    //只出现一次的数字
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

    public static void main(String[] args) {
        int[] arr = {2,2,1};
        System.out.println(singleNumber(arr));
    }
}
