/**
 * list
 */
public class list {

    Node head;
    Node tail;

    public class Node {
        int value;
        Node next;
        Node prev;
    }

    public Node findNode(int value){
        Node node = head;
        while (node.next != null) {
            node = node.next;
            if (node.value == value) {
                return node;
            }
        }
        return null;
    }

    public void add(int value){
        Node node = new Node();
        node.value = value;
        if (head == null){
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    
    public void add(int value, Node node){
        Node next = node.next;
        Node newNode = new Node();

        newNode.value = value;
        
        node.next = newNode;
        newNode.prev = node;
        if (next == null){
            tail = newNode;
        } else {
            newNode.next = next;
            next.prev = newNode;
        }
    }

    public void delete(Node node){
        Node prev = node.prev;
        Node next = node.next;
        if (prev == null) {
            node.next.prev = null;
            head = next;
        } else if (next==null) {
            node.prev.next = null;
            tail = prev;
        } else {
            prev.next = next;
            next.prev = prev;
        }
    }

    public void revert(){
        Node currentNode = head;
        while (currentNode!=null){
            Node next = currentNode.next;
            Node prev = currentNode.prev;
            currentNode.next = prev;
            currentNode.prev = next;
            if (prev==null) {
                tail = currentNode;
            }
            if (next==null) {
                head = currentNode;
            }
            currentNode = next;
        }
    }

    public void revertRec(){
        if (head!=null && head.next!= null) {
            Node temp = head;
            revertRec(head.next, head);
            temp.next = null;
        }
    }

    public void revertRec(Node currentNode, Node prev){
        if (currentNode.next == null) {
            head = currentNode;
        } else {
            revertRec(currentNode.next, currentNode);
        }
        currentNode.next = prev;
        prev.next = null;
    }

    public void push(int value) {
        Node node = new Node();
        node.value = value;
        node.next=head;
        head=node;
    }

    public Integer pop() {
        Integer result = null;
        if (head != null) {
            result = head.value;
            head = head.next;
        }
        return result;
    }

    public Integer peek() {
        Integer result = null;
        if (tail != null) {
            result = tail.value;
            tail = tail.prev;
            tail.next = null;
        }
        return result;
    }
    

    public static void main(String[] args) {
        // add(1);
        // add(5);

    }
}