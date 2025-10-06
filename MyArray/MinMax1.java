
import java.util.*;

public class MinMax1 {

    public int[] findMinMax1(int[] arr) {
        Arrays.sort(arr);
        return (new int[] { arr[0], arr[arr.length - 1] });
    }

    int[] findMinMax2(int myarr[]) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : myarr) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        return new int[] { min, max };
    }

    public static void main(String[] args) {
        System.out.println("hello");
        int[] arr = { 12, 9, 7, 0, 22, 13 };
        // int min = Integer.MAX_VALUE;
        // int max = Integer.MIN_VALUE;
        // for (int i = 1; i < arr.length; i++) {

        // if (min > arr[i]) {
        // min = arr[i];
        // } else if (max < arr[i]) {
        // max = arr[i];

        // }

        // }
        // System.out.println("min value " + min);
        // System.out.println("max value " + max);
        MinMax1 obj = new MinMax1();
        int[] result = obj.findMinMax1(arr);
        int[] result2 = obj.findMinMax2(arr);
        System.out.println("min value " + result[0]);
        System.out.println("Max value " + result[1]);
        System.out.println("min value2 " + result2[0]);
        System.out.println("Max value2 " + result2[1]);

    }

}
