import java.util.*;

class traceSorting {
    public static void main(String[] args) {
        int[] arr = new int[] {6, 3, 11, 4, 9, 8, 17, 7};

        int[] inser = quickSort(arr);
        print(inser);
    }
    public static int[] quickSort(int[] arr){

        if(arr.length <= 1) return arr;

        int low = 0;
        int high = arr.length - 1;
        int center = high % 2 == 0 ? high/2 : (high-1)/2;
        for(int i = 0; i < center; i++){
            if(arr[low] < arr[i]){
                int temp = arr[center];
                arr[center] = arr[low];
                arr[low] = temp;
                low++;
            }
            if(arr[high] < arr[center] ){
                int temp = arr[center];
                arr[center] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
        if(arr[low] > arr[high]){
            for(int i = 0 ; i < arr.length/2;i++){
                int temp = arr[center + i];
                arr[center + i] = arr[i];
                arr[i] = temp;
            }
        }

        return arr;
    }
    public static int[] selectionSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int smallest = i;
            for(int j = i ; j < arr.length ; j++){
                if( arr[j] < arr[smallest]){
                    smallest = j;
                }
            }
            System.out.println("Selected " + arr[smallest] + " for index "+ i);
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
    public static int[] insertionSort(int[] arr){
        int swapCounter = 0;
        for(int i = 1; i < arr.length; i++){
            if(i == 0) continue;

            if(arr[i] < arr[i-1]){
                swapCounter ++;
                System.out.println(swapCounter+"");
                System.out.println("Swapping " + arr[i] + " with " + arr[i-1] );

                int temp = arr[i-1];
                arr[i-1] = arr[i];
                arr[i] = temp;
                i-=2;
            }
        }
        return arr;
    }
    public static void print(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length - 1]);
    }
}