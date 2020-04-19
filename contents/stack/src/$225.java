/**
 * 队列A 实现出入栈的主要据点，队列B 作为辅助
 * 入栈：元素进入到A
 * 出栈：A中的元素依次进入到B中，直到A中只剩一个元素，取出该元素。互换AB。
 * 栈顶元素：A中的元素依次进入到B中，直到A中只剩一个元素，得到并取出该元素。互换AB。
 * 栈是否空：A、B中均无元素
 */

import java.util.LinkedList;
import java.util.Queue;

public class $225 {
    Queue<Integer> qA = new LinkedList<>();
    Queue<Integer> qB = new LinkedList<>();

    /** Initialize your data structure here. */
//    public MyStack() {
//
//    }

    /** Push element x onto stack. */
    public void push(int x) {
        qA.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (qA.size() == 0) {
            return -1;
        }
        //A 一直往 B 放元素直到 A 只剩一个元素
        while (qA.size() != 1) {
            qB.offer(qA.poll());
        }
        int x = qA.poll();
        Queue tmp;
        tmp =  qA;
        qA = qB;
        qB = tmp;
        return x;
    }

    /** Get the top element. */
    public int top() {
        if (qA.size() == 0) {
            return -1;
        }
        //A 一直往 B 放元素直到 A 只剩一个元素
        while (qA.size() != 1) {
            qB.offer(qA.poll());
        }
        int x = qA.peek();
        qB.offer(qA.poll());
        Queue tmp;
        tmp =  qA;
        qA = qB;
        qB = tmp;
        return x;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if (qA.size() == 0 && qB.size() == 0) {
            return true;
        }
        return false;
    }
}
