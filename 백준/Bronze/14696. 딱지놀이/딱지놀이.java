import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			int[] countA = new int[5];
			int[] countB = new int[5];

			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			for (int i = 0; i < a; i++) {
				countA[Integer.parseInt(st.nextToken())]++;
			}

			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			for (int i = 0; i < b; i++) {
				countB[Integer.parseInt(st.nextToken())]++;
			}

			String result = "D";
			for (int i = 4; i >= 1; i--) {
				if (countA[i] > countB[i]) {
					result = "A";
					break;
				} else if (countA[i] < countB[i]) {
					result = "B";
					break;
				}
			}
			sb.append(result).append("\n");
		}

		System.out.println(sb);
	}
}
