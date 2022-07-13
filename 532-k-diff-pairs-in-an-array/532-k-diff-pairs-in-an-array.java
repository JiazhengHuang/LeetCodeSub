class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++){
            int start = i + 1, end = nums.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                int diff = Math.abs(nums[i] - nums[mid]);
                
                if (diff < k) {
                    start = mid + 1;
                } else if (diff > k) {
                    end = mid - 1;
                } else {
                    res++;
                    break;
                }
            }
            
            while (i != nums.length - 1 && nums[i + 1] == nums[i]) {
                i++;
            }
        }
        return res;
    }
}