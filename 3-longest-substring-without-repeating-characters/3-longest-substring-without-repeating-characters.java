class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        
        int[] chars = new int[128];
        int res = 0;
        int left = 0;
        int right = 0;
        
        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;
            
            while (chars[r] > 1) {
                char l = s.charAt(left);
                left++;
                chars[l]--;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        
        return res;
    }
}

// pwwkew
// r l