class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        for (int weight: weights) {
            sum += weight;
        }
        
        int lo = 1, hi = sum;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isValid(weights, days, mid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    
    private boolean isValid(int[] weights, int dayAllow, int capacity) {
        int dayNeed = 0;
        int sumWeight = 0;
        for (int i = 0; i < weights.length; i++) {
            
            if (weights[i] > capacity) {
                return false;
            }
            
            sumWeight += weights[i];
            
            if (sumWeight > capacity) {
                sumWeight = weights[i];
                dayNeed++;
            }
        }
        
        if (sumWeight > 0) dayNeed++;
        
        return dayNeed <= dayAllow;
    }
}