import java.util.Arrays;
import java.util.Random;

/**
 * heapSort.
 */
public class heapSort {
    public static void heapify(int[] array, int heapSize, int rootIndex) {  
        int largest = rootIndex;
        int leftChild = 2*rootIndex+1;
        int rightChild = 2*rootIndex+2;
        int temp;

        //Если левый дочерний элемент больше корня
        if (leftChild < heapSize && array[leftChild]>array[largest]) {
            largest = leftChild;
        }

        //Если правый дочерний элемент больше корня
        if (rightChild < heapSize && array[rightChild]>array[largest]) {
            largest = rightChild;
        }

        //Если самый большой элемент не корень
        if (largest != rootIndex) {
            temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;
        
            heapify(array, heapSize, largest);
        }
    }

    public static void sortHeap(int[] array)
    {   int temp;

        //Построение кучи
        for (int i=array.length/2-1; i>=0; i--) {
            heapify(array, array.length, i);
        }

        //Один за другим извлекаем элементы из кучи
        for (int i=array.length-1; i>=0; i--) {
            temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            //Выхываем процедуру heapify на уменьшенной куче
            heapify(array, i, 0);
        }
    }


    public static void main(String[] args) {
        Random rnd= new Random();
        int[] arr = new int[20];
        for (int i=0; i<20; i++) {
            arr[i] = rnd.nextInt(100);
        }

        System.out.println(Arrays.toString(arr));
        sortHeap(arr);
        System.out.println(Arrays.toString(arr));
    }
}