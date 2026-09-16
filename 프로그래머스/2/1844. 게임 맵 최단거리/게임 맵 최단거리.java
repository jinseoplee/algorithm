import java.util.*;

class Solution {
    
    private static final int[] dr = {0, 0, -1, 1};
    private static final int[] dc = {1, -1, 0, 0};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> bfsQ = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        
        bfsQ.offer(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        while (!bfsQ.isEmpty()) {
            int[] current = bfsQ.poll();
            int r = current[0];
            int c = current[1];
            int dist = current[2];
            
            if (r == n - 1 && c == m - 1) {
                return dist;
            }
            
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (maps[nr][nc] == 1 && !visited[nr][nc]) {
                        bfsQ.offer(new int[] {nr, nc, dist + 1});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        
        return -1;
    }
}