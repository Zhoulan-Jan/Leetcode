import java.util.List;

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    //打印链表
    public void display(ListNode head) {
        System.out.print("[");
        for (ListNode node = head; node != null; node = node.next) {
            System.out.print(node.val);
            if(node.next != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    //头插法
    public ListNode addFirst(ListNode head, int elem) {
        ListNode node = new ListNode(elem);
        //空链表
        if (head == null) {
            head = node;
        }
        //非空链表
        else {
            node.next = head;
            head = node;
        }
        return head;
    }

    //反转单链表
    public ListNode reverseList(ListNode head) {
        //空链表
        if (head ==  null) return null;
        //只有一个元素的链表
        if (head.next ==  null) return head;
        //多个元素
        ListNode prev = null;
        ListNode cur = head;
        ListNode pnext = cur.next;
        ListNode newHead = null;
        while (cur != null) {
            pnext = cur.next;
            if (pnext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = pnext;
        }
        return newHead;
        //error code
//        ListNode prev = null;
//        ListNode cur = head;
//        ListNode pnext = cur.next;
//        ListNode newHead = null;
//        while (cur != null) {
//            cur.next = prev;
//            prev = cur;
//            cur = pnext;
//            if (pnext == null) {
//                newHead = cur;
//                break;
//            }
//            pnext = cur.next;
//        }
//        return newHead;
    }

    //返回链表的中间结点  链表长度的一半
    private int size(ListNode head) {
        int length = 0;
        for (ListNode node = head; node != null; node = node.next) {
            length ++;
        }
        return length;
    }

    public ListNode middleNode(ListNode head) {
        int mid = size(head)/2;
        ListNode node = head;
        for (int i = 0; i < mid; i++) {
            node = node.next;
        }
        return node;
    }

    //返回链表的中间结点 快慢指针
    public ListNode middleNodeFS(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return slow;
            }
            fast = fast.next.next; //一次走两步
            slow = slow.next;
        }
        //报错的代码
//        while(fast.next != null && fast != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        return slow;
    }
}
