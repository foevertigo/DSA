class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        //Apply gravity and push #to the utmost right until we hit another stone or *
        for(int i=0; i<m;i++) {
            int empty = n - 1; //rightmost place to drop stone
            for(int j=n-1;j>=0;j--) {
                if(boxGrid[i][j]=='*') {
                    empty = j - 1;
                } else if(boxGrid[i][j]=='#') {
                    char temp = boxGrid[i][empty];
                    boxGrid[i][empty] = '#';
                    boxGrid[i][j] = temp;
                    empty--;
                }
            }
        }

        char[][] res = new char[n][m];
        for(int i=0; i<m;i++) {
            for(int j=0; j<n;j++) {
                res[j][m-1-i] = boxGrid[i][j];
            }
        }
        return res;
    }
}