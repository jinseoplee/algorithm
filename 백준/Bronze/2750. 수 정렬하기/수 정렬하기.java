import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 시간 제한 1초 
 * 1 <= n <= 1,000
 * 
 * 정렬, O(n^2), O(nlogn), O(n) 가능
 *
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		boolean[] arr = new boolean[2001]; // -1000 ~ 1000

		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			int num = Integer.parseInt(br.readLine());
			arr[num + 1000] = true;
		}

		for (int i = 0; i <= 2000; i++) {
			if (arr[i]) {
				sb.append(i - 1000).append("\n");
			}
		}
		System.out.println(sb);
	}
}