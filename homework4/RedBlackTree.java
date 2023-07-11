public class RedBlackTree {
    Node root;

    enum Color {
        RED, BLACK;
    }

    public class Node {
        int value;

        Color color;
        Node left;
        Node right;

        @Override
        public String toString() {
            return color+"->"+value; 
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); 
        return getSubNode(root,"",sb);  
    }

    private String getSubNode(Node node,String text,StringBuilder sb) {
        if (node == null) return sb.toString();
        else {
            getSubNode(node.right,text+"---",sb);
            sb.append(text+node+"\n");
            getSubNode(node.left,text+"---",sb);
        }
        return sb.toString();
    }

    public String insert(int value) {
        if (root == null) {
            root = new Node();
            root.value = value;
        } else {
            boolean result = insert(root,value); 
            root = rebalance(root);
            if (!result) return "Ошибка добавления элемента "+value;
        }
        root.color = Color.BLACK;
        return "Добавлен элемент "+value;
    }

    private boolean insert(Node node, int value) {
        if (node.value == value) {
            return false;
        } else {
            if (node.value>value) {
                if (node.left != null) {
                    boolean result = insert(node.left,value);
                    node.left = rebalance(node.left);
                    return result;
                } else {
                    node.left = new Node();
                    node.left.color = Color.RED;
                    node.left.value = value;
                    return true;
                }
            } else {
                if (node.right !=null) {
                    boolean result = insert(node.right,value);
                    node.right = rebalance(node.right);
                    return result;
                } else {
                    node.right = new Node();
                    node.right.color = Color.RED;
                    node.right.value = value;
                    return true;
                }
            }
        } 
    }

    private Node rebalance(Node node) {
        //System.out.println("Balancing Node : " + node.value + " Color : " + node.color);
        Node result = node;
        boolean needBalance;
        do {
            // если правая нода красная и левая нода черная - левосторонний поворот
            // если левая нода красная и левая нода левой ноды красная - правосторонний поворот
            // если левая нода красная и правосторонняя нода красная - делаем свап цвета.
            needBalance = false;
            if (result.right != null && result.right.color == Color.RED &&
                (result.left == null || result.left.color == Color.BLACK)) {
                    needBalance = true;
                    result = leftSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
                result.left.left != null && result.left.left.color == Color.RED) {
                    needBalance = true;
                    result = rightSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
            result.right != null && result.right.color == Color.RED) {
                needBalance = true;
                colorSwap(result);
            }
        } while (needBalance);
        return result;
    }

    private Node leftSwap(Node node) {
        Node right = node.right;
        Node betweenChild = right.left;
        right.left = node;
        node.right = betweenChild;
        right.color = node.color;
        node.color = Color.RED;
        return right;

    }

    private Node rightSwap(Node node) {
        Node left = node.left;
        Node betweenChild = left.right;
        left.right = node;
        node.left = betweenChild;
        left.color = node.color;
        node.color = Color.RED;
        return left;
    }

    private void colorSwap(Node node) {
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;
    }

}
