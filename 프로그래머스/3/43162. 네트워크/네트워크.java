class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int networkCnt = 0;
        
        // 모든 컴퓨터를 순차적으로 탐색하며 연결된 컴퓨터들을 DFS로 방문
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers, visited);
                networkCnt++;
            }
        }
        
        return networkCnt;
    }
    
    private void dfs(int currentV, int[][] computers, boolean[] visited) {
        visited[currentV] = true;
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i] && computers[currentV][i] == 1) {
                dfs(i, computers, visited);
            }
        }
    }
}