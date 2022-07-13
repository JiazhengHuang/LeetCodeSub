class Solution {
    public boolean find132pattern(int[] nums) {
        int[] min = new int[nums.length];
        min[0] = nums[0];
        
        for (int j = 1; j < nums.length; j++) {
            min[j] = Math.min(nums[j], min[j - 1]);
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for (int j = nums.length - 1; j >= 0; j--) {
            while (!stack.empty() && stack.peek() < nums[j]) {
                if (stack.peek() > min[j]) {
                    return true;
                }
                stack.pop();
            }
            stack.push(nums[j]);
        }
        return false;
    }
}