import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시간 제한 1초 
 * 1 <= n <= 100
 * 
 * DFS 풀이 = O(n^2)
 */
public class Main {
	static int n, m;
	static int a, b;
	static int[] visited;
	static boolean[][] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 처리
		n = Integer.parseInt(br.readLine());
		graph = new boolean[n + 1][n + 1];
		visited = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x][y] = graph[y][x] = true;
		}

		dfs(a, 0);

		// 결과 출력
		System.out.println(visited[b] == 0 ? -1 : visited[b]);
	}

	static void dfs(int curr, int dist) {
		visited[curr] = dist;
		for (int i = 1; i <= n; i++) {
			if (graph[curr][i] && visited[i] == 0 && visited[b] == 0) {
				dfs(i, dist + 1);
			}
		}
	}
}