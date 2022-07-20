class Solution {
    
    int[][] offsets = {{1, 2}, {2, 1}, {2, -1}, {1, -2},
                {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
    
    public int minKnightMoves(int x, int y) {
        Queue<int[]> queue = new ArrayDeque();
        boolean[][] visited = new boolean[607][607];
        
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        int moves = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                
                int[] curr = queue.poll();
                if (curr[0] == x && curr[1] == y) {
                    return moves;
                }

                for (int i = 0; i < 8; i++) {
                    int newX = curr[0] + offsets[i][0];
                    int newY = curr[1] + offsets[i][1];
                    int[] newP = new int[]{newX, newY};
                    if (!visited[newX + 302][newY + 302]) {
                        queue.offer(newP);
                        visited[newX + 302][newY + 302] = true;
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}