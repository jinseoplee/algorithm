import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int count = 0;

		boolean[] visited = new boolean[n];
		boolean[][] graph = new boolean[n][n];

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			graph[u][v] = graph[v][u] = true;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(i, n, visited, graph);
				count++;
			}
		}

		System.out.println(count);
	}

	static void dfs(int current, int n, boolean[] visited, boolean[][] graph) {
		visited[current] = true;
		for (int next = 0; next < n; next++) {
			if (graph[current][next] && !visited[next]) {
				dfs(next, n, visited, graph);
			}
		}
	}
}