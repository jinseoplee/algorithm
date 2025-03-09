import java.util.*;

class Node {
    int r, c, cnt; // 행, 열, 칸의 개수
    
    Node(int r, int c, int cnt) {
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }
}

class Solution {
    // 상, 하, 좌, 우
    private int[] dr = {-1, 1, 0, 0};
    private int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        // BFS를 사용하여 상대 팀 진영에 도달하기 위해 지나야 하는 최소 칸 수를 구할 수 있다
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 1));
        
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
    
        while (!q.isEmpty()) {
            Node curr = q.poll();
            
            // 상대 진영에 도착한 경우
            if (curr.r == n - 1 && curr.c == m - 1) {
                return curr.cnt;
            }
            
            for (int dir = 0; dir < 4; dir++) {
                int nr = curr.r + dr[dir];
                int nc = curr.c + dc[dir];
                if (canGo(nr, nc, n, m, maps, visited)) {
                    q.offer(new Node(nr, nc, curr.cnt + 1));
                    visited[nr][nc] = true;
                }
            }
        }
        
        // 상대 진영에 도착하지 못하는 경우
        return -1;
    }
    
    private boolean canGo(int r, int c, int n, int m, int[][] maps, boolean[][] visited) {
        return (0 <= r && r < n && 0 <= c && c < m)
            && maps[r][c] == 1
            && !visited[r][c];
    }
}