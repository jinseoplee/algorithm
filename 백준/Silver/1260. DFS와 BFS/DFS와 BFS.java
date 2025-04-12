import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, start;

	static boolean[] visited;
	static boolean[][] graph;
	static Queue<Integer> bfsQ = new ArrayDeque<>();

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());

		graph = new boolean[n + 1][n + 1];
		visited = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u][v] = graph[v][u] = true;
		}

		// DFS
		dfs(start);
		Arrays.fill(visited, false);
		sb.append("\n");

		// BFS
		bfsQ.offer(start);
		visited[start] = true;
		bfs();

		// 결과 출력
		System.out.println(sb);
	}

	static void dfs(int current) {
		visited[current] = true;
		sb.append(current).append(" ");

		for (int i = 1; i <= n; i++) {
			if (graph[current][i] && !visited[i]) {
				dfs(i);
			}
		}
	}

	static void bfs() {
		while (!bfsQ.isEmpty()) {
			int current = bfsQ.poll();
			sb.append(current).append(" ");

			for (int i = 1; i <= n; i++) {
				if (graph[current][i] && !visited[i]) {
					bfsQ.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}