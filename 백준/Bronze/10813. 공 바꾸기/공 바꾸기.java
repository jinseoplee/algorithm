import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시뮬레이션 
 * 시간 복잡도 = O(m)
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 입력 처리
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = i;
		}

		// m번 동안 반복한다
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			// i번 바구니와 j번 바구니에 있는 공을 교환한다
			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}

		for (int i = 1; i <= n; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb);
	}
}