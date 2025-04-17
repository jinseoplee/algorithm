import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int m = Integer.parseInt(br.readLine());
		int bitset = 0;

		while (m-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int x = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;

			switch (cmd) {
			case "add":
				bitset |= (1 << x);
				break;
			case "remove":
				bitset &= ~(1 << x);
				break;
			case "check":
				sb.append((bitset & (1 << x)) != 0 ? 1 : 0).append("\n");
				break;
			case "toggle":
				bitset ^= (1 << x);
				break;
			case "all":
				bitset = (1 << 21) - 1;
				break;
			case "empty":
				bitset = 0;
				break;
			}
		}

		System.out.println(sb);
	}
}