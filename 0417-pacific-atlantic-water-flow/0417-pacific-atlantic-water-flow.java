import java.util.*;

class Solution {
    int m, n;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        Queue<int[]> pq = new LinkedList<>();
        Queue<int[]> aq = new LinkedList<>();

        // Pacific borders
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0});
            pac[i][0] = true;
        }
        for (int j = 0; j < n; j++) {
            pq.offer(new int[]{0, j});
            pac[0][j] = true;
        }

        // Atlantic borders
        for (int i = 0; i < m; i++) {
            aq.offer(new int[]{i, n - 1});
            atl[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            aq.offer(new int[]{m - 1, j});
            atl[m - 1][j] = true;
        }

        bfs(heights, pq, pac);
        bfs(heights, aq, atl);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j])
                    res.add(Arrays.asList(i, j));
            }
        }

        return res;
    }

    // BFS traversal
    void bfs(int[][] h, Queue<int[]> q, boolean[][] vis) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
                if (vis[nr][nc]) continue;

                if (h[nr][nc] >= h[r][c]) { // reverse condition
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}