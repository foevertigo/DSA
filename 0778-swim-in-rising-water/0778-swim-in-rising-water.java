import java.util.*;

class Solution {

    public int swimInWater(int[][] grid) {

        int n = grid.length;

        // min-heap based on time (height)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        // visited array
        int[][] vis = new int[n][n];

        // {row, col, time}
        pq.offer(new int[]{0, 0, grid[0][0]});

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int r = curr[0];
            int c = curr[1];
            int time = curr[2];

            if (vis[r][c] == 1) continue;
            vis[r][c] = 1;

            // reached destination
            if (r == n - 1 && c == n - 1) return time;

            for (int k = 0; k < 4; k++) {

                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && vis[nr][nc] == 0) {

                    int newTime = Math.max(time, grid[nr][nc]);

                    pq.offer(new int[]{nr, nc, newTime});
                }
            }
        }

        return -1;
    }
}