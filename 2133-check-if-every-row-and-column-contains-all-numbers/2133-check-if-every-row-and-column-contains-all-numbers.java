class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
         
        //check rows
        for(int i=0; i<n;i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            for(int j=0; j<n;j++) {
                rowSet.add(matrix[i][j]);
            }

            if(rowSet.size()!=n) return false;
        }

        //check cols
        for(int j=0; j<n;j++) {
            HashSet<Integer> colSet = new HashSet<>();
            for(int i=0; i<n;i++) {
                colSet.add(matrix[i][j]);
            }

            if(colSet.size()!=n) return false;

        }
        return true;
    }
}