public class A22minMergeRequiredForPalindromeArray {
    public static int minMergeToMalePalindrome(int[] arr) {
        int mergeCount = 0;
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            if (arr[l] == arr[r]) {
                l++;
                r--;

            }
            else if (arr[l] < arr[r]) {
                arr[l + 1] = arr[l] + arr[l + 1];
                mergeCount++;
                l++;

            } else {
                arr[r - 1] = arr[r] + arr[r - 1];
                mergeCount++;
                r--;

            }
        }
        return mergeCount;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 5, 2, 2, 5, 1 };
        System.out.println(minMergeToMalePalindrome(arr));
    }
}
