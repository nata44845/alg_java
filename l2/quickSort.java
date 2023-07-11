import java.util.Arrays;

public class quickSort {

    public static int[] sort(int[] array, int left, int right){
        int i = left;
        int j = right;
        int pivot = array[(left+right)/2];
        do {
            while (array[i] < pivot) i++;
            while (array[j] > pivot) j--;
            if (i <= j)
            {
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
                i++;
                j--;
            }
        }
        while (i<j);
        if (i < right) sort(array, i, right);
        if (left < j) sort(array, left, j);
        return array;
    }

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
        System.out.println(Arrays.toString(array));

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
        int[] arr = new int[] {9,0,3,6,7,3,7,8,2};
        sortHeap(arr);
        System.out.println(Arrays.toString(arr));
    }
    
}
