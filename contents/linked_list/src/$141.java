/**
 * 使用快慢指针，若两指针重合，说明有环
 * 注：循环条件的顺序
 * 判断指针相等，要在先前进之后
 */
public class $141 {
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
