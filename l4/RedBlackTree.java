public class RedBlackTree {
    Node root;

    enum Color {
        RED, BLACK;
    }

    public class Node {
        int value;

        Color color;
        Node leftChild;
        Node rightChild;

        @Override
        public String toString() {
            return "Node{value="+value+",color="+color+"}";  
        }
    }

    public void add(int value) {
        addNode(root, value);
    }

    private boolean addNode(Node node, int value) {
        if (node.value == value) {
            return false;
        } else {
            if (node.value>value) {
                if (node.leftChild != null) {
                    boolean result = addNode(node.leftChild,value);
                    node.leftChild = rebalance(node.leftChild);
                    return result;
                } else {
                    node.leftChild = new Node();
                    node.leftChild.color = Color.RED;
                    node.leftChild.value = value;
                    return true;
                }
            } else {
                if (node.rightChild !=null) {
                    boolean result = addNode(node.rightChild,value);
                    node.rightChild = rebalance(node.rightChild);
                    return result;
                } else {
                    node.rightChild = new Node();
                    node.rightChild.color = Color.RED;
                    node.rightChild.value = value;
                    return true;
                }
            }
        } 
    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean needBalance;
        do {
            needBalance = false;
            if (result.rightChild != null && result.rightChild.color == Color.RED &&
                (result.leftChild == null || result.leftChild.color == Color.BLACK)) {
                    needBalance = true;
                    result = rightSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.RED) {
                    needBalance = true;
                    result = leftSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
            result.rightChild != null && result.rightChild.color == Color.RED) {
                needBalance = true;
                colorSwap(result);
            }
        } while (needBalance);
        return result;
    }

    private Node rightSwap(Node node) {
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }

    private Node leftSwap(Node node) {
        Node leftChild = node.leftChild;
        Node betweenChild = leftChild.rightChild;
        leftChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }

    private void colorSwap(Node node) {
        node.rightChild.color = Color.BLACK;
        node.leftChild.color = Color.BLACK;
        node.color = Color.RED;
    }
}
