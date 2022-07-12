class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        
        int firstPos = firstPosition(nums, target, true);
        
        if (firstPos == -1) {
            return new int[] {-1, -1};
        }
        
        int lastPos = firstPosition(nums, target, false);
        
        return new int[] {firstPos, lastPos};
        
        
    }
    
    private int firstPosition(int[] nums, int target, boolean isFirst) {
        int start = 0, end = nums.length - 1;
        
        while (start <= end) {
            
            int mid = start + (end - start) / 2;
            
            if (nums[mid] == target) {
                
                if(isFirst) {
                    
                    if (mid == start || nums[mid - 1] != target) {
                        return mid;
                    }
                    
                    end = mid - 1;
                    
                } else {
                    
                    if (mid == end || nums[mid + 1] != target) {
                        return mid;
                    }
                    
                    start = mid + 1;
                }  
                
            } else if (target < nums[mid]) {
                end = mid - 1;
                
            } else {
                start = mid + 1;
                
            }
        }
        return -1;
    }
}