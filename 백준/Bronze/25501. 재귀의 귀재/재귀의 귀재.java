import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String s = br.readLine();
			int[] res = isPalindrome(s);
			sb.append(res[0]).append(" ").append(res[1]).append("\n");
		}
		System.out.println(sb);
	}

	public static int[] recursion(String s, int l, int r) {
		if (l >= r) {
			return new int[] { 1, 1 };
		}
		if (s.charAt(l) != s.charAt(r)) {
			return new int[] { 0, 1 };
		}
		int[] res = recursion(s, l + 1, r - 1);
		return new int[] { res[0], res[1] + 1 };
	}

	public static int[] isPalindrome(String s) {
		return recursion(s, 0, s.length() - 1);
	}
}
