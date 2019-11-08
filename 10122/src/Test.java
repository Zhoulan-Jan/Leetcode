public class Test {
    public static void main(String[] args) {
        testswapPairs();
    }

    public static void testswapPairs() {
        System.out.println("测试swapParirs方法：");
        Solution list = new Solution();
        ListNode head = null;
        head = list.addFirst(head,6);
        head = list.addFirst(head,5);
        head = list.addFirst(head,4);
        head = list.addFirst(head,3);
        head = list.addFirst(head,2);
        head = list.addFirst(head,1);
        list.swapPairs2(head);
        System.out.print("预期结果是[2,1,4,3,6,5],实际是：");
        list.display(head);
    }
}
