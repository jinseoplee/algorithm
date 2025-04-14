import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] parent = new int[n + 1];
		ArrayList<Integer>[] graph = new ArrayList[n + 1];

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			if (graph[u] == null) {
				graph[u] = new ArrayList<>();
			}

			if (graph[v] == null) {
				graph[v] = new ArrayList<>();
			}

			graph[u].add(v);
			graph[v].add(u);
		}

		Queue<Integer> bfsQ = new ArrayDeque<>();
		bfsQ.offer(1);
		parent[1] = -1;

		while (!bfsQ.isEmpty()) {
			int curr = bfsQ.poll();
			for (int next : graph[curr]) {
				if (parent[next] == 0) {
					bfsQ.offer(next);
					parent[next] = curr;
				}
			}
		}

		for (int i = 2; i <= n; i++) {
			sb.append(parent[i]).append("\n");
		}
		System.out.println(sb);
	}
}