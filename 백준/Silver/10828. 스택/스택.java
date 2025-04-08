import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static Deque<Integer> stack = new ArrayDeque<>();

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
			case "top":
				sb.append(top()).append("\n");
				break;
			}
		}

		System.out.println(sb);
	}

	private static void push(int n) {
		stack.offerLast(n);
	}

	private static int pop() {
		return stack.isEmpty() ? -1 : stack.pollLast();
	}

	private static int size() {
		return stack.size();
	}

	private static int empty() {
		return stack.isEmpty() ? 1 : 0;
	}

	private static int top() {
		return stack.isEmpty() ? -1 : stack.peekLast();
	}
}