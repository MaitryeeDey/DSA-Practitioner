import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class A2ReverseArray {
    public int[] reverseArray1(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            arr[i] = arr[i] + arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = arr[i] - arr[arr.length - 1 - i];
            arr[i] = arr[i] - arr[arr.length - 1 - i];

        }
        return arr;
    }

    public int[] reverseArray2(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            arr[left] = arr[left] + arr[right];
            arr[right] = arr[left] - arr[right];
            arr[left] = arr[left] - arr[right];
            left++;
            right--;
        }
        return arr;
    }

    public int[] reverseArray3(int[] arr) {
        List<Integer> li = new ArrayList<>();
        for (int a : arr) {
            li.add(a);
        }
        Collections.reverse(li);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = li.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] myArray = { 1, 2, 3, 4, 5, 6, 7 };
        A2ReverseArray obj = new A2ReverseArray();
        for (int a : obj.reverseArray1(myArray)) {
            System.out.print(a + ", ");
        }
        System.out.println("\n*********************************");
        for (int a : obj.reverseArray2(myArray)) {
            System.out.print(a + ", ");
        }
        System.out.println("\n*********************************");
        for (int a : obj.reverseArray3(myArray)) {
            System.out.print(a + ", ");
        }
        System.out.println("\n*********************************");
    }
}