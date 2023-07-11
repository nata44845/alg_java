import java.util.ArrayList;
import java.util.List;

/**
 * Tree
 */
public class Tree {
    Node root;
    public class Node {
        int value;
        List<Node> children;
    }

    public boolean exist(int value) {
        if (root==null) return false;
        Node node = find(root, value);
        return (node !=null);
    }

    private Node find(Node node, int value) {
        if (node.value == value) {
            return node;
        } else {
            for (Node child: node.children) {
            Node result = find(child, value);
            if (result != null) return result; 
            }
        }
        return null;
    }

    private Node findWidth(int value) {
        List<Node> line = new ArrayList<>();
        line.add(root);
        while (line.size()>0) {
            List<Node> nextLine = new ArrayList<>();
            for (Node node: line) {
                if (node.value == value) {
                    return node;
                }
                nextLine.addAll(node.children);
            }
            line = nextLine;
        }
        return null;
    }



}