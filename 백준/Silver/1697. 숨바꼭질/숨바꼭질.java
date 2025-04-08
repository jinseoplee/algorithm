import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int n, k;
	private static int[] arr = new int[100_001];
	private static boolean[] visited = new boolean[100_001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int answer = bfs();
		System.out.println(answer);
	}

	private static int bfs() {
		Queue<int[]> bfsQ = new ArrayDeque<>();
		bfsQ.offer(new int[] { n, 0 }); // 위치, 시간
		visited[n] = true;

		while (!bfsQ.isEmpty()) {
			int[] curr = bfsQ.poll();

			if (curr[0] == k) {
				return curr[1];
			}

			if (curr[0] - 1 >= 0 && !visited[curr[0] - 1]) {
				bfsQ.offer(new int[] { curr[0] - 1, curr[1] + 1 });
				visited[curr[0] - 1] = true;
			}
			if (curr[0] + 1 <= 100_000 && !visited[curr[0] + 1]) {
				bfsQ.offer(new int[] { curr[0] + 1, curr[1] + 1 });
				visited[curr[0] + 1] = true;
			}
			if (curr[0] * 2 <= 100_000 && !visited[curr[0] * 2]) {
				bfsQ.offer(new int[] { curr[0] * 2, curr[1] + 1 });
				visited[curr[0] * 2] = true;
			}
		}

		return -1;
	}
}