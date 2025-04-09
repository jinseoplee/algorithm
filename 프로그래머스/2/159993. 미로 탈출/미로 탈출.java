import java.util.*;

class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int solution(String[] maps) {
        int[] start = {0, 0};
        int[] lever = {0, 0};
        int[] exit = {0, 0};
        
        int n = maps.length;
        int m = maps[0].length();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (maps[i].charAt(j) == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                } else if (maps[i].charAt(j) == 'E') {
                    exit[0] = i;
                    exit[1] = j;
                }
            }
        }
        
        int time1 = bfs(start, lever, n, m, maps);
        if (time1 == -1) return -1;
        
        int time2 = bfs(lever, exit, n, m, maps);
        if (time2 == -1) return -1;
        
        return time1 + time2;
    }
    
    int bfs(int[] src, int[] dst, int n, int m, String[] maps) {
        Queue<int[]> bfsQ = new ArrayDeque<>();
        bfsQ.offer(new int[] {src[0], src[1], 0});
        
        boolean[][] visited = new boolean[n][m];
        visited[src[0]][src[1]] = true;
        
        while (!bfsQ.isEmpty()) {
            int[] curr = bfsQ.poll();
            if (curr[0] == dst[0] && curr[1] == dst[1]) {
                return curr[2];
            }
            for (int dir = 0; dir < 4; dir++) {
                int nr = curr[0] + dr[dir];
                int nc = curr[1] + dc[dir];
                if ((0 <= nr && nr < n && 0 <= nc && nc < m) && maps[nr].charAt(nc) != 'X' && !visited[nr][nc]) {
                    bfsQ.offer(new int[] {nr, nc, curr[2] + 1});
                    visited[nr][nc] = true;
                }
            }
        }
        
        return -1;
    }
}