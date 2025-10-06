public class Sorting {

    // public int helper(int arr) {

    // }
    // }
    public int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] + arr[j + 1];
                    arr[j + 1] = arr[j] - arr[j + 1];
                    arr[j] = arr[j] - arr[j + 1];
                }
            }
        }
        return arr;
    }

    public int[] bubblesort(int arr[]){
        int n = arr.length;
        for(int i=0; i<n-1;i++){
            for(int j=i+1; j<n-i-1; j++){
                if(arr[j]>arr[j])
            }
        }
        return arr;
    }

    public int[] selectionSort(int[] arr) {
        int n = arr.length;
        int min = 0;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    min = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        for (int k = 0; k < arr.length; k++) {
            System.out.println(arr[k]);
        }
        return arr;
    }

    public static void main(String[] arhs) {
        int[] arr = { 56, 33, 123, 90, 83, 99, 9 };
        Sorting obj = new Sorting();
        obj.ssporting(arr);
        obj.selectionSort(arr);
        int[] arr2 = { 22, -9, 45, 21, 51, 39 };
        System.out.println("##############");
        for (int i : obj.bubbleSort(arr2)) {
            System.out.print(" " + i);
        }

    }

    public int[] ssporting(int[] arr) {
        int temp = 0;
        int n = arr.length;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println("ytr" + arr[j] + " " + j);
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }

}
