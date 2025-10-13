import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A16SumOfThreeClosestToTarget {
    public static List<Integer> tripletSumClosestToTarget1(int[] arr, int targetSum) {
        List<Integer> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        int res = arr[0] + arr[1] + arr[2];
        int[] triplet = new int[3];
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    int currSum = arr[i] + arr[j] + arr[k];
                    int currDiff = Math.abs(targetSum - currSum);
                    if (currDiff < minDiff) {
                        minDiff = currDiff;
                        res = currSum;
                        triplet[0] = arr[i];
                        triplet[1] = arr[j];
                        triplet[2] = arr[k];
                    } else if (currDiff == minDiff) {
                        if (currSum > res) {
                            triplet[0] = arr[i];
                            triplet[1] = arr[j];
                            triplet[2] = arr[k];
                        }
                        res = Math.max(currSum, res);
                    }
                }
            }
        }
        result.addAll(Arrays.asList(triplet[0], triplet[1], triplet[2]));
        return result;
    }

    public static List<Integer> tripletSumClosestToTarget2(int[] arr, int targetSum) {
        List<Integer> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        int res = arr[0] + arr[1] + arr[2];
        for (int i = 0; i < arr.length - 2; i++) {
            int l = i + 1;
            int r = arr.length - 1;
            Arrays.sort(arr);
            while (l < r) {
                int currentSum = arr[i] + arr[l] + arr[r];
                int currDif = Math.abs(targetSum - currentSum);
                if (currDif < minDiff) {
                    minDiff = currDif;
                    result.clear();
                    result.add(arr[i]);
                    result.add(arr[l]);
                    result.add(arr[r]);
                } else if (currDif == minDiff) {
                    if (res < currentSum) {
                        result.clear();
                        result.add(arr[i]);
                        result.add(arr[l]);
                        result.add(arr[r]);
                    }

                }
                if (currentSum > targetSum) {
                    r--;
                } else {
                    l++;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 2, 1, -4, 5, 3 };
        int targetSum = 6;

        List<Integer> closestTriplet = tripletSumClosestToTarget1(nums, targetSum);

        System.out.println("Triplet with sum closest to " + targetSum + ": " + closestTriplet);
        List<Integer> closestTriplet2 = tripletSumClosestToTarget2(nums, targetSum);

        System.out.println("Triplet with sum closest to " + targetSum + ": " + closestTriplet2);
    }
}
