/**
 * 1.让较长的链表的先走差值步
 * 2.两个链表同时走
 * 3.若相等，则有相交点
 */
public class $160 {
    public static int size(ListNode head) {
        int len = 0;
        for (ListNode node = head; node != null; node = node.next) {
            len++;
        }
        return len;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = size(headA);
        int lenB = size(headB);
        int k = 0;
        int flg = 1;
        if (lenA>lenB) {
            k = lenA - lenB;
        } else {
            k = lenB - lenA;
            flg = 0;
        }

        if (flg == 1) {
            for (int i = 0; i < k; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < k; i++) {
                headB = headB.next;
            }
        }

        while (headA != null && headB != null) {
            if (headB == headA) {
                return headB;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
