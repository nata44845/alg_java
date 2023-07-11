class HashMap {

    class Entity {
        int key;
        int value;
    }

    class Basket {
        Node head;

        class Node {
            Entity entity;
            Node next;
        }

        private boolean push(Entity entity) {
            Node node = new Node();
            node.entity = entity;
            if (head == null) {
                head = node;
            } else {
                Node cur = head;
                while (cur!=null) {
                    if (cur.entity.key == entity.key) return false;
                    if (cur.next == null) {
                        cur.next = node;
                        return true;
                    }
                    cur = cur.next;
                }
            }
            return true;
        }

        private Integer find(int key) {
            Node cur = head;
            while (cur!=null) {
                if (cur.entity.key == key) return cur.entity.value;
                cur = cur.next;
            }
            return null;
        }

        private boolean remove(int key) {
            if (head != null) {
                if (head.entity.key == key) {
                    head = head.next;
                    return true;
                }

                Node cur = head;
                while (cur.next!=null) {
                    if (cur.next.entity.key == key) {
                        cur.next = cur.next.next;
                        return true;
                    }
                    cur = cur.next;
                }
            }
            return false;
        }

        public String toString(int key) {
            String str = Integer.toString(key)+" ";
            Node cur = head;
            while (cur!=null) {
                str +=  String.format("%s->%s ",cur.entity.key,cur.entity.value);
                cur = cur.next;
            }
            return str;
        }
    }

    static final int INIT_SIZE = 16;
    Basket[] baskets;

    public HashMap() {
        //Вызов конструктора с size = 16
        this(INIT_SIZE);
        
    } 

    public HashMap(int size) {
        baskets = new Basket[size];
    } 

    private int getIndex(int key) {
        //return key % baskets.length; //[0..len-1] 
        //key.hashCode()
        //22 % 16 = 6
        //Для отрицательных
        return (key % baskets.length + baskets.length) % baskets.length;
    }

    public boolean push(int key, int value) {
        int index = getIndex(key);
        Basket basket = baskets[index];
        if (basket == null) {
            basket = new Basket();
            baskets[index] = basket;
        }
        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;
        return basket.push(entity);
    }

    public Integer find(int key) {
        int index = getIndex(key);
        Basket basket = baskets[index];
        if (basket != null) {
            return basket.find(key);
        }
        return null;
    }

    public boolean remove(int key) {
        int index = getIndex(key);
        Basket basket = baskets[index];
        if (basket != null) {
            return basket.remove(key);
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<=baskets.length-1; i++)
        {
            Basket basket = baskets[i];
            if (basket != null) {
                sb.append(basket.toString(i)+"\n");
            }
        }    
        return sb.toString();
    }

}

class Tree {
    Node root;

    class Node {
        int value;
        Node left;
        Node right;
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node();
            root.value = value;
        } else {
            insert(root,value);
        }
    }

    private void insert(Node node,int value) {
        if (node.value != value) {
            if (node.value < value) {
                //right
                if (node.right == null) {
                    node.right = new Node();
                    node.right.value = value;
                } else {
                    insert(node.right,value);
                }

            } else {
                //left
                if (node.left == null) {
                    node.left = new Node();
                    node.left.value = value;
                } else {
                    insert(node.left,value);
                }
            }
            
        }
    }

    public Node find(int value) {
        return find(root,value);
    } 

    private Node find(Node node,int value) {
        if (node == null) {
            return null;
        } 
        if (node.value == value) {
            return node;
        }
        if (node.value < value) return find(node.right,value);
        else return find(node.left, value);
    }

}



/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        // HashMap hashMap = new HashMap();
        // hashMap.push(450, 0);
        // hashMap.push(11, 13);
        // hashMap.push(26,21);
        // hashMap.push(39, 36);
        // hashMap.push(42,45);
        // hashMap.push(51, 51);
        // hashMap.push(61, 6);
        // hashMap.push(71, 700);
        // hashMap.push(-1, 200);
        // System.out.println(hashMap.find(71)); 
        // hashMap.remove(71);
        // System.out.println(hashMap); 

        Tree tree = new Tree();
        tree.insert(6);
        tree.insert(7);
        tree.insert(9);
        tree.insert(1);
        tree.insert(8);

    }
}