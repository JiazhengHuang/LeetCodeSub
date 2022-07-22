class Solution {
    
    private static final int[][] directions = 
        new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }
        
        Queue<int[]> queue = new ArrayDeque();
        
        int row = grid.length, col = grid[0].length;
        grid[0][0] = 1;
        queue.offer(new int[]{0, 0});
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];
            int distance = grid[x][y];
            
            if (x == row - 1 & y == grid[0].length - 1) {
                return distance;
            }
            
            for (int[] neighbor: getNeighbors(grid, x, y)) {
                int neighborX = neighbor[0];
                int neighborY = neighbor[1];
                queue.offer(new int[]{neighborX, neighborY});
                grid[neighborX][neighborY] = distance + 1;
            }
        }
        
        return -1;
        
    }
    
    private List<int[]> getNeighbors(int[][] grid, int x, int y) {
        List<int[]> res = new ArrayList();
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < 8; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            
            if (newX < 0 || newY < 0 || newX >= row || newY >= col || grid[newX][newY] != 0) {
                continue;
            }
            res.add(new int[]{newX, newY});
        }
        return res;
    }
}