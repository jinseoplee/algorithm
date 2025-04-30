import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			// 층과 호를 구한다
			int floor = (n % h == 0) ? h : n % h;
			int room = (n % h == 0) ? n / h : n / h + 1;

			sb.append(floor).append(String.format("%02d", room)).append("\n");
		}
		System.out.println(sb);
	}
}
