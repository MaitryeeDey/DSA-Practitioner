public class Sorting {
    public void helperSwap(int[] arr, int a, int b) {
        if (a == b) {
            return;
        }
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];

    }

    public int[] loopingSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    helperSwap(arr, j, i);
                }
            }
        }
        return arr;
    }

    public int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    helperSwap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    public int[] selectionSort(int[] arr) {
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

    public int[] insertionSort(int[] arr) {
        // Best case: O(n), If the list is already sorted, where n is the number of
        // elements in the list.
        // Average case: O(n2), If the list is randomly ordered
        // Worst case: O(n2), If the list is in reverse order
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && current < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
        return arr;
    }

    public void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] l = new int[n1];
        int[] r = new int[n2];

        for (int i = 0; i < n1; i++) {
            l[i] = arr[left + i];
        }

        for (int i = 0; i < n2; i++) {
            r[i] = arr[mid + 1 + i];
        }
        int iteratorLeft = 0, iteratorRight = 0;
        int iteratorMain = left;
        while (iteratorLeft < n1 && iteratorRight < n2) {
            if (l[iteratorLeft] < r[iteratorRight]) {
                arr[iteratorMain++] = l[iteratorLeft++];

            } else {
                arr[iteratorMain++] = r[iteratorRight++];
            }

        }
        while (iteratorLeft < n1) {
            arr[iteratorMain++] = l[iteratorLeft++];

        }
        while (iteratorRight < n2) {
            arr[iteratorMain++] = r[iteratorRight++];

        }
    }

    public int[] mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
        return arr;
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                helperSwap(arr, i, j);
            }
        }
        helperSwap(arr, i + 1, high);
        return i + 1;
    }

    public int[] quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
        return arr;
    }

    public static void main(String[] args) {
        Sorting obj = new Sorting();
        int[] arr = { 4, 5, 2, 9, 6, 1, 3, 8 };
        for (int a : obj.loopingSort(arr)) {
            System.out.print(a + " ");
        }
        System.out.println("\n***************************");
        int[] arr1 = { 4, 5, 2, -9, 6, -1, 3, 8 };
        for (int a : obj.bubbleSort(arr1)) {
            System.out.print(a + " ");
        }
        System.out.println("\n***************************");
        int[] arr2 = { 8, 4, 22, 1, 7, -5, 2, -3 };
        for (int a : obj.selectionSort(arr2)) {
            System.out.print(a + " ");
        }
        System.out.println("\n***************************");
        int[] arr3 = { 4, -4, 10, 7, 5, 2, -3 };
        for (int a : obj.insertionSort(arr3)) {
            System.out.print(a + " ");
        }
        System.out.println("\n***************************");
        int[] arr4 = { 3, -8, 2, -3, 4, 9, 6 };
        for (int a : obj.mergeSort(arr4, 0, arr4.length - 1)) {
            System.out.print(a + " ");
        }
        System.out.println("\n***************************");
        int[] arr5 = { 4, 9, 6, 2, 5 };
        for (int a : obj.quickSort(arr5, 0, arr5.length - 1)) {
            System.out.print(a + " ");
        }
    }
}
