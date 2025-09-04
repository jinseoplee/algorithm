import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new ArrayDeque<>();

		while (true) {
			int i = Integer.parseInt(br.readLine());
			if (i == -1) {
				break;
			} else if (i == 0) {
				q.poll();
			} else if (q.size() < n) {
				q.offer(i);
			}
		}

		if (q.isEmpty()) {
			sb.append("empty");
		}

		while (!q.isEmpty()) {
			sb.append(q.poll());
			if (!q.isEmpty()) {
				sb.append(" ");
			}
		}

		System.out.println(sb);
	}
}
