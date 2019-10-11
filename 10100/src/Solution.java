import javax.swing.*;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    //头插法
    public ListNode addFirst(ListNode head, int elem) {
        ListNode node = new ListNode(elem);
        //空链表
        if (head == null) {
            head = node;
        } else {   //非空链表
            node.next = head;
            head = node;
        }
        return head;
    }

    //打印链表
    public void display(ListNode head) {
        System.out.print("[");
        ListNode cur = head;
        while(cur != null) {
            System.out.print(cur.val);
            if (cur.next != null) {
                System.out.print(", ");
            }
            cur = cur.next;
        }
        System.out.println("]");
    }

    //两数相加
    //要注意进位的情况啊 如 5 + 5 = 10 . 99 + 1 = 100 .思路跟大数相加一样
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        ListNode h1 = l1;
        ListNode h2 = l2;
        int carry = 0;
        while (h1 != null && h2 != null) {
            int res = h1.val + h2.val + carry;
            carry = res / 10 ;
            newTail.next = new ListNode(res % 10);
            newTail = newTail.next;
            h1 = h1.next;
            h2 = h2.next;
        }

//        if (h2 != null) {
//            newTail.next = new ListNode(h2.val + carry); //ListNode(h2.val + carry)存在进位情况
//            carry = 0;
//            h2 = h2.next;
//            newTail = newTail.next;
//            newTail = h2;
//        }

        if (h2 != null) {
            while (h2 != null) {
                int res = h2.val + carry;
                carry = res / 10;
                newTail.next = new ListNode(res % 10);
                newTail = newTail.next;
                h2 = h2.next;
            }
        }

        if (h1 != null) {
            while (h1 != null) {
                int res = h1.val + carry;
                carry = res / 10;
                newTail.next = new ListNode(res % 10);
                newTail = newTail.next;
                h1 = h1.next;
            }
        }

        if (carry != 0 ) {
            newTail.next = new ListNode(carry);
        }
        return newHead.next;
    }
}
