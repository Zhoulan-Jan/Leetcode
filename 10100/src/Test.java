import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        testaddFirst();
        testaddTwoNumbers();
    }

    public static void testaddFirst() {
        System.out.println("测试头插法：");
        Solution list = new Solution();
        ListNode head = null;
        head = list.addFirst(head,1);
        head = list.addFirst(head,2);
        head = list.addFirst(head,3);
        head = list.addFirst(head,4);
        head = list.addFirst(head,5);
        System.out.print("预期结果是[5,4,3,2,1,],实际是：");
        list.display(head);
    }

    public static void testaddTwoNumbers() {
        System.out.println("测试addTwoNumbers方法：");
        Solution list = new Solution();
        ListNode head1 = null;
        //head1 = list.addFirst(head1,3);
        head1 = list.addFirst(head1,9);
        head1 = list.addFirst(head1,9);


        ListNode head2 = null;
//        head2 = list.addFirst(head2,4);
//        head2 = list.addFirst(head2,6);
        head2 = list.addFirst(head2,1);

        ListNode ans = list.addTwoNumbers(head1,head2);
        System.out.print("预期结果是[0,9],实际是：");
        list.display(ans);
    }
}
