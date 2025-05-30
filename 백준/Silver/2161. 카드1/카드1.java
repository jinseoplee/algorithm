import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new ArrayDeque<>();

		int n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; i++) {
			q.offer(i);
		}

		while (q.size() > 1) {
			sb.append(q.poll()).append(" ");
			q.offer(q.poll());
		}
		sb.append(q.poll());

		System.out.println(sb);
	}
}
