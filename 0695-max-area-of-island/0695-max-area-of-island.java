class Solution {
    int n,m;
    int[][] grid;
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;

        int maxArea = 0;

        for(int i=0; i<n;i++) {
            for(int j=0; j<m;j++) {
                if(grid[i][j]==1) {
                    int area = dfs(i,j);
                    maxArea = Math.max(maxArea,area);
                }
            }
        }
        return maxArea;
    }
    int dfs(int x,int y) {
        if(x<0 || y<0 || x>=n || y>=m || grid[x][y]==0) return 0;

        grid[x][y] =0;
        int area = 1;
        for(int d=0; d<4;d++) {
            area+=dfs(x+dx[d],y+dy[d]);
        }
        return area;
    }

}