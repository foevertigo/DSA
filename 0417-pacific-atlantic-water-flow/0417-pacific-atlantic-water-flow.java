class Solution {

    int n, m;
    int[][] grid;
    int[][] pacific;
    int[][] atlantic;

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        grid = heights;
        n = heights.length;
        m = heights[0].length;

        pacific = new int[n][m];
        atlantic = new int[n][m];

        // Pacific (top row + left column)
        for (int i = 0; i < n; i++) dfs(i, 0, pacific);
        for (int j = 0; j < m; j++) dfs(0, j, pacific);

        // Atlantic (bottom row + right column)
        for (int i = 0; i < n; i++) dfs(i, m - 1, atlantic);
        for (int j = 0; j < m; j++) dfs(n - 1, j, atlantic);

        List<List<Integer>> res = new ArrayList<>();

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    void dfs(int x, int y, int[][] vis) {

        vis[x][y] = 1;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {

                // reverse condition
                if (vis[nx][ny] == 0 && grid[nx][ny] >= grid[x][y]) {
                    dfs(nx, ny, vis);
                }
            }
        }
    }
}