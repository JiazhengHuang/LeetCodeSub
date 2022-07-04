class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null) {
            return 0;
        }
        
        if (haystack.indexOf(needle) >= 0) {
            return haystack.indexOf(needle);
        }
        return -1;
    }
}