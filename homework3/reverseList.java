class dList {
    static Node head;
    static Node tail;

    static class Node{
        int value;
        Node next;
        Node prev;
    }

    public static void pushFront(int value) {
        Node node = new Node();
        node.value = value;

        if (head == null) {
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
        }
        head = node;
    }

    public static void popFront() {
        if (head != null) {
            if (head.next == null) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
        }
    }

    public static void print() {
        Node cur = head;
        while (cur != null) {
            System.out.printf("%d ",cur.value);
            cur = cur.next;
        } 
        System.out.println();
    }

    public static boolean contains(int value) {
        Node cur = head;
        while (cur != null) {
            if (cur.value == value) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public static void pushBack(int value) {
        Node node = new Node();
        node.value = value;

        if (tail == null) {
            head = node;
        } else {
            node.prev = tail;
            tail.next = node;
        }
        tail = node;
    }

    public static void popBack() {
        if (tail != null) {
            if (tail.prev == null) {
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
        }
    }

    public static void sort() {
        boolean needSort = true;
        do {
            needSort = false;
            Node node = head;
            while (node != null && node.next!=null)
            {   if (node.value > node.next.value) {
                    Node before = node.prev;
                    Node cur = node;
                    Node next = node.next;
                    Node after = next.next;

                    cur.next = after;
                    cur.prev = next;
                    next.next=cur;
                    next.prev = before;

                    if (before != null) {
                        before.next = next;
                    }
                    else {
                        head = next;
                    }

                    if (after != null) {
                        after.prev = cur;
                    } else {
                        tail = cur;
                    }
                    needSort = true;
                }
                node = node.next;
            }
        } while (needSort);
    }

    public static void reverse() {
        Node cur = tail;
        Node temp1,temp2;
        Node curPrev = null;
        Node curNext = null;
        if (tail != null) {
            curPrev = tail.next;
            curNext = tail.prev;
        }

        Node newHead = tail;
        while (curNext!=null) {
            cur.next = curNext;
            cur.prev = curPrev;

            temp1 = curNext;
            curNext = curNext.prev;
            temp2 = cur;
            cur = temp1;
            curPrev = temp2; 

            if (curNext!= null) {
            System.out.printf("%d %d %d",curNext.value,cur.value,curPrev.value);
            System.out.println();
            }
        } 
        
        if (tail != null) {
            tail = head;
            tail.next = null;
            head = newHead;
            head.prev = null;
        }
    }

}

public class reverseList {
    public static void main(String[] args) {
        dList ls = new dList();
        for (int i=1; i<=10;i++) {
            ls.pushFront(i);
        } 
        ls.print(); 
        ls.reverse();
        ls.print();

    }
}