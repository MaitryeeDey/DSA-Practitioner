import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class A19KthMinElement {
    public static int findKthMinElement(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int a : arr) {
            queue.add(a);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    public static int quickSelect(ArrayList<Integer> arr, int k) {
        ArrayList<Integer> leftArray = new ArrayList<>();
        ArrayList<Integer> rightArray = new ArrayList<>();
        ArrayList<Integer> midArray = new ArrayList<>();
        int pivot = arr.get(arr.size() - 1);
        for (int a : arr) {
            if (a < pivot) {
                leftArray.add(a);
            } else if (a > pivot) {
                rightArray.add(a);
            } else {
                midArray.add(a);
            }
        }
        if (leftArray.size() >= k) {
            return quickSelect(leftArray, k);
        } else if (leftArray.size() + midArray.size() < k) {
            return quickSelect(rightArray, k - leftArray.size() - midArray.size());
        }
        return pivot;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 1, 2, 6, 8 };
        System.out.format("%dth smallest element is %d", 2, findKthMinElement(arr, 2));

        ArrayList<Integer> arrList = new ArrayList<>();
        for (int a : arr) {
            arrList.add(a);
        }
        System.out.format("\n%dth smallest element is %d", 2, quickSelect(arrList, 2));
    }
}
