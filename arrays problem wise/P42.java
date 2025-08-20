public class P42 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // width between the two pointers
            int width = right - left;

            // height is limited by the shorter line
            int minHeight = Math.min(height[left], height[right]);

            // calculate area
            int area = width * minHeight;
            maxArea = Math.max(maxArea, area);

            // move pointer of smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println("Max water area = " + maxArea);
    }
}

