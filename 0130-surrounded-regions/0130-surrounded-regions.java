class Solution {
    int n,m;
    char[][] board;

    int[] dx = {-1,1,0,0};
    int[] dy ={0,0,-1,1};
    public void solve(char[][] board) {
        this.board = board;
        n=board.length;
        m=board[0].length;

        //marking boundary as safe #

        for(int i=0; i<n;i++) {
            if(board[i][0]=='O') dfs(i,0);
            if(board[i][m-1]=='O') dfs(i,m-1);
        }

        for(int j=0; j<m;j++) {
            if(board[0][j]=='O') dfs(0,j);
            if(board[n-1][j]=='O') dfs(n-1,j);
        }

        //flip O to X and # to O
        for(int i=0; i<n;i++) {
            for(int j=0; j<m;j++) {
                if(board[i][j]=='O') board[i][j]='X';
                else if(board[i][j]=='#') board[i][j]='O';
            }
        }
    }
    void dfs(int x, int y) {
        if(x<0 || y<0 || x>=n || y>=m || board[x][y]!='O') return;

        board[x][y] = '#';
        for(int d=0; d<4;d++) {
            dfs(x+dx[d], y+dy[d]);
        }
    }
}