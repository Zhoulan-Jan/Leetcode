class ListNode{
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
        if (head == null) {
            head = node;
        }
        else {
            //找到最后一个节点
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
        for (ListNode cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.val);
            if (cur.next != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    //将两个有序链表合并为一个有序链表
    public ListNode mergeTwoLists(ListNode l1,ListNode l2) {
        ListNode newHead = new ListNode(-1); //傀儡节点
        ListNode h1 = l1;
        ListNode h2 = l2;
        ListNode newTail = newHead;
        while (h1 != null && h2 !=  null) {
            if (h1.val < h2.val) {
                newTail.next = h1;
                h1 = h1.next;
            }
            else {
                newTail.next = h2;
                h2 = h2.next;
            }
            newTail = newTail.next;
        }
        if (h1 != null) {
            newTail.next = h1;
        }
        else {
            newTail.next = h2;
        }
        return newHead.next;
    }

    //链表分割  分割以后保持原来的数据顺序不变
    public ListNode partition(ListNode pHead, int x) {
        ListNode smallHead = new ListNode(-1);
        ListNode smallTail = smallHead;
        ListNode bigHead = new ListNode(-1);
        ListNode bigTail = bigHead;
        ListNode cur = pHead;
        while (cur != null) {
            if (cur.val <= x) {
                smallTail.next = new ListNode(cur.val); //smallTail.next = cur;错了？？
                smallTail = smallTail.next;
            }else{
                bigTail.next = new ListNode(cur.val);
                bigTail = bigTail.next;
            }
            cur = cur.next;
        }
        smallTail.next = bigHead.next;
        return smallHead.next;
    }

    //删除链表中重复的结点 保留一个重复结点
    //用新链表接收
    public ListNode deleteDuplicationOne(ListNode pHead){
        if (pHead == null) return null;
        if (pHead.next == null) return pHead;
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        ListNode cur = pHead;
        ListNode pnext = cur.next;
        while (cur.next != null) {
            if (cur.val == pnext.val) {
                cur = cur.next;
                pnext = pnext.next;
            } else {
                newTail.next = new ListNode(cur.val);
                newTail = newTail.next;
                cur = cur.next;
                pnext = pnext.next;
            }
        }
        newTail.next = new ListNode(cur.val);
        return newHead.next;
    }

    //删除重复结点 不保留重复结点 //用新链表接收
    public ListNode deleteDuplication(ListNode pHead){
        if (pHead == null) return null;
        if (pHead.next == null) return pHead;
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        ListNode cur = pHead;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val   ) {  //&&两边的操作不能调换，因为存在短路
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                //cur再后移，指向不重复的结点
                cur = cur.next;
            }
            else {
                newTail.next = new ListNode(cur.val);
                newTail = newTail.next;
                cur = cur.next;
            }
        }
        return newHead.next;
    }

    //链表的回文
    public boolean chkPalindrome(ListNode A){
        //找到链表的中间结点
        ListNode mid = midNode(A);
        //中间节点往后 反转
        ListNode B = reverseList(mid);
        //比较
        while (B != null) {
            if (A.val != B.val) {
                return false;
            }
            A = A.next;
            B = B.next;
        }
        return true;
    }

    //找到链表的中间结点
    public ListNode midNode(ListNode head) {
        int length = 0;
        for (ListNode node = head; node != null; node = node.next) {
            length++;
        }
        int offset = length/2;
        for (int i = 0; i < offset; i++) {
            head = head.next;
        }
        return head;
    }

    //链表的反转
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode prev = null;
        ListNode cur = head;
        ListNode pnext = cur.next;
        ListNode newHead = null;
        while (cur != null) {
            pnext = cur.next;
            if (pnext == null) {
                newHead = cur;
            }
            cur.next = prev; //刚开始prev是空
            prev = cur;
            cur = pnext;
        }
        return newHead;
    }

    //链表相交
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //较长的链表先走k步
        int lena = size(headA);
        int lenb = size(headB);
        if (lena > lenb) {
            int steps = lena - lenb;
            for (int i = 0; i < steps; i++) {
                headA = headA.next;
            }
        }else {
            int steps = lenb - lena;
            for (int i = 0; i < steps; i++) {
                headB = headB.next;
            }
        }
        //比较相同的点
        while (headA !=null ) {
            if (headA == headB) {
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    //求链表的长度
    public int size(ListNode head) {
        int length = 0;
        for (ListNode node = head; node != null; node = node.next) {
            length++;
        }
        return length;
    }
}
