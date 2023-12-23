import java.util.HashMap;

public class $146 {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> hashMap = new HashMap<>();
    Node head = null;
    Node tail = null;
    int capacity;

    public $146(int capacity) {
        this.capacity = capacity;
    }

    //双向链表，将节点移动到tail后面，表示该节点是最近使用的
    public void removeToTail(Node node) {
        if (node == tail) {

        } else if (node == head) {
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
            head = head.next;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }
    }

    //双向链表，增加某节点
    public void add(Node node) {
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }
    }


    public int get(int key) {
        //1.哈希表不存在key，返回-1
        if (!hashMap.containsKey(key)) {
            return -1;
        } else { //2.哈希表存在key，从哈希表中获得value，将key移到链表尾部
            int res = hashMap.get(key).value;
            removeToTail(hashMap.get(key));
            return res;
        }
    }

    public void put(int key, int value) {
        //1.哈希表不存在key
        if (!hashMap.containsKey(key)) {
            //1.1创建新节点
            Node node = new Node(key, value);
            //1.2插入
            //插入到哈希表
            hashMap.put(key, node);
            //插入到链表
            add(node);

            //1.3判断哈希表容量
            if (hashMap.size() > capacity) {
                //1.3.1删除
                //哈希表删除链表头元素
                hashMap.remove(head.key);
                //链表删除头元素
                // remove(head);
                head = head.next;
            }
        } else { //2.哈希表存在key
            //2.1更新
            //更新链表，将key移到链表尾部
            removeToTail(hashMap.get(key));
            //更新哈希表，key对应的value
            hashMap.get(key).value = value;
        }
    }

    public static void main(String[] args) {
        $146 a = new $146(4);
        a.put(8,80);
        a.put(9,90);
        a.put(7,70);
        a.put(6,60);
        a.get(8);
        a.get(7);
        a.put(5,50);
    }

//    //双向链表，删除某节点
//    public void remove(Node node) {
//        // head = head.next;
//        if (node == tail) {
//            tail = tail.prev;
//        } else if (node == head) { //均是头结点
//            head = head.next;
//        } else {
//            node.prev.next = node.next;
//            node.next.prev = node.prev;
//        }
//    }
}
