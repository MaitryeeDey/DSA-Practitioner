import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class A4DuplicateArray {
    public boolean checkDuplicate1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public int partition(int[] arr, int l, int r) {
        int i = l - 1;
        int pivot = arr[r];
        for (int j = l; j < r; j++) {
            if (arr[j] < pivot) {
                if (j != i + 1) {
                    arr[j] = arr[j] + arr[i + 1];
                    arr[i + 1] = arr[j] - arr[i + 1];
                    arr[j] = arr[j] - arr[i + 1];
                    i++;
                }
            }
        }
        if (r != i) {
            arr[r] = arr[r] + arr[i + 1];
            arr[i + 1] = arr[r] - arr[i + 1];
            arr[r] = arr[r] - arr[i + 1];
        }
        return i + 1;
    }

    public int[] quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int p = partition(arr, l, r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }
        return arr;
    }

    public boolean checkDuplicate2(int[] arr) {
        arr = quickSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDuplicate3(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int a : arr) {
            if (set.contains(a)) {
                return true;
            } else {
                set.add(a);
            }
        }
        return false;
    }

    public boolean checkDuplicate4(int[] arr) {
        HashMap<Integer, Integer> hMap = new HashMap<>();
        for (int a : arr) {
            // if (hMap.containsKey(a) && hMap.get(a) > 1) {
            if (hMap.containsKey(a)) {
                return true;
            }
            hMap.put(a, hMap.getOrDefault(a, 0) + 1);
        }
        return false;
    }

    public boolean checkDuplicate5(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int current = arr[i];
            while (j >= 0 && arr[j] >= current) {
                if (arr[j] == current) {
                    return true;
                }
                arr[j + 1] = arr[j];
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        A4DuplicateArray obj = new A4DuplicateArray();
        int[] arr = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };

        System.out.println("\n************************");
        System.out.printf("Has Duplicate: %s", obj.checkDuplicate1(arr));
        System.out.println("\n************************");
        System.out.printf("Has Duplicate: %s", obj.checkDuplicate2(arr));
        System.out.println("\n************************");
        System.out.printf("Has Duplicate: %s", obj.checkDuplicate3(arr));
        System.out.println("\n************************");
        System.out.printf("Has Duplicate: %s", obj.checkDuplicate4(arr));
        System.out.println("\n************************");
        System.out.printf("Has Duplicate: %s", obj.checkDuplicate5(arr));

    }
}
