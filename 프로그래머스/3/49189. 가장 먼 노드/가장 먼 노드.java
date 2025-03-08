import java.util.*;

class Node {
    int v; // 정점
    int distance; // 거리
    
    Node(int v, int distance) {
        this.v = v;
        this.distance = distance;
    }
}

class Solution {
    public int solution(int n, int[][] edge) {
        // 그래프 초기화
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 간선 초기화
        for (int[] e : edge) {
            int u = e[0];
            int v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        
        // BFS를 사용하여 가장 멀리 떨어진 노드의 개수를 구한다
        int cnt = bfs(n, graph);
        
        return cnt;
    }
    
    private int bfs(int n, ArrayList<Integer>[] graph) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(1, 0));
        
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        
        int maxDistance = 0;
        int cnt = 0;
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            
            if (curr.distance > maxDistance) {
                maxDistance = curr.distance;
                cnt = 1;
            } else if (curr.distance == maxDistance) {
                cnt++;
            }
            
            for (int next : graph[curr.v]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new Node(next, curr.distance + 1));
                }
            }
        }
        
        return cnt;
    }
}