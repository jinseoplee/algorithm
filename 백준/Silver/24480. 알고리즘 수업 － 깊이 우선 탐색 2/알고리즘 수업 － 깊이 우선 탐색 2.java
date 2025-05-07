import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 시간 제한 1초 
 * 1 <= n <= 100,000 
 * 1 <= m <= 200,000
 * 
 * 정렬 + DFS 풀이
 */
public class Main {
	static int n, m, r;
	static int visitCount = 1;
	static int[] visited;
	static ArrayList<Integer>[] graph;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 처리
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		// 그래프 초기화
		graph = new ArrayList[n + 1];
		visited = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}

		// 내림차순으로 정렬
		for (int i = 1; i <= n; i++) {
			Collections.sort(graph[i], Collections.reverseOrder());
		}

		dfs(r);

		// 결과 출력
		for (int i = 1; i <= n; i++) {
			sb.append(visited[i]).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int v) {
		visited[v] = visitCount++;
		for (int e : graph[v]) {
			if (visited[e] == 0) {
				dfs(e);
			}
		}
	}
}