import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int current = Integer.parseInt(st.nextToken());
		int max = current;

		for (int i = 1; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			current = Math.max(num, current + num);
			max = Math.max(max, current);
		}

		System.out.println(max);
	}
}
