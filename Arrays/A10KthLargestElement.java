import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class A10KthLargestElement {
    public static int findKthLargestElem(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int a : arr) {
            queue.add(a);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    public static int findKthSmallestElem(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int a : arr) {
            queue.add(a);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    public static int quickSelect(List<Integer> arr, int k) {
        if (arr.size() == 1) {
            return arr.get(0);
        }
        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();
        ArrayList<Integer> midArr = new ArrayList<>();
        int pivot = arr.get(arr.size() - 1);
        for (int a : arr) {
            if (a > pivot) {
                leftArr.add(a);
            } else if (a < pivot) {
                rightArr.add(a);
            } else {
                midArr.add(a);
            }
        }
        if (k <= leftArr.size()) {
            return quickSelect(leftArr, k);
        } else if (leftArr.size() + midArr.size() < k) {
            return quickSelect(rightArr, k - leftArr.size() - midArr.size());
        }
        return pivot;
    }

    public static int findKthLargestElem2(int[] arr, int k) {
        ArrayList<Integer> arrList = new ArrayList<>();
        for (int a : arr) {
            arrList.add(a);

        }
        return quickSelect(arrList, k);
    }


    public static void main(String[] args) {

        int[] arr = { 5, 2, 5, 7, 1, 8, 9 };
        System.out.format("%dth largest element is %d", 3, findKthLargestElem(arr, 3));
        System.out.format("\n%dth smallest element is %d", 3, findKthSmallestElem(arr, 3));
        System.out.format("\n%dth largest element is %d", 3, findKthLargestElem2(arr, 3));
    }
}
