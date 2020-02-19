import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class $78 {
    //回溯算法
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        bracktrack(0, nums, res, tmp);
        return res;
    }

    public static void bracktrack(int i, int[] nums, List<List<Integer>> res, List<Integer> tmp) {
         res.add(new ArrayList<>(tmp));
         for (int j = i; j < nums.length; j++) {
             tmp.add(nums[j]);
             bracktrack(j+1, nums, res, tmp);
             tmp.remove(tmp.size() - 1);
         }
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        List<List<Integer>> res1 = subsets(arr1);
        for (int i = 0; i < res1.size(); i++) {
            List<Integer> t = res1.get(i);
            System.out.print(Arrays.toString(t.toArray()));
        }
    }
}
