public class A9RepeatingMissingNumber {
    public static void helperSwap(int[] arr, int a, int b) {
        if (a != b) {
            arr[a] = arr[a] + arr[b];
            arr[b] = arr[a] - arr[b];
            arr[a] = arr[a] - arr[b];
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int i = left - 1;
        int pivot = arr[right];
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                helperSwap(arr, i, j);
            }
        }
        helperSwap(arr, i + 1, right);
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

    public static int[] findRepeating_MissingNumber1(int[] arr) {
        int[] result = new int[2];
        int a = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                result[1] = arr[i];
            }
            if (arr[i + 1] - arr[i] > 1) {
                result[0] = (arr[i] + 1);
            }

        }
        return result;
    }

    public static int[] findRepeating_MissingNumber2(int[] arr) {
        int[] count = new int[arr.length];
        int[] result = new int[2];
        for (int a : arr) {
            count[a - 1]++;
        }
        for (int a = 0; a < count.length; a++) {
            if (count[a] == 0) {
                result[0] = a + 1;
            }
            if (count[a] > 1) {
                result[1] = a + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 5 };
        int[][] arr1 = { { 3, 4, 5 }, { 5, 1, 4 } };

        for (int a : findRepeating_MissingNumber1(arr)) {
            System.out.print(a + " ");
        }
        int[] count = new int[arr1.length * arr1[0].length];
        for (int a = 0; a < arr1.length; a++) {
            for (int b = 0; b < arr1[a].length; b++) {
                // System.out.println("d " + arr1[a][b]);
            }
        }
        for (int a : findRepeating_MissingNumber2(arr)) {
            System.out.print(a + " ");
        }
    }
}
