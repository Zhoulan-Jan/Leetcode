public class $206 {
        public ListNode reverseList(ListNode head) {
            //空链表
            if (head == null) {
                return head;
            }
            //只有一个节点
            if (head.next == null) {
                return head;
            }
            ListNode prev = null;
            ListNode cur = head;
            ListNode next;
            ListNode newHead = null;
            while (cur != null) {
                next = cur.next;
                if (cur.next == null) {
                    newHead = cur;
                }
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return newHead;
        }
}
