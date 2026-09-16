class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int networkCount = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, n, computers, visited);
                networkCount++;
            }
        }
        
        return networkCount;
    }
    
    private void dfs(int current, int n, int[][] computers, boolean[] visited) {
        visited[current] = true;
        
        for (int next = 0; next < n; next++) {
            if (computers[current][next] == 1 && !visited[next]) {
                dfs(next, n, computers, visited);
            }
        }
    }
}