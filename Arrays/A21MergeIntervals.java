import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class A21MergeIntervals {
    public static List<int[]> mergeIntervals(List<int[]> list) {
        List<int[]> result = new ArrayList<>();
        Collections.sort(list, new Comparator<int[]>() {
            // The compare() method should return a number which is:
            // Negative if the first object should go first in a list.
            // Positive if the second object should go first in a list.
            // Zero if the order does not matter.
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];

            }
        });
        for (int i = 0; i < list.size() - 1; i = i + 2) {
            int[] leftInterval = list.get(i);
            int[] rightInterval = list.get(i + 1);
            while (i < list.size() && leftInterval[1] >= rightInterval[0]) {
                i++;
            }
            if (leftInterval[1] >= rightInterval[0]) {
                result.add(new int[] { leftInterval[0], rightInterval[1] });
            } else {
                result.add(leftInterval);
                result.add(rightInterval);
            }
        }
        return result;
    }

    public static int[][] mergeIntervalsArray(List<int[]> intervals) {
        List<int[]> result = new ArrayList<>();
        Collections.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int i = 0;
        int l = 0;
        int r = 0;
        while (i < intervals.size()) {
            l = intervals.get(i)[0];
            r = intervals.get(i)[1];
            while (i < intervals.size() - 1) {

                if (r > intervals.get(i + 1)[0]) {
                    r = Math.max(r, intervals.get(i + 1)[1]);
                    i++;
                } else {
                    break;
                }

            }
            result.add(new int[] { l, r });
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>(
                Arrays.asList(new int[] { 1, 3 }, new int[] { 2, 6 }, new int[] { 8, 10 }, new int[] { 15, 18 }));
        for (int[] a : mergeIntervalsArray(list)) {
            for (int i : a) {
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }
}
