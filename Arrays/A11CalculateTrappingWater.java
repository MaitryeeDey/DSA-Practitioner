public class A11CalculateTrappingWater {
    public static int calculateTrappingWater(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int leftMaxHeight = arr[0];
        int rightMaxHeight = arr[right];
        int trappedWater = 0;
        while (left < right) {
            if (leftMaxHeight < rightMaxHeight) {
                left++;
                if (leftMaxHeight < arr[left]) {
                    leftMaxHeight = arr[left];
                } else {
                    trappedWater += leftMaxHeight - arr[left];
                }
            } else {
                right--;
                if (rightMaxHeight < arr[right]) {
                    rightMaxHeight = arr[right];
                } else {
                    trappedWater += rightMaxHeight - arr[right];
                }
            }
        }
        return trappedWater;

    }

    public static void main(String[] args) {
        int[] heights = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println("Trapped Water is " + calculateTrappingWater(heights));
    }
}
