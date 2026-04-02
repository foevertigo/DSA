import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];

        q.offer(1); // start from cell 1
        visited[1] = true;

        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int s = 0; s < size; s++) {
                int curr = q.poll();

                if (curr == n * n) return moves;

                for (int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;
                    if (next > n * n) break;

                    int[] pos = getPosition(next, n);
                    int r = pos[0], c = pos[1];

                    if (board[r][c] != -1) {
                        next = board[r][c]; // snake or ladder
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
            moves++;
        }

        return -1;
    }

    // convert number (row, col)
    private int[] getPosition(int num, int n) {
        int r = (num - 1) / n;
        int c = (num - 1) % n;

        if (r % 2 == 1) {
            c = n - 1 - c; // reverse for zigzag
        }

        r = n - 1 - r; // flip row (bottom to top)

        return new int[]{r, c};
    }
}