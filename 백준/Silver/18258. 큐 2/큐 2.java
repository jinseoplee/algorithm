import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 가장 앞쪽과 뒤쪽에 접근하기 위해서 Deque를 사용
		Deque<Integer> q = new ArrayDeque<>();

		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String op = st.nextToken();

			switch (op) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				q.addLast(num);
				break;
			case "pop":
				sb.append(q.isEmpty() ? -1 : q.pollFirst()).append("\n");
				break;
			case "size":
				sb.append(q.size()).append("\n");
				break;
			case "empty":
				sb.append(q.isEmpty() ? 1 : 0).append("\n");
				break;
			case "front":
				sb.append(q.isEmpty() ? -1 : q.peekFirst()).append("\n");
				break;
			case "back":
				sb.append(q.isEmpty() ? -1 : q.peekLast()).append("\n");
				break;
			}
		}

		// 결과 출력
		System.out.println(sb);
	}
}
