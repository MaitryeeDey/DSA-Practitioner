public class A3MaxSubArray {
    public int maxSubarray1(int[] arr) {
        int sum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int sm = 0;
            for (int j = i; j < arr.length; j++) {
                sm += arr[j];
                if (sum < sm) {
                    sum = sm;
                }
            }
        }
        return sum;
    }

    public int maxSubarray2(int[] arr) {
        int maxSum = arr[0];
        int currentsum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currentsum += arr[i];
            if (currentsum < 0) {
                currentsum = 0;
            }
            if (currentsum > maxSum) {
                maxSum = currentsum;
            }
        }
        return maxSum;
    }

    public int maxSubarray3(int[] arr) {
        int maxSum = arr[0];
        int maxSumEndingHere = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxSumEndingHere = Math.max(arr[i], maxSumEndingHere + arr[i]);
            maxSum = Math.max(maxSum, maxSumEndingHere);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        // int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int[] arr = { 5, 4, -1, 7, 8 };
        A3MaxSubArray obj = new A3MaxSubArray();
        System.out.println(obj.maxSubarray1(arr));
        System.out.println("************************");
        System.out.println(obj.maxSubarray2(arr));
        System.out.println("************************");
        System.out.println(obj.maxSubarray3(arr));
        System.out.println("************************");
    }
}
