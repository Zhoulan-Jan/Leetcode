import java.util.Arrays;

/**
 * 同采用一次快排的思想
 */
public class $905 {
    public static int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            while (i < j && isEven(A[i])) {
                i++;
            }
            while (i < j && !isEven(A[j])) {
                j--;
            }
            swap(i, j, A);
            i++;
            j--;
        }
        return A;
    }

    //判断是否为偶数
    public static boolean isEven(int n) {
        if (n % 2 == 0) {
            return true;
        }
        return false;
    }

    public static void swap(int i, int j, int[] A) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args) {
        int[] A = {3,2,1,4};
        System.out.println(Arrays.toString(sortArrayByParity(A)));
    }
}
