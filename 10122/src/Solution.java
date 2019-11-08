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
    //打印
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

    //两两交换链表中的结点
//    public ListNode swapPairs(ListNode head) {
//        if (head == null) return null;
//        if (head.next == null) return head;
//        ListNode cur = head.next;
//        ListNode prev = head;
//        ListNode pnext = cur.next;
//        while (pnext != null) {
//            cur.next =prev;
//            prev.next = pnext.next;
//            cur = pnext.next;
//            prev = pnext;
//            pnext = cur.next;
//        }
//        return head.next;
//    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null ||head.next == null) return null;
        //创建一个傀儡节点
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode p = fakeHead;
        ListNode odd = head;
        ListNode even = null;
        while (odd != null && odd.next != null) {
            even = odd.next;

            odd.next = even.next;
            even.next = odd;
            p.next = even;

            p = odd;
            odd = odd.next;
        }
        return fakeHead.next;
    }

    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        //pre是前一个节点,next是后一个节点,tmphead保存第一次的头节点,tmp保存上一次的尾节点,p是移动指标
        ListNode pre = null,next,tmphead = null,tmp = null,p = head;
        int i = 0;
        while (p != null && p.next != null) {
            //保存上一次的尾节点
            if (i > 0) tmp = pre;
            //交换
            pre = p;
            next = p.next;
            pre.next = next.next;
            next.next = pre;
            //只需要移到下一个节点即可
            p = pre.next;
            //上一次的尾节点链上这次的头节点
            if (i > 0) tmp.next = next;
            //保存第一次的头节点
            if (i == 0) tmphead = next;
            i++;
        }
        return tmphead;
    }
}
