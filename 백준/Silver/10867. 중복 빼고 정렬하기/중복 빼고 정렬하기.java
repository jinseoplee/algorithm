import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean[] isPresent = new boolean[2001]; // -1000 ~ 1000

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			isPresent[num + 1000] = true;
		}

		for (int i = 0; i <= 2000; i++) {
			if (isPresent[i]) {
				sb.append(i - 1000).append(" ");
			}
		}
		System.out.println(sb);
	}
}
