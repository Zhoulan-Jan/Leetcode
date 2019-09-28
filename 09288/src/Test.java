public class Test {
    public static void main(String[] args) {
        testaddFirst();
        testreverseList();
        testmiddleNode();
        testmiddleNodeFS();
    }

    public static void testaddFirst() {
        System.out.println("测试addFirst方法：");
        ListNode head = null;
        Solution list = new Solution();
        head = list.addFirst(head,5);
        head = list.addFirst(head,4);
        head = list.addFirst(head,3);
        head = list.addFirst(head,2);
        head = list.addFirst(head,1);
        System.out.println("预期结果是[1,2,3,4,5], 实际是：");
        list.display(head);
    }

    public static void testreverseList() {
        System.out.println("测试reverseList方法：");
        ListNode head = null;
        Solution list = new Solution();
        head = list.addFirst(head,5);
        head = list.addFirst(head,4);
        head = list.addFirst(head,3);
        head = list.addFirst(head,2);
        head = list.addFirst(head,1);
        head = list.reverseList(head);
        System.out.println("预期结果是[5,4,3,2,1], 实际是：");
        list.display(head);
    }

    public static void testmiddleNode() {
        System.out.println("测试middleNode方法：");
        ListNode head = null;
        Solution list = new Solution();
        head = list.addFirst(head,6);
        head = list.addFirst(head,5);
        head = list.addFirst(head,4);
        head = list.addFirst(head,3);
        head = list.addFirst(head,2);
        head = list.addFirst(head,1);
        head = list.middleNode(head);
        System.out.println("预期结果是4, 实际是：" + head.val);
    }

    public static void testmiddleNodeFS() {
        System.out.println("测试middleNode快慢指针方法：");
        ListNode head = null;
        Solution list = new Solution();
        head = list.addFirst(head,6);
        head = list.addFirst(head,5);
        head = list.addFirst(head,4);
        head = list.addFirst(head,3);
        head = list.addFirst(head,2);
        head = list.addFirst(head,1);
        head = list.middleNodeFS(head);
        System.out.println("预期结果是4, 实际是：" + head.val);
    }

}
