class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new ArrayDeque();
        HashSet<String> visited = new HashSet();
        queue.offer(beginWord);
        visited.add(beginWord);
        
        int count = 1;
        
        while (!queue.isEmpty()) {
            
            count++;
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {           
                String curWord = queue.poll();
                List<String> nextWordsList = getNextWords(curWord, wordList);
                System.out.println(nextWordsList);
                for (String nextWord: nextWordsList) {
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
    
    private List<String> getNextWords(String word, List<String> wordList) {
        
        List<String> arr = new ArrayList();
        
        for (String each: wordList) {
            boolean changedOnce = false;
            for (int i = 0; i < word.length(); i++) {
                if (each.charAt(i) != word.charAt(i)) {
                    if (changedOnce) {
                        changedOnce = false;
                        break;
                    }
                    changedOnce = true;
                }
            }
            if (changedOnce) {
                arr.add(each);
            }
        }
        
        return arr;
    }
}