import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[][] graph = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			int[] visited = new int[n];
			dfs(i, n, visited, graph);

			for (int j = 0; j < n; j++) {
				sb.append(visited[j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static void dfs(int current, int n, int[] visited, int[][] graph) {
		for (int next = 0; next < n; next++) {
			if (graph[current][next] == 1 && visited[next] == 0) {
				visited[next] = 1;
				dfs(next, n, visited, graph);
			}
		}
	}
}