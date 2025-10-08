
public class A7nextPermutation {
    public static void helperSwap(int[] arr, int a, int b) {
        if (a == b) {
            return;
        }
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];

    }

    public static int[] nextPermutation(int[] arr) {

        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = arr.length - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }
            helperSwap(arr, i, j);
        }
        int start = i + 1;
        int end = arr.length - 1;
        while (start < end) {
            helperSwap(arr, start++, end--);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 3, 1, 4, 2 };
        // int[] arr = { 2, 3, 1 };
        for (int a : nextPermutation(arr)) {
            System.out.print(a + " ");
        }
    }
}