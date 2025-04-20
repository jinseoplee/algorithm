import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] arr = new int[10001]; // 0 ~ 10000

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}

		for (int i = 0; i <= 10000; i++) {
			for (int j = 0; j < arr[i]; j++) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
	}
}