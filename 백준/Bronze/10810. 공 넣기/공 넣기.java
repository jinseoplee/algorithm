import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시뮬레이션 
 * 시간 복잡도 = O(n * m)
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 입력 처리
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];

		// m번 동안 i부터 j까지 k 숫자의 공을 넣는다
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()) - 1;
			int j = Integer.parseInt(st.nextToken()) - 1;
			int k = Integer.parseInt(st.nextToken());
			for (int idx = i; idx <= j; idx++) {
				arr[idx] = k;
			}
		}

		for (int i = 0; i < n; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb);
	}
}