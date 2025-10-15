import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class A23ArrangeFormingLargestNumber {

    /**
     * Method 1: Using ArrayList and Collections.sort with a custom comparator.
     * Converts int[] to List<Integer>, sorts based on concatenation logic,
     * and builds the largest number as a string.
     */
    public static String arrangeUsingArrayListSort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                String s1 = a + "" + b;
                String s2 = b + "" + a;
                return s2.compareTo(s1); // Sort to form largest number
            }
        });

        StringBuilder result = new StringBuilder();
        list.forEach(result::append);
        return result.toString();
    }

    /**
     * Method 2: Using String array and Arrays.sort with lambda comparator.
     * Converts int[] to String[], sorts based on concatenation logic,
     * and handles edge case where all numbers are zero.
     */
    public static String arrangeUsingStringSort(int[] arr) {
        String[] strArray = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            strArray[i] = String.valueOf(arr[i]);
        }

        Arrays.sort(strArray, (a, b) -> (b + a).compareTo(a + b));

        if (strArray[0].equals("0")) {
            return "0"; // Edge case: all zeros
        }

        StringBuilder result = new StringBuilder();
        for (String s : strArray) {
            result.append(s);
        }
        return result.toString();
    }

    /**
     * Helper method: Custom comparator for quicksort.
     * Compares two integers based on concatenated string values.
     */
    public static int compare(int a, int b) {
        return (Integer.toString(b) + Integer.toString(a))
                .compareTo(Integer.toString(a) + Integer.toString(b));
    }

    /**
     * Helper method: Swaps two elements in an array.
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }

    /**
     * Helper method: Partition logic for quicksort using custom comparator.
     */
    public static int partition(int[] arr, int low, int high) {
        int i = low - 1;
        int pivot = arr[high];
        for (int j = low; j < high; j++) {
            if (compare(pivot, arr[j]) > 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    /**
     * Helper method: Custom quicksort implementation using compare logic.
     */
    public static int[] quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
        return arr;
    }

    /**
     * Method 3: Using custom quicksort to sort int[] based on concatenation logic.
     * Builds the largest number as a string after sorting.
     */
    public static String arrangeUsingCustomQuickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);

        StringBuilder str = new StringBuilder();
        for (int a : arr) {
            str.append(a);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        // int[] arr = { 3, 30, 34, 5, 9 };
        int[] arr = { 2, 21, 20, 9, 3, 24 };
        System.out.println("Using ArrayList + Collections.sort: " + arrangeUsingArrayListSort(arr));
        System.out.println("Using String[] + Arrays.sort: " + arrangeUsingStringSort(arr));
        System.out.println("Using Custom QuickSort: " + arrangeUsingCustomQuickSort(arr));
    }
}