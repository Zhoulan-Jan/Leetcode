class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    //尾插法
    public ListNode addLast(ListNode head, int elem) {
        ListNode node = new ListNode(elem);
        //空链表
        if (head == null) {
            head = node;
        } else { //非空链表
            ListNode last = head;
            while(last.next != null) {
                last = last.next;
            }
            last.next = node;
        }
       return head;
    }

    //打印链表
    public void display(ListNode head) {
        System.out.print("[");
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val);
            if (cur.next != null) {
                System.out.print(", ");
            }
            cur = cur.next;
        }
        System.out.println("]");
    }

    //删除链表的倒数第 n 个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        if (head.next == null && n == 1) {  //保证n是有效的，说明n只可能为1？
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) { //要注意链表长度 == n时，会fast会越界
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
