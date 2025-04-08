import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			String str = br.readLine();
			int count = 0;

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
					count++;
					continue;
				}

				if (--count < 0) {
					break;
				}
			}

			sb.append(count == 0 ? "YES" : "NO").append("\n");
		}

		System.out.println(sb);
	}
}
