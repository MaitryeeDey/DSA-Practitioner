import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class A16SumofThreeequalsTarget {

    // Brute-force approach to find all triplets that sum to target
    public static void findThreeSumBrute(int[] arr, int targetSum) {
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == targetSum) {
                        System.out.println("Sum triplet: " + arr[i] + ", " + arr[j] + ", " + arr[k]);
                    }
                }
            }
        }
    }

    // Two-pointer approach after sorting
    public static List<List<Integer>> findThreeSumTwoPointers(int[] arr, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue; // Skip duplicates

            int remaining = targetSum - arr[i];
            int l = i + 1;
            int r = arr.length - 1;

            while (l < r) {
                int sum = arr[l] + arr[r];
                if (sum == remaining) {
                    result.add(Arrays.asList(arr[i], arr[l], arr[r]));
                    l++;
                    r--;
                    while (l < r && arr[l] == arr[l - 1])
                        l++; // Skip duplicates
                    while (l < r && arr[r] == arr[r + 1])
                        r--; // Skip duplicates
                } else if (sum < remaining) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return result;
    }

    // HashMap-based approach to find triplets with target sum
    public static List<List<Integer>> findThreeSumHashMap(int[] arr, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> seen = new HashSet<>();
        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                map.computeIfAbsent(sum, k -> new ArrayList<>()).add(new int[] { i, j });
            }

            for (int k = 0; k < arr.length; k++) {
                int rem = targetSum - arr[k];
                if (map.containsKey(rem)) {
                    for (int[] pair : map.get(rem)) {
                        if (pair[0] != k && pair[1] != k) {
                            List<Integer> triplet = Arrays.asList(arr[k], arr[pair[0]], arr[pair[1]]);
                            triplet.sort(null); // Normalize order
                            if (!seen.contains(triplet)) {
                                seen.add(triplet);
                                result.add(new ArrayList<>(triplet));
                            }
                        }
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, -3, 4, -1, 0, 5, -2, 3 };
        int targetSum = 3;

        System.out.println("Brute-force Triplets:");
        findThreeSumBrute(arr, targetSum);

        System.out.println("\nTwo-Pointer Triplets:");
        List<List<Integer>> twoPointerResults = findThreeSumTwoPointers(arr, targetSum);
        for (List<Integer> triplet : twoPointerResults) {
            System.out.println(triplet);
        }

        System.out.println("\nHashMap-based Triplets:");
        List<List<Integer>> hashMapResults = findThreeSumHashMap(arr, targetSum);
        for (List<Integer> triplet : hashMapResults) {
            System.out.println(triplet);
        }
    }
}