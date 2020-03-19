/**
 * 法一：1.预先计算前缀和P [i] = nums [0] + nums [1] + ... + nums [i-1]
 *      2.然后，对于每个索引，左和为P [i]，右和为P [P.length-1]-P [i]-nums [i]
 * 法二：计算每个索引的左值和右值，判断是否相等
 */

public class $724 {
    //预先计算前缀和P [i] = nums [0] + nums [1] + ... + nums [i-1]
    // 然后，对于每个索引，左和为P [i]，右和为P [P.length-1]-P [i]-nums [i]
    public static int pivotIndex(int[] nums) {
        int[] P = new int[nums.length + 1];
        P[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            P[i+1] = P[i] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (P[i] == P[P.length - 1]-P[i]-nums[i]) {
                return i;
            }
        }
        return -1;
    }

    //计算每个索引的左值和右值，判断是否相等
    public static int pivotIndex2(int[] nums) {
        for (int k = 0; k < nums.length; k++) {
            int left = 0;
            for (int i = 0; i < k; i++) {
                left += nums[i];
            }
            int right = 0;
            for (int j = k + 1; j < nums.length; j++) {
                right += nums[j];
            }
            if (left == right) {
                return k;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] num = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(num));
    }
}
