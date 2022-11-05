package container_with_most_water;

class Solution {
    public int maxArea(int[] height) {
        int distance = height.length - 1;
        int maxL = height[0];
        int maxR = height[distance];
        int maxArearesult = Math.min(maxL, maxR) * distance;
        for (int i = 0, j = distance; i < j; ) {
            distance--;
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
            maxArearesult = Math.max(maxArearesult, Math.min(height[i], height[j]) * distance);
        }
        return maxArearesult;
    }
}
