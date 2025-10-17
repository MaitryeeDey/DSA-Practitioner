public class A24SpaceOptimizationBitManipulation {

    public static void printDivisibleNumbers(int start, int end) {
        int size = Math.abs(end - start + 1);
        boolean[] bCheck = new boolean[size];

        for (int i = start; i <= end; i++) {
            if (i % 2 == 0 || i % 5 == 0) {
                bCheck[i - start] = true;
            }
        }

        for (int i = start; i <= end; i++) {
            if (bCheck[i - start]) {
                System.out.println(i);
            }
        }
    }

    public static void setBit(int[] arr, int index) {
        arr[index >> 5] = arr[index >> 5] | (1 << (index & 31));
        // index>>5 means index/32
        // index&32 means index%32
    }

    public static boolean checkBit(int[] arr, int index) {
        int value = (arr[index >> 5]) & (1 << (index & 31));
        return value != 0;
    }

    public static void printDivisibleNumbersbyBitManipulation(int start, int end) {
        int size = (int) Math.ceil((double) (end - start) / 32);
        int[] arr = new int[size];
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0 || i % 5 == 0) {
                setBit(arr, i - start);
            }
        }

        for (int i = start; i <= end; i++) {
            if (checkBit(arr, i - start)) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 10;

        printDivisibleNumbers(a, b);
        printDivisibleNumbersbyBitManipulation(a, b);
    }
}