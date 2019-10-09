public class Test {
    public static void main(String[] args) {
        testaddFirst();
        testhasCycle();
    }

    public static void testaddFirst(){
        System.out.println("测试addFirst方法：");
        Solution list = new Solution();
        ListNode head = null;
        head = list.addFirst(head,1);
        head = list.addFirst(head,2);
        head = list.addFirst(head,3);
        head = list.addFirst(head,4);
        head = list.addFirst(head,5);
        System.out.println("预期输入[5,4,3,2,1],实际是：");
        list.display(head);
    }

    public static void testhasCycle() {
        System.out.println("测试hasCycle方法：");
        Solution list = new Solution();
        ListNode head = null;
        head = list.addFirst(head,1);
        head = list.addFirst(head,2);
        head = list.addFirst(head,3);
        head = list.addFirst(head,4);
        head = list.addFirst(head,5);
        boolean result = list.hasCycle(head);
        System.out.println("预期输入false,实际是：" + result);
    }
}
