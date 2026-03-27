class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for(int i=0; i<n;i++) {
            for(int j=0; j<m;j++) {
                if(grid[i][j]==2) {
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j]==1) {
                    fresh++;
                }
            }
        }
        int time =0;
        while(!q.isEmpty() && fresh>0) {
            int size = q.size();
            time++;

            for(int i=0;i<size;i++) {
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];

                for(int d=0;d<4;d++) {
                    int nx = x+dx[d];
                    int ny = y+dy[d];

                    if(nx>=0 && ny>=0 && nx<n && ny<m && grid[nx][ny]==1) {
                        grid[nx][ny]=2;
                        q.add(new int[]{nx,ny});
                        fresh--;
                    }
                }
            }
        }
        return (fresh==0)?time:-1;
    }
}