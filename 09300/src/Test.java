public class Test {
    public static void main(String[] args) {
        testaddLast();
        testFindKthToTail();
    }

    public static void testaddLast() {
        System.out.println("测试addLast方法：");
        ListNode head = null;
        Solution list = new Solution();
        head = list.addLast(head,1);
        head = list.addLast(head,2);
        head = list.addLast(head,3);
        head = list.addLast(head,4);
        head = list.addLast(head,5);
        System.out.print("预期结果是[1,2,3,4,5], 实际是：");
        list.display(head);
    }

    public static void testFindKthToTail() {
        System.out.println("测试FindKthToTail方法：");
        ListNode head = null;
        Solution list = new Solution();
        head = list.addLast(head,1);
        head = list.addLast(head,2);
        head = list.addLast(head,3);
        head = list.addLast(head,4);
        head = list.addLast(head,5);
        head = list.addLast(head,6);

        //head = list.FindKthToTailFS(head,3);
        head = list.FindKthToTail(head,3);
        System.out.print("预期结果是4, 实际是：" + head.val);
    }
}
