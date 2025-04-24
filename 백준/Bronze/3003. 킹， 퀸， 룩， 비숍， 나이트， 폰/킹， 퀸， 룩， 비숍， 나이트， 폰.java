import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] arr = { 1, 1, 2, 2, 2, 8 };

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			int n = Integer.parseInt(st.nextToken());
			sb.append(arr[i] - n).append(" ");
		}

		System.out.println(sb);
	}
}