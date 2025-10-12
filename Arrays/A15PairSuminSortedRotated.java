import java.util.HashSet;

public class A15PairSuminSortedRotated {
    public static boolean checkPairSuminSortedRotatedArray1(int[] arr, int targetSum) {
        HashSet<Integer> hset = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            int num = targetSum - arr[i];
            if (hset.contains(num)) {
                return true;
            }
            hset.add(arr[i]);
        }
        return false;
    }

    public static boolean checkPairSuminSortedRotatedArray2(int[] arr, int targetSum) {
        int i = 0;
        for (i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                break;
            }
        }

        int left = i + 1;
        int right = i;
        while (left != right) {
            if (arr[left] + arr[right] == targetSum) {
                return true;
            }
            if (arr[left] + arr[right] < targetSum) {
                left = (left + 1 + arr.length) % arr.length;
            } else {
                right = (right - 1 + arr.length) % arr.length;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 11, 15, 6, 8, 9, 10 };
        int target = 16;
        System.out.println(checkPairSuminSortedRotatedArray1(arr, target));
        System.out.println(checkPairSuminSortedRotatedArray2(arr, target));
    }
}