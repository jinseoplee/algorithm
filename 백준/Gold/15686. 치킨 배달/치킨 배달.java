import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
	int r, c;

	Node(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main {
	static int n, m;
	static int answer = Integer.MAX_VALUE;
	static int[][] map;
	static Node[] selected;
	static List<Node> house = new ArrayList<>();
	static List<Node> chicken = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		selected = new Node[m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) { // 집
					house.add(new Node(i, j));
				} else if (map[i][j] == 2) { // 치킨
					chicken.add(new Node(i, j));
				}
			}
		}

		solve(0, 0);

		System.out.println(answer);
	}

	static void solve(int start, int idx) {
		if (idx == m) {
			answer = Math.min(answer, distance()); // 도시의 치킨 거리의 최솟값을 구한다
			return;
		}

		for (int i = start; i < chicken.size(); i++) {
			selected[idx] = chicken.get(i);
			solve(i + 1, idx + 1);
		}
	}

	static int distance() {
		int sum = 0;
		for (int i = 0; i < house.size(); i++) {
			int min = Integer.MAX_VALUE;
			Node h = house.get(i); // 집
			for (int j = 0; j < m; j++) {
				Node c = selected[j]; // 치킨
				min = Math.min(min, Math.abs(c.r - h.r) + Math.abs(c.c - h.c)); // 집과 가장 가까운 치킨 거리를 구한다
			}
			sum += min; // 치킨 거리의 합을 구한다
		}
		return sum;
	}
}