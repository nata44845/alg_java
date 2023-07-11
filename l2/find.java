public class find {
    public static int find(int[] array, int value){
        int len = array.length;
        for (int i=0; i< len; i++) {
            if (array[i] == value) {
                return i;
            }

        }
        return -1;
    }

    public static int binarySearch(int[] array, int value, int min, int max){
        if (max<min) return -1;
        int mid=(max-min)/2+min;
        if (array[mid]< value) return binarySearch(array, value, mid+1, max);
        else if (array[mid]> value) return binarySearch(array, value, min, mid-1);
        else return mid;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0,1,2,3,4,5,6,7,8,9};
        
        System.out.println(binarySearch(arr,11,0,arr.length-1));
    }
}
