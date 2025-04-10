import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[][] arr = new boolean[n][n];
		boolean[] visited = new boolean[n];

		int k = Integer.parseInt(br.readLine());
		while (k-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken()) - 1;
			int v2 = Integer.parseInt(st.nextToken()) - 1;
			arr[v1][v2] = arr[v2][v1] = true;
		}

		int answer = dfs(0, n, arr, visited);
		System.out.println(answer - 1); // 0번 컴퓨터 제외
	}

	static int dfs(int v, int n, boolean[][] arr, boolean[] visited) {
		visited[v] = true;
		int count = 1;

		for (int i = 0; i < n; i++) {
			if (arr[v][i] && !visited[i]) {
				count += dfs(i, n, arr, visited);
			}
		}

		return count;
	}
}