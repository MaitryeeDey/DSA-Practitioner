public class A6searchRotatedSortedArray {

    public int searchRotatedArray1(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[start] <= arr[mid]) {
                if (arr[start] <= target && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (arr[mid] < target && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public int searchRotatedArray2(int[] arr, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (target == arr[mid]) {
            return mid;
        }
        if (target < arr[mid]) {
            return searchRotatedArray2(arr, left, mid - 1, target);
        } else {
            return searchRotatedArray2(arr, mid + 1, right, target);
        }

    }

    public int findPivotInRotated(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            // if (arr[start] <= arr[mid]) {
            // start = mid + 1;
            // } else {
            // end = mid;
            // }
            if (arr[end] < arr[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 7, 8, 9 };
        A6searchRotatedSortedArray obj = new A6searchRotatedSortedArray();
        System.out.println(obj.searchRotatedArray1(arr, 8));
        System.out.println(obj.searchRotatedArray2(arr, 0, arr.length - 1, 8));
        int[] arr1 = { 4, 5, 6, 7, 1, 3 };
        System.out.println(obj.findPivotInRotated(arr1));
    }
}
