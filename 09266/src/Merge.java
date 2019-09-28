class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
    //空的构造方法
    public ListNode() {
    }
}

public class Merge {
    //头插法
    public ListNode addFirst(ListNode head, int elem) { //head是一个节点
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

    //合并
    public ListNode mergeTwoLists(ListNode l1,ListNode l2) {
            ListNode newHead = new ListNode(-1);
            ListNode newTail = newHead;
            ListNode h1 = l1;
            ListNode h2 = l2;

           while (h1 != null && h2 != null) {
               if (h1.val < h2.val) {
                   newTail.next = h1;
                   h1 = h1.next;
               } else {
                   newTail.next = h2;
                   h2 = h2.next;
               }
               newTail = newTail.next;
           }
           //后面未插入到新链表的结点 均接在后面
           if (h2 != null) {
               newTail = h2;
           } else {
               newTail = h1;
           }
            return newHead.next;  //第一个节点是无效结点
    }
}
