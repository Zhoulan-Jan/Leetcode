public class Test {
    public static void main(String[] args) {
        testaddLast();
    }

    public static void testaddLast() {
        System.out.println("测试尾插法：");
        Solution list = new Solution();
        ListNode head = null;
        head = list.addLast(head,1);
        head = list.addLast(head,2);
        head = list.addLast(head,3);
        head = list.addLast(head,4);
        head = list.addLast(head,5);
        list.removeNthFromEnd(head,2);
        System.out.println("预期结果是[1,2,3,5]，实际是：");
        list.display(head);
    }
}
