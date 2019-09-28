public class Test {
    public static void main(String[] args) {
        testaddFirst();
    }

    public static void testaddFirst() {
         //当new一个对象，自动有了一个节点
//        for (int i = 5; i < 9; i+=2){
//            head = list.addFirst(head,i);
//        }
        System.out.println("测试addFirst方法： ");
        Merge list = new Merge();

        ListNode head1 = new ListNode();
        head1=list.addFirst(head1,4);
        head1=list.addFirst(head1,3);
        head1=list.addFirst(head1,1);
        System.out.print("预期结果是[1,3,4], 实际是：");
        list.display(head1);

        ListNode head2 = new ListNode();
        head2 = list.addFirst(head2,4);
        head2 = list.addFirst(head2,2);
        head2 = list.addFirst(head2,1);
        System.out.print("预期结果是[1,2,4], 实际是：");
        list.display(head2);

        ListNode sorted = list.mergeTwoLists(head1,head2);
        System.out.print("预期结果是[1,1,2,3,4,0,0], 实际是：");
        list.display(sorted);
    }
}
