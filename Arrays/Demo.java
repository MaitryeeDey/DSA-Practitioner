public class Demo {

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

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
                helperSwap(arr, min, i);
            }
        }
        return arr;
    }

    public static int[] insertionSort(int[] arr) {
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

    private static void merge(int[] arr, int left, int mid, int right) {
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
        int i = 0;
        int j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (l[i] < r[j]) {
                arr[k++] = l[i++];
            } else {
                arr[k++] = r[j++];
            }
        }
        while (i < n1) {
            arr[k++] = l[i++];

        }
        while (j < n2) {
            arr[k++] = r[j++];

        }
    }

    public static int[] mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
        return arr;
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = right;
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < arr[pivot]) {
                i++;
                helperSwap(arr, i, j);
            }
        }
        helperSwap(arr, i + 1, pivot);
        return i + 1;
    }

    public static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int p = partition(arr, left, right);
            quickSort(arr, left, p - 1);
            quickSort(arr, p + 1, right);
        }
        return arr;
    }

    private static void helperSwap(int[] arr, int i, int j) {
        if (j != i) {
            arr[i] = arr[i] + arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] = arr[i] - arr[j];

        }
    }

    public static int findPivotinRotatedArray(int[] arr, int start, int end) {

        if (start == end || arr[start] <= arr[end]) {
            return start;
        }
        if (start == end - 1) {
            return arr[start] < arr[end] ? start : end;
        }

        int mid = start + (end - start) / 2;
        if (arr[start] <= arr[mid]) {
            return findPivotinRotatedArray(arr, mid + 1, end);
        } else {
            return findPivotinRotatedArray(arr, start, mid);
        }

    }

    public static int findPivotInRotated2(int[] arr, int start, int end) {

        if (arr[start] <= arr[end]) {
            return start;
        }
        while (start < end) {

            int mid = start + (end - start) / 2;
            if (arr[start] < arr[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static int findInRotatedArray(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                return mid;
            }
            if (arr[start] <= arr[mid]) {
                if (target < arr[mid] && target >= arr[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid] && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;

                }
            }
        }
        return -1;
    }

    public static int searchRotated(int[] arr, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (target < arr[mid]) {
            return searchRotated(arr, start, mid - 1, target);
        } else {
            return searchRotated(arr, mid + 1, end, target);
        }
    }

    public static void main(String[] args) {

        int[] arr = { 6, 3, 5, 2, -3, 9, -7 };
        for (int a : quickSort(arr, 0, arr.length - 1)) {
            System.out.print(" " + a);
        }
        // for (int a : mergeSort(arr, 0, arr.length - 1)) {
        // System.out.print(" " + a);
        // }
        // for (int a : insertionSort(arr)) {
        // System.out.print(" " + a);
        // }
        // for (int a : selectionSort(arr)) {
        // System.out.print(" " + a);
        // }
        // for (int a : bubbleSort(arr)) {
        // System.out.print(" " + a);
        // }
        int[] arr1 = { 5, 6, 7, 8, 9, 12, 2, 3 };
        System.out.println("Pivot is " + findPivotinRotatedArray(arr1, 0, arr1.length - 1));
        System.out.println("Pivot is " + findPivotInRotated2(arr1, 0, arr1.length - 1));
        System.out.println("index is " + findInRotatedArray(arr1, 0, arr1.length - 1, 6));
        System.out.println("index is " + searchRotated(arr1, 0, arr1.length - 1, 9));
    }
}
