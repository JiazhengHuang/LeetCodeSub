class Solution {
    public int maxArea(int[] height) {
        int maxRes = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            int shorter = Math.min(height[left], height[right]);
            maxRes = Math.max(maxRes, shorter * (right - left));
            
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
            
        }
        return maxRes;
    }
}