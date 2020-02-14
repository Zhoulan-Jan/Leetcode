import java.util.Arrays;

public class $977 {
    //在原数组基础上，负数加绝对值排序
    //双指针
    //全是正数、全是负数、正负数结合
    public static int[] sortedSquares(int[] A) {
        //i 指向负数部分逆序保存
        //j 指向正数部分正序保存
        int i = 0;
        int j = 0;
        while (j < A.length && A[j] < 0 ) {
            j++;
        }
        i = j - 1;
        int[] B = new int[A.length];
        int cnt = 0;
        while (cnt < A.length && i >= 0 && j < A.length) {
            if (A[i] * A[i] < A[j] * A[j]) {
                B[cnt] = A[i] * A[i];
                cnt++;
                i--;
            } else {
                B[cnt] = A[j] * A[j];
                cnt++;
                j++;
            }
        }
        //正数未取完
        while (j < A.length) {
            B[cnt] = A[j] * A[j];
            cnt++;
            j++;
        }
        //负数未取完
        while (i >= 0) {
            B[cnt] = A[i] * A[i];
            cnt++;
            i--;
        }
        return B;
    }

    //申请额外的空间 + Arrays.sort
    public static int[] sortedSquares2(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = A[i] * A[i];
        }
        Arrays.sort(B);
        return B;
    }

    public static void main(String[] args) {
        int[] A = {-4, -1, 0, 3, 10};
        int[] A2 = {-1};
        int[] A3 = {-2,-1};
        int[] A4 = {4,5,6};
        System.out.println(Arrays.toString(sortedSquares(A)));
        System.out.println(Arrays.toString(sortedSquares(A2)));
        System.out.println(Arrays.toString(sortedSquares(A3)));
        System.out.println(Arrays.toString(sortedSquares(A4)));

    }
}
