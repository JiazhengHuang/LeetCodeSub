class Coordinate {
    int x, y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    
    int[] deltaX = {0, 1, -1, 0};
    int[] deltaY = {1, 0, 0, -1};
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || 
            grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        
        int islands = 0;
        int row = grid.length, col = grid[0].length;
        
        boolean[][] visited = new boolean[row][col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // System.out.println(grid[i][j] == '1');
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, i, j, visited);
                    islands++;
                }
            }
        }
        return islands;
    }
    
    private void bfs(char[][] grid, int x, int y, boolean[][] visited) {
        Queue<Coordinate> queue = new ArrayDeque<>();
        queue.offer(new Coordinate(x, y));
        visited[x][y] = true;
        
        while (!queue.isEmpty()) {
            Coordinate coor = queue.poll();
            
            for (int i  = 0; i < 4; i++) {
                int newX = coor.x + deltaX[i];
                int newY = coor.y + deltaY[i];
                if (!isVaild(grid, newX, newY, visited)) {
                    continue;
                }
                queue.offer(new Coordinate(newX, newY));
                visited[newX][newY] = true;
            }   
        }
    }
    
    private boolean isVaild(char[][] grid, int x, int y, boolean[][] visited) {
        int n = grid.length, m = grid[0].length;
        
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }
        
        if (visited[x][y]) {
            return false;
        }
        
        return grid[x][y] == '1';
    }
}