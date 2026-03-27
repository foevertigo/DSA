class Solution {
    int n, m;
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    char[][] grid;
    public int numIslands(char[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;

        int count =0;
        for(int i=0; i<n;i++) {
            for(int j=0; j<m;j++) {
                if(grid[i][j]=='1') {
                    dfs(i,j);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(int x, int y) {
        if(x<0 || y<0 || x>=n || y>=m || grid[x][y]=='0') return;
        grid[x][y] = '0';

        for(int d=0; d<4;d++) {
            dfs(x+dx[d],y+dy[d]);
        }
    }
}