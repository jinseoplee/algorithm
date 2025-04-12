import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point o) {
		if (this.y == o.y) {
			return this.x - o.x;
		}
		return this.y - o.y;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		List<Point> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Point(x, y));
		}

		Collections.sort(list);

		for (int i = 0; i < n; i++) {
			Point p = list.get(i);
			sb.append(p.x).append(" ").append(p.y).append("\n");
		}
		System.out.println(sb);
	}
}