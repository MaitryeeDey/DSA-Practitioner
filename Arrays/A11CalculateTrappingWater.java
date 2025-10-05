public class A11CalculateTrappingWater {
    public static int calculateTrappingWater(int[] arr) {
        int trappedWater = 0;
        int left = 0;
        int right = arr.length - 1;
        int maxLeftHeight = arr[left];
        int maxRightHeight = arr[right];
        while (left < right) {
            if (maxLeftHeight < maxRightHeight) {
                left++;
                if (maxLeftHeight < arr[left]) {
                    maxLeftHeight = arr[left];
                } else {
                    trappedWater += maxLeftHeight - arr[left];
                }
            } else {
                right--;
                if (maxRightHeight < arr[right]) {
                    maxRightHeight = arr[right];
                } else {
                    trappedWater += maxRightHeight - arr[right];
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
