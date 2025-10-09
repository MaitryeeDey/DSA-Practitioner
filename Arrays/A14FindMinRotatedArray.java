public class A14FindMinRotatedArray {
    public static int findMinRotatedSortedArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            if (arr[start] <= arr[end]) {
                return arr[start];
            }
            int mid = start + (end - start) / 2;
            if (arr[start] <= arr[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return arr[start];
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 8, 1, 2, 3 };
        System.out.println("Minimum in rotated sorted array is " + findMinRotatedSortedArray(arr));
    }
}
