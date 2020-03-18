import java.util.Arrays;

public class $88 {
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int index = m + n - 1;
        m = m - 1;
        n = n - 1;
        while (m > 0 && n > 0) {
            if (nums1[m] >= nums2[n]) {
                nums1[index--] = nums1[m--];
            } else {
                nums1[index--] = nums2[n--];
            }
        }
        if (m >= n) {
            while (m > 0) {
                nums1[index--] = nums1[m--];
            }
        } else {
            while (n > 0) {
                nums1[index--] = nums2[n--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {1};
        merge(nums1,0,nums2,1);
        System.out.println(Arrays.toString(nums1));
    }
}
