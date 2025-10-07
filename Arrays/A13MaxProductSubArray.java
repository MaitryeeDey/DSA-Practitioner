public class A13MaxProductSubArray {
    public static int maxProductSubarray1(int[] arr) {
        int maxProduct = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int product = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                product *= arr[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }

    public static int maxProductSubarray2(int[] arr) {
        int maxProduct = arr[0];
        int minProductEndingHere = 1;
        int maxProductEndingHere = 1;
        for (int a : arr) {
            int temp = maxProductEndingHere;
            maxProductEndingHere = Math.max(a, Math.max(maxProductEndingHere * a, minProductEndingHere * a));
            minProductEndingHere = Math.min(a, Math.min(minProductEndingHere * a, temp * a));
            maxProduct = Math.max(maxProduct, maxProductEndingHere);
        }
        return maxProduct;
    }

    public static int maxProductSubarray3(int[] arr) {
        int l2r = 1;
        int r2l = 1;
        int maxProduct = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (l2r == 0) {
                l2r = 1;
            }
            if (r2l == 0) {
                r2l = 1;
            }
            l2r *= arr[i];
            r2l *= arr[arr.length - 1 - i];
            maxProduct = Math.max(maxProduct, Math.max(l2r, r2l));
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        int[] arr = { -2, 6, -3, -10, 0, 2 };
        System.out.println(maxProductSubarray1(arr));
        System.out.println(maxProductSubarray2(arr));
        System.out.println(maxProductSubarray3(arr));
    }
}