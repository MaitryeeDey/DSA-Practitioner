import java.util.*;

public class A17PythagoreanTriplet {

    // Brute-force method to find Pythagorean triplets
    public static List<List<Integer>> findPythagoreanTriplet1(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    int x = arr[i] * arr[i];
                    int y = arr[j] * arr[j];
                    int z = arr[k] * arr[k];
                    if (x == y + z || y == x + z || z == x + y) {
                        result.add(new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k])));
                    }
                }
            }
        }
        return result;
    }

    // two pointers
    public static List<List<Integer>> findPythagoreanTriplet2(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = arr.length - 1; i > 1; i--) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                int x = arr[l] * arr[l];
                int y = arr[r] * arr[r];
                int z = arr[i] * arr[i];
                if (x + y == z) {
                    result.add(new ArrayList<>(Arrays.asList(arr[l], arr[r], arr[i])));
                    l++;
                    r--;
                } else if (x + y < z) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }

    // Alternative Pythagorean triplet method using precomputed squares
    public static List<List<Integer>> findPythagorean(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int[] squares = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            squares[i] = arr[i] * arr[i];
        }
        Arrays.sort(arr);
        for (int i = arr.length - 1; i > 1; i--) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                if (squares[l] + squares[r] == squares[i]) {
                    result.add(new ArrayList<>(Arrays.asList(arr[l], arr[r], arr[i])));
                    l++;
                    r--;
                } else if (squares[l] + squares[r] < squares[i]) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = { 3, 1, 4, 6, 5, 8, 10 };

        List<List<Integer>> triplets = findPythagoreanTriplet1(nums);
        System.out.println("Pythagorean Triplets (Brute Force):");
        for (List<Integer> triplet : triplets) {
            System.out.println(triplet);
        }

        System.out.println("*********************");

        List<List<Integer>> triplets2 = findPythagoreanTriplet2(nums);
        System.out.println("Pythagorean Triplets (Optimized):");
        for (List<Integer> triplet : triplets2) {
            System.out.println(triplet);
        }

        System.out.println("*********************");

        List<List<Integer>> triplets3 = findPythagorean(nums);
        System.out.println("Pythagorean Triplets (Using Squares):");
        for (List<Integer> triplet : triplets3) {
            System.out.println(triplet);
        }
    }
}