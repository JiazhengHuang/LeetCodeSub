class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        
        queue.offer(beginWord);
        visited.add(beginWord);
        
        int count = 1;
        
        while (!queue.isEmpty()) {
            count++;
            
            int size = queue.size();
            for (int i = 0; i < size; i++) {
    
                String curWord = queue.poll();
                for (String nextWord: getNextWords(wordList, curWord)) {
                    if (visited.contains(nextWord)) {
                        continue;
                    }
                    
                    if (nextWord.equals(endWord)) {
                        return count;
                    }
                    
                    queue.offer(nextWord);
                    visited.add(nextWord);
                }
            }
        }
        
        return 0;
    }
    
    private ArrayList<String> getNextWords(List<String> wordList, String word) {
        ArrayList<String> nextWords = new ArrayList<>();
        
        for (String each: wordList) {
            boolean hasOneDiff = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != each.charAt(i)) {
                    if (hasOneDiff) {
                        hasOneDiff = false;
                        break;
                    }
                    hasOneDiff = true;
                }
            }
            if(hasOneDiff) {
                nextWords.add(each);   
            }
        }
        return nextWords;
    }
}