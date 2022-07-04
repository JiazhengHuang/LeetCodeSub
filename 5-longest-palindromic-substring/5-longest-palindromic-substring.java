class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return "";
        }
        
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            
            String oddLongest = getPalindromeFrom(s, i, i);
            if (answer.length() < oddLongest.length()){
                answer = oddLongest;
            }
            
            String evenLongest = getPalindromeFrom(s, i, i + 1);
            if (answer.length() < evenLongest.length()){
                answer = evenLongest;
            }
        }
        
        return answer;
    }
    
    private String getPalindromeFrom(String s, int left, int right){
        while (left >= 0 && right < s.length()){
            if (s.charAt(left) != s.charAt(right)){
                break;
            }
            left--;
            right++;
        }
        
        return s.substring(left + 1, right);
    }
}