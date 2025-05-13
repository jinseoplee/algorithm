import java.util.*;

/**
* 1 <= 컴퓨터의 개수 <= 200
* 각 컴퓨터의 번호는 0부터 시작
* 
* 인접 행렬 + BFS = O(n^2)
*/
class Solution {
    
    public int solution(int n, int[][] computers) {
        int networkCount = 0;
        boolean[] visited = new boolean[n];
        
        // 네트워크 탐색 시작
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, n, visited, computers);
                networkCount++;
            }
        }
        
        return networkCount;
    }
    
    void bfs(int v, int n, boolean[] visited, int[][] computers) {
        Queue<Integer> bfsQ = new ArrayDeque<>();
        bfsQ.offer(v);
        visited[v] = true;
        
        while (!bfsQ.isEmpty()) {
            int curr = bfsQ.poll();
            for (int i = 0; i < n; i++) {
                if (!visited[i] && computers[curr][i] == 1) { // 연결되어 있고 방문하지 않은 컴퓨터
                    bfsQ.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}