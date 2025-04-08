import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static Deque<Integer> queue = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			switch (cmd) {
			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				sb.append(pop()).append("\n");
				break;
			case "size":
				sb.append(size()).append("\n");
				break;
			case "empty":
				sb.append(empty()).append("\n");
				break;
			case "front":
				sb.append(front()).append("\n");
				break;
			case "back":
				sb.append(back()).append("\n");
				break;
			}
		}

		System.out.println(sb);
	}

	private static void push(int n) {
		queue.offerLast(n);
	}

	private static int pop() {
		return queue.isEmpty() ? -1 : queue.pollFirst();
	}

	private static int size() {
		return queue.size();
	}

	private static int empty() {
		return queue.isEmpty() ? 1 : 0;
	}

	private static int front() {
		return queue.isEmpty() ? -1 : queue.peekFirst();
	}

	private static int back() {
		return queue.isEmpty() ? -1 : queue.peekLast();
	}
}