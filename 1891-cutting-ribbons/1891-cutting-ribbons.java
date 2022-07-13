class Solution {
    public int maxLength(int[] ribbons, int k) {
        if (ribbons == null || ribbons.length == 0) {
            return 0;
        }
        
        int start = 1, end = 0;
        long sumLen = 0;
        int maxLen = 0;
        
        for (int ribbon: ribbons) {
            sumLen += ribbon;
            end = Math.max(end, ribbon);
        }
        
        end = (int)Math.min(end, sumLen / k);
        
        if (end < 1) {
            return 0;
        }
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
        
            if (countCuts(ribbons, mid) >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return (countCuts(ribbons, end) >= k) ? end : start;
    }
    
    private int countCuts(int[] ribbons, int len) {
        int count = 0;
        
        for (int ribbon: ribbons) {
            count += ribbon / len;
        }
        
        return count;
    }
    
}