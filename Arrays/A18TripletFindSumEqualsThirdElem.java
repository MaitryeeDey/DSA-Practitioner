import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A18TripletFindSumEqualsThirdElem {
    public static List<List<Integer>> findTriplet(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 2; i < arr.length; i++) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                int sum = arr[l] + arr[r];
                if (arr[i] == sum) {
                    result.add(new ArrayList<>(Arrays.asList(arr[l], arr[r], arr[i])));
                }
                if (sum < arr[i]) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 32, 1, 7, 10, 50, 19, 21, 2 };
        List<List<Integer>> triplets = findTriplet(arr);
        if (triplets.isEmpty()) {
            System.out.println("No triplets found where sum of two equals the third.");
        } else {
            System.out.println("Triplets where sum of two equals the third:");
            for (List<Integer> triplet : triplets) {
                System.out.println(triplet);
            }
        }
    }
}
