import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String str = br.readLine();

			if (str.equals(".")) {
				break;
			}

			sb.append(balance(str)).append("\n");
		}

		System.out.println(sb);
	}

	static String balance(String str) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (c == '(' || c == '[') {
				stack.push(c);
			} else if (c == ')' || c == ']') {
				if (stack.isEmpty()) {
					return "no";
				}

				char open = stack.pop();
				if ((open == '(' && c != ')') || (open == '[' && c != ']')) {
					return "no";
				}
			}
		}
		return stack.isEmpty() ? "yes" : "no";
	}
}
