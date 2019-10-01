public class Test {
    public static void main(String[] args) {
        testaddLast();
        testmergeTwoLists();
        testpartition();
        testdeleteDuplication();
        testchkPalindrome();
        testgetIntersectionNode();
    }

    public static void testaddLast(){
        System.out.println("测试addLast方法：");
        Solution list = new Solution();
        ListNode head = null;
        head = list.addLast(head,1);
        head = list.addLast(head,2);
        head = list.addLast(head,3);
        head = list.addLast(head,4);
        head = list.addLast(head,5);
        System.out.print("预期结果是[1,2,3,4,5], 实际是：");
        list.display(head);
    }
    
    public static void testmergeTwoLists() {
        System.out.println("测试mergeTwoLists方法：");
        Solution list = new Solution();
        ListNode head1 = null;
        head1 = list.addLast(head1,1);
        head1 = list.addLast(head1,2);
        head1 = list.addLast(head1,4);
        ListNode head2 = null;
        head2 = list.addLast(head2,1);
        head2 = list.addLast(head2,3);
        head2 = list.addLast(head2,4);
        ListNode head3 = list.mergeTwoLists(head1,head2);
        System.out.print("预期结果是[1,1,2,3,4,4], 实际是：");
        list.display(head3);
    }

    public static void testpartition(){
        System.out.println("测试partition方法：");
        Solution list = new Solution();
        ListNode head = null;
        head = list.addLast(head,11);
        head = list.addLast(head,2);
        head = list.addLast(head,33);
        head = list.addLast(head,9);
        head = list.addLast(head,5);
        head = list.partition(head,10);
        System.out.print("预期结果是[2,9,5,11,33], 实际是：");
        list.display(head);
    }

    public static void testdeleteDuplication(){
        System.out.println("测试deleteDuplication方法：");
        Solution list = new Solution();
        ListNode head = null;
        head = list.addLast(head,1);
        head = list.addLast(head,2);
        head = list.addLast(head,3);
        head = list.addLast(head,3);
        head = list.addLast(head,3);
        head = list.addLast(head,4);
        head = list.addLast(head,4);
        head = list.addLast(head,5);
        ListNode head1 = list.deleteDuplicationOne(head);
        System.out.print("保留一个重复结点：预期结果是[1,2,3,4,5], 实际是：");
        list.display(head1);

        ListNode head2 =list.deleteDuplication(head);
        System.out.print("不保留重复结点：预期结果[1,2,5], 实际是：");
        list.display(head2);
    }

    public static void testchkPalindrome(){
        System.out.println("测试chkPalindrome方法：");
        Solution list = new Solution();
        ListNode head = null;
        //非回文测试
//        head = list.addLast(head,1);
//        head = list.addLast(head,2);
//        head = list.addLast(head,3);
//        head = list.addLast(head,4);
//        head = list.addLast(head,5);
        //回文测试
        head = list.addLast(head,1);
        head = list.addLast(head,2);
        head = list.addLast(head,2);
        head = list.addLast(head,1);
//        ListNode test1 = list.midNode(head);
//        System.out.println("预期结果是3, 实际是：" + test1.val);
//        ListNode test2 = list.reverseList(head);
//        System.out.print("预期结果是[5,4,3,2,1], 实际是：");
//        list.display(test2);   //head改变了
        //list.display(head);
        boolean result = list.chkPalindrome(head);
        System.out.println("预期是true, 实际是：" + result);
    }

    public static void testgetIntersectionNode(){
        System.out.println("测试getIntersectionNode方法：");
        Solution list = new Solution();
        ListNode head1 = null;
        head1 = list.addLast(head1,4);
        head1 = list.addLast(head1,1);
        head1 = list.addLast(head1,8);
        head1 = list.addLast(head1,4);
        head1 = list.addLast(head1,5);

        ListNode head2 = null;
        head2 = list.addLast(head2,5);
        head2 = list.addLast(head2,0);
        head2 = list.addLast(head2,1);
        head2 = list.addLast(head2,8);
        head2 = list.addLast(head2,4);
        head2 = list.addLast(head2,5);
//        list.display(head1);
//        list.display(head2);
        ListNode result = list.getIntersectionNode(head1,head2);
        //list.display(result);  //为什么result会是空呢，leetcode都编译通过了
        System.out.print("预期结果是8, 实际是：" + result);
    }

}
