import java.util.*;

class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> bfsQ = new ArrayDeque<>();
        bfsQ.offer(new int[] {0, 0, 1});
        
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        
        while (!bfsQ.isEmpty()) {
            int[] curr = bfsQ.poll();
            if (curr[0] == n - 1 && curr[1] == m - 1) {
                return curr[2];
            }
            for (int dir = 0; dir < 4; dir++) {
                int nr = curr[0] + dr[dir];
                int nc = curr[1] + dc[dir];
                if ((0 <= nr && nr < n && 0 <= nc && nc < m) && maps[nr][nc] == 1 && !visited[nr][nc]) {
                    bfsQ.offer(new int[] {nr, nc, curr[2] + 1});
                    visited[nr][nc] = true;
                }
            }
        }
        
        return -1;
    }
}