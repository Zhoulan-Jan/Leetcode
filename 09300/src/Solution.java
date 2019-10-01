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
        }
        //非空链表
        //找到最后一个节点
        else {
            ListNode last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = node;
        }
        return head;
    }

    //打印链表
    public void display(ListNode head) {
        System.out.print("[");
        for (ListNode node = head; node != null; node = node.next) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    //求链表长度
    public int size(ListNode head) {
        int len = 0;
        for (ListNode node = head; node != null; node = node.next) {
            len++;
        }
        return len;
    }

    //链表倒数第k个结点 //快慢指针
    public ListNode FindKthToTailFS(ListNode pListHead, int k) {
        //判断k的合法性
        int len = size(pListHead);
        if (k < 0 || k > len) {
            return null;
        }
        ListNode fast = pListHead;
        ListNode slow = pListHead;
        //快指针先走k步
       for (int i = 0; i < k; i++) {
           fast = fast.next;
       }
        while (fast != null ) {//&& fast.next != null
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //链表倒数第k个结点 //长度-k
    public ListNode FindKthToTail(ListNode head, int k){
        int offset = size(head) - k;
        for (int i = 0; i < offset; i++) {
            head = head.next;
        }
        return head;
    }
}
