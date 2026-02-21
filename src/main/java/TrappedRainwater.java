public class TrappedRainwater {
    /**
     * Assignment 3: TrappedRainwater
     */

    public static int trapRainwater(int[] height) {
        if (height == null || height.length == 0 ) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int water = 0;

        while (left < right) {
            // left side is limiting
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += (leftMax - height[left]);
                }
                left++; // move left every time it process
                } else {
                    // right side is limiting
                    if (height[right] >= rightMax) {
                        rightMax = height[right];
                    } else {
                        water += (rightMax - height[right]);
                    }
                    right--;
                }
            }
        return water;
    }


}
