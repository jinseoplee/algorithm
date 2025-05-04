import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 시간 제한 2초 
 * 2 <= n <= 300,000 
 * 1 <= m <= 1,000,000 
 * 1 <= k <= 300,000 
 * 1 <= x <= n
 * 
 * BFS + 정렬 = O(n + m + n log n)
 */
public class Main {
	static int n, m, k, x;
	static ArrayList<Integer>[] graph;
	static ArrayList<Integer> cities = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 입력 처리
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		// 그래프 초기화
		graph = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		// 간선 초기화
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b); // 단방향
		}

		bfs();

		if (cities.isEmpty()) {
			sb.append("-1");
		} else {
			Collections.sort(cities);
			for (int c : cities) {
				sb.append(c).append("\n");
			}
		}

		// 결과 출력
		System.out.println(sb);
	}

	static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[n + 1];
		int[] dist = new int[n + 1];

		q.offer(x);
		visited[x] = true;

		while (!q.isEmpty()) {
			int curr = q.poll();

			if (dist[curr] > k) {
				break;
			}

			if (dist[curr] == k) {
				cities.add(curr);
			}

			for (int next : graph[curr]) {
				if (!visited[next]) {
					q.offer(next);
					visited[next] = true;
					dist[next] = dist[curr] + 1;
				}
			}
		}
	}
}