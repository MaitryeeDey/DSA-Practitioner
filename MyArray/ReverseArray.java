public class ReverseArray {

    int[] reverse(int[] arr) {
        int n = arr.length;

        int[] arr2 = new int[n];
        for (int i = 0; i < n / 2; i++) {
            int temp;
            temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;

            // System.out.println(arr[i]);
        }

        for (int k = 0; k < n; k++) {
            System.out.println(arr[k]);
        }

        return arr2;
    }

    public void reverse2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > -1; j--) {
                if (i < j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                }
            }
        }
        for (int k = 0; k < arr.length - 1; k++) {
            System.out.print("," + arr[k]);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 12, 34, 19, 7, 49, 16, 25 };
        ReverseArray obj = new ReverseArray();
        obj.reverse(arr);
        obj.reverse2(arr);
    }
}
