import java.util.Arrays;

public class A12ProductExceptSelf {
    public static int[] productExceptSelf(int[] arr) {
        int[] result = new int[arr.length];
        int totalProduct = 1;
        for (int a : arr) {
            totalProduct *= a;
        }
        for (int i = 0; i < arr.length; i++) {
            result[i] = totalProduct / arr[i];
        }
        return result;
    }

    public static int[] productExceptSelf2(int[] arr) {
        int[] result = new int[arr.length];
        int leftProduct = 1;
        int rightProduct = 1;
        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            while (j < arr.length) {
                rightProduct *= arr[j];
                j++;
            }
            rightProduct *= leftProduct;
            leftProduct *= arr[i];

            result[i] = rightProduct;
            rightProduct = 1;
        }
        return result;
    }

    public static int[] productExceptSelf3(int[] arr) {
        int[] prefProduct = new int[arr.length];
        int[] suffProduct = new int[arr.length];
        int result[] = new int[arr.length];
        prefProduct[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            prefProduct[i] = prefProduct[i - 1] * arr[i - 1];
        }
        suffProduct[arr.length - 1] = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            suffProduct[i] = suffProduct[i + 1] * arr[i + 1];
        }
        for (int i = 0; i < arr.length; i++) {
            result[i] = prefProduct[i] * suffProduct[i];
        }
        return result;
    }

    public static int[] productExceptSelf4(int[] arr) {
        int result[] = new int[arr.length];
        int zeros = 0;
        int product = 1;
        int zeroIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeros++;
                zeroIndex = i;
            } else {
                product *= arr[i];
            }
        }
        if (zeros == 0) {
            for (int i = 0; i < arr.length; i++) {
                result[i] = product / arr[i];
            }
        } else if (zeros > 1) {
            Arrays.fill(result, 0);
        } else {
            result[zeroIndex] = product;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        for (int a : productExceptSelf(arr)) {
            System.out.print(" " + a);
        }
        System.out.println("\n************************");
        for (int a : productExceptSelf2(arr)) {
            System.out.print(" " + a);
        }
        System.out.println("\n************************");
        for (int a : productExceptSelf3(arr)) {
            System.out.print(" " + a);
        }
        System.out.println("\n************************");
        for (int a : productExceptSelf4(arr)) {
            System.out.print(" " + a);
        }
    }
}
