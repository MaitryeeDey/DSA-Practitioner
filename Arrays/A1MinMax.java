import java.util.Arrays;
import java.util.PriorityQueue;

class Pair {
    int min = 0;
    int max = 0;

    Pair() {

    }

    Pair(int min, int max) {
        this.min = min;
        this.max = max;
    }

    void display() {
        System.out.println("Minimum : " + min);
        System.out.println("Maximum : " + max);
    }
}

public class A1MinMax {

    // Approach 1: Sort the array and pick first and last elements
    public Pair findMinMax1(int[] arr) {
        Arrays.sort(arr); // Sorts the array in ascending order
        // First element is minimum, last element is maximum
        return new Pair(arr[0], arr[arr.length - 1]);
    }

    // Approach 2: Traverse the array once and update min and max
    public Pair findMinMax2(int[] arr) {
        int Max = Integer.MIN_VALUE; // Start with smallest possible value
        int Min = Integer.MAX_VALUE; // Start with largest possible value

        // Loop through each element
        for (int num : arr) {
            Max = Math.max(num, Max); // Update max if current number is greater
            Min = Math.min(num, Min); // Update min if current number is smaller
        }

        return new Pair(Min, Max);
    }

    // Approach 3: Compare first two elements, then loop through rest
    public Pair findMinMax3(int[] arr) {
        int min;
        int max;

        // If array has only one element, it's both min and max
        if (arr.length == 1) {
            return new Pair(arr[0], arr[0]);
        }

        // Compare first two elements to initialize min and max
        if (arr[0] < arr[1]) {
            min = arr[0];
            max = arr[1];
        } else {
            max = arr[0];
            min = arr[1];
        }

        // Loop through remaining elements
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i]; // Update min
            } else if (arr[i] > max) {
                max = arr[i]; // Update max
            }
        }

        return new Pair(min, max);
    }

    // Approach 4: Recursive divide-and-conquer method
    public Pair findMinMax4(int[] arr, int start, int end) {
        Pair minmax = new Pair(); // Final result
        Pair mmLeft = new Pair(); // Left half result
        Pair mmRight = new Pair(); // Right half result
        int mid;

        // Base case: only one element
        if (start == end) {
            minmax.min = arr[start];
            minmax.max = arr[end];
            return minmax;
        }

        // Base case: two elements
        if (start == end - 1) {
            if (arr[start] < arr[end]) {
                minmax.min = arr[start];
                minmax.max = arr[end];
            } else {
                minmax.min = arr[end];
                minmax.max = arr[start];
            }
            return minmax;
        }

        // Recursive case: divide array into halves
        mid = (start + end) / 2;
        mmLeft = findMinMax4(arr, start, mid); // Left half
        mmRight = findMinMax4(arr, mid + 1, end); // Right half

        // Combine results from both halves
        minmax.min = Math.min(mmLeft.min, mmRight.min);
        minmax.max = Math.max(mmLeft.max, mmRight.max);

        return new Pair(minmax.min, minmax.max);
    }

    // Approach 5: Compare elements in pairs to reduce comparisons
    public Pair findMinMax5(int[] arr) {
        Pair minmax = new Pair();

        // Initialize min and max based on first one or two elements
        if (arr.length % 2 == 0) {
            if (arr[0] < arr[1]) {
                minmax.min = arr[0];
                minmax.max = arr[1];
            } else {
                minmax.min = arr[1];
                minmax.max = arr[0];
            }
        } else {
            minmax.min = arr[0];
            minmax.max = arr[0];
        }

        // Start comparing in pairs from index 2
        int i = 2;
        while (i < arr.length - 1) {
            if (arr[i] < arr[i + 1]) {
                // Compare smaller with min, larger with max
                if (arr[i] < minmax.min) {
                    minmax.min = arr[i];
                }
                if (arr[i + 1] > minmax.max) {
                    minmax.max = arr[i + 1];
                }
            } else {
                if (arr[i + 1] < minmax.min) {
                    minmax.min = arr[i + 1];
                }
                if (arr[i] > minmax.max) {
                    minmax.max = arr[i];
                }
            }
            i += 2; // Move to next pair
        }

        return minmax;
    }

    public static void main(String[] args) {
        int[] myArray = { 67, 34, 23, 76, 234, 87, 341, 5 };
        A1MinMax obj = new A1MinMax();
        obj.findMinMax1(myArray).display();
        System.out.println("************************************");
        obj.findMinMax2(myArray).display();
        System.out.println("************************************");
        obj.findMinMax3(myArray).display();
        System.out.println("************************************");
        obj.findMinMax4(myArray, 0, myArray.length - 1).display();
        System.out.println("************************************");
        obj.findMinMax5(myArray).display();
    }
}