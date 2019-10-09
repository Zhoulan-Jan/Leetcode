class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    //头插法
    public ListNode addFirst(ListNode head, int elem) {
        ListNode node = new ListNode(elem);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
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

    //判断链表是否有环
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast!= null && fast.next != null) {  //这两个的顺序不能调换
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    //链表入环的第一个节点
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        //不带环
        if (fast == null || fast.next == null) {
            return null;
        }
        ListNode cur1 = head;
        ListNode cur2 = fast;
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}
