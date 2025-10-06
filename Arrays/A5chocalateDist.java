import java.util.Arrays;

public class A5chocalateDist {

    public int[] merge(int[] arr, int left, int mid, int right) {

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
                arr[k] = l[i];
                i++;
            } else {
                arr[k] = r[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = l[i];
            k++;
            i++;
        }
        while (i < n2) {
            arr[k] = r[j];
            k++;
            j++;
        }
        return arr;
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

    public int findMinDiff(int[] arr, int m) {
        // Arrays.sort(arr);
        mergeSort(arr, 0, arr.length - 1);
        int minDiff = arr[arr.length - 1];
        int i = 0;
        while (i < arr.length - m) {
            minDiff = Math.min(minDiff, arr[i + m - 1] - arr[i]);

            i++;
        }
        return minDiff;
    }

    public static void main(String[] args) {
        int[] arr = { 7, 3, 2, 4, 9, 12, 56 };
        int students = 3;
        A5chocalateDist obj = new A5chocalateDist();
        System.out.println(obj.findMinDiff(arr, students));
        students = 5;
        System.out.println(obj.findMinDiff(arr, students));
    }
}
