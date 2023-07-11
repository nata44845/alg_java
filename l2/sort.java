import java.util.Arrays;

/**
 * sort
 */
public class sort {

    public static void bubbleSort(int[] array){
        int len=array.length;
        int temp;
        boolean finish;
        do {
            finish = true;
            for(int i=0; i<len-1; i++){
                if (array[i]>array[i+1])
                {
                    temp = array[i+1];
                    array[i+1] = array[i];
                    array[i] = temp;
                    finish = false;
                }
            }
        }
        while (!finish);
    }

    public static void directSort(int[] array){
        int len=array.length;
        int temp;
        int min;
        for(int i=0; i<len-1; i++){
            min = i;
            for(int j=i+1; j<len; j++){
                if (array[j] < array[min]){ 
                    min = j;

                }
            }
            if (i!=min)    
            {
                temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }

    public static void insertSort(int[] array){
        int len=array.length;
        int temp;
        int min;
        for(int i=0; i<len-1; i++){
            for(int j=i+1; j<len; j++){
                if (array[i] > array[j]){ 
                        temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {9,0,3,6,7,3,7,8,2};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}