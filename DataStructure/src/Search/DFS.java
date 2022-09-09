package Search;

public class DFS {

    /**
     * 695. Max Area of Island (Medium)
     */
    private int m, n;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        int area = 1;
        for (int[] d : direction) {
            area += dfs(grid, r + d[0], c + d[1]);
        }
        return area;
    }

    /**
     * 200. Number of Islands (Medium)
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int ret = 0;
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    ret++;
                    dfs1(grid,i,j);
                }
            }
        }
        return ret;
    }

    private void dfs1(char[][] grid,int r,int c){
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        for(int[] d:direction){
            dfs1(grid,r+d[0],c+d[1]);
        }
    }

    /**
     * 547. Friend Circles (Medium)
     */
    public int findCircleNum(int[][] isConnected) {
        n=isConnected.length;
        int cirNum = 0;
        boolean[] hasVisited = new boolean[n];
        for(int i = 0;i<n;i++){
            if(!hasVisited[i]){
                dfs2(isConnected,i,hasVisited);
                cirNum++;
            }
        }
        return cirNum;
    }

    private void dfs2(int[][] isConnected,int i,boolean[] hasVisited){
        hasVisited[i] = true;
        for(int k=0;k<n;k++){
            if(isConnected[i][k]==1&&!hasVisited[k]){
                dfs2(isConnected,k,hasVisited);
            }
        }
    }

}
