public class A20CalculateMaxContainerContainingWater {
    public static int maxArea(int[] arr) {
        int maxArea = 0;
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int minH = Math.min(arr[left], arr[right]);
            maxArea = Math.max(maxArea, minH * (right - left));
            while (left < right && minH >= arr[left]) {
                left++;
            }
            while (left < right && minH >= arr[right]) {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {

        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

        int maxWater = maxArea(height);

        System.out.println("Maximum water that can be contained: " + maxWater);

    }
}
