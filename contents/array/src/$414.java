public class $414 {
    public static int thirdMax(int[] nums) {
        long first = nums[0]; //最大值
        long second = Long.MIN_VALUE; //第二大值
        long third = Long.MIN_VALUE; //第三大值

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (cur == first || cur == second || cur == third) {
                continue;
            }
            if (cur > first) { //注意赋值的顺序
                third = second;
                second = first;
                first = cur;
            } else if (cur > second) {
                third = second;
                second = cur;
            } else if (cur > third) {
                third = cur;
            }
        }
        //不存在第三大元素，返回最大元素
        if (third == Long.MIN_VALUE) {
            return (int)first;
        }
        return (int)third;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        int[] arr1 = {1,2};
        int[] arr2 = {2,2,3,1};
        System.out.println(thirdMax(arr) + " 1");
        System.out.println(thirdMax(arr1) + " 2");
        System.out.println(thirdMax(arr2) + " 1");
    }
}
