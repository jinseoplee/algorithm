import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			int num = Integer.parseInt(st.nextToken());
			int current = num;
			int max = num;

			for (int i = 1; i < n; i++) {
				num = Integer.parseInt(st.nextToken());
				current = Math.max(num, num + current);
				max = Math.max(max, current);
			}

			sb.append(max).append("\n");
		}

		System.out.println(sb);
	}
}
