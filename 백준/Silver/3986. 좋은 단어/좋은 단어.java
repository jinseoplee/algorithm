import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int count = 0;

		while (n-- > 0) {
			String word = br.readLine();

			Deque<Character> stack = new ArrayDeque<>();
			for (char c : word.toCharArray()) {
				if (stack.isEmpty() || stack.peek() != c) {
					stack.push(c);
				} else {
					stack.pop();
				}
			}

			if (stack.isEmpty()) {
				count++;
			}
		}

		System.out.println(count);
	}
}
