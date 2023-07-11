import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * task1
 */
public class task1 {
    final static int[] buf = new int[100000];
    //Делим пополам и сортируем другим алгоритмом, дальше опять делим пополам, потом сливаем назад

    public static void MergeSort(int[] array){
        MergeSort(array, 0, array.length-1);
    }

    static private void MergeSort(int[] array, int left, int right) {
        if (left>=right) return;
        int mid = (left + right)/2;
        MergeSort(array,left,mid);
        MergeSort(array,mid+1,right);
        //Слияние
        int i = left;
        int j = mid + 1; 
        int k = left;
        while (i <= mid && j<=right) {
            if (array[i]<array[j]) {
                buf[k] = array[i];
                i++;
            } else {
                buf[k] = array[j];
                j++;
            }
            k++;
        }

        while (i <= mid) buf[k++] = array[i++];
        while (j<=right) buf[k++] = array[j++];
        for (k=left; k<= right; k++) array[k] = buf[k];
    }


    //Шейкерная сортировка
    //Один проход туда, другой назад, проходов N/2
    static public void ShakeSort(int[] array) {
        for (int i=0; i<array.length/2; i++) {
            for (int j = i; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp; 
                }
            }
            for (int j = array.length - i - 1; j > i; j--) {
                if (array[j-1] > array[j]) {
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp; 
                }
            }
        }
    }

    public static Integer BinarySearch(int[] Array, int value){
        int left = 0, right = Array.length - 1;
        while(right - left > 1){ // abs(right-left) > eps (1e-9)
            int mid = (left + right) / 2;
            if(Array[mid] > value){
                right = mid;
            }else{
                left = mid;
            }
        }
        if(Array[left] == value)
            return left;
        if(Array[right] == value)
            return right;
        return null;
    }

    public static void main(String[] args) {
        int n=100_000;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        Random rnd = new Random();
        for (int i=0; i<n; i++) {
            arr1[i] = rnd.nextInt(10000);
            arr2[i]=arr1[i];
        }
    
        //System.out.println(Arrays.toString(arr1));
        Date start = new Date();
        //ShakeSort(arr1);
        Date end = new Date();
        long time1 =end.getTime()-start.getTime();
        System.out.println(time1);

        start = new Date();
        MergeSort(arr2);
        end = new Date();
        long time2 =end.getTime()-start.getTime();
        System.out.println(time2);

        //System.out.println(Arrays.toString(arr1));
        //System.out.println(Arrays.toString(arr2));
        System.out.println(BinarySearch(arr2, 5000));

    }
}