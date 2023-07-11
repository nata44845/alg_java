/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        RedBlackTree rbTree = new RedBlackTree();

        Integer[] arr = new Integer[] {7,6,9,1,5,2,3,4,34,11};

        for (int i=0; i<arr.length; i++) {
            System.out.println(rbTree.insert(arr[i]));        
        } 

        System.out.println(rbTree);
    }
}