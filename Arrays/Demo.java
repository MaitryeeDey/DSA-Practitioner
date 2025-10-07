public class Demo {
    public static void helperSwap(int[] arr, int a, int b) {
        if (a == b) {
            return;
        }
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];

    }

    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    helperSwap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    public static void merge(int[] arr, int left, int right, int mid) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArray[i] = arr[i + mid + 1];
        }
        int i = 0;
        int j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] < rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }
        while (i < n1) {
            arr[k++] = leftArray[i++];

        }
        while (j < n2) {
            arr[k++] = rightArray[j++];
        }

    }

    public static int[] mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, end, mid);
        }
        return arr;
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                i++;
                helperSwap(arr, i, j);
            }
        }
        helperSwap(arr, i + 1, end);
        return i + 1;
    }

    public static int[] quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int p = partition(arr, start, end);
            quickSort(arr, start, p - 1);
            quickSort(arr, p + 1, end);
        }
        return arr;
    }

    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int current = arr[i];
            while (j >= 0 && current < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            helperSwap(arr, i, min);
        }
        return arr;
    }

    public static void printArray(String label, int[] arr) {
        System.out.print(label + ": ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = { 5, 25, 4, 7, 3, 2, -7, 1 };
        int[] arr2 = { 10, 3, 15, 7, 8, 23, 74, 18 };
        int[] arr3 = { 9, 5, 1, 4, 3 };
        int[] arr4 = { 6, 2, 8, 5, 1 };
        int[] arr5 = { 12, 11, 13, 5, 6 };

        printArray("Bubble Sort", bubbleSort(arr1));
        printArray("Merge Sort", mergeSort(arr2, 0, arr2.length - 1));
        printArray("Quick Sort", quickSort(arr3, 0, arr3.length - 1));
        printArray("Insertion Sort", insertionSort(arr4));
        printArray("Selection Sort", selectionSort(arr5));
    }
}