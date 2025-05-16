import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 시간 제한 1초 
 * 1 <= n, m <= 20,000
 * 
 * 정렬 + 이분 탐색 풀이 
 * 시간 복잡도 = O(m log m + n * log m)
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int[] aArr = new int[a];
			int[] bArr = new int[b];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < a; i++) {
				aArr[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < b; i++) {
				bArr[i] = Integer.parseInt(st.nextToken());
			}

			// b 생명체 배열을 오름차순으로 정렬한 뒤
			// b 배열에서 a보다 작은 생명체의 개수를 이진 탐색으로 구함
			Arrays.sort(bArr);

			int count = 0;
			for (int i = 0; i < a; i++) {
				int target = aArr[i];

				int s = 0;
				int e = b - 1;
				while (s <= e) {
					int m = (s + e) / 2;
					if (target > bArr[m]) {
						s = m + 1;
					} else {
						e = m - 1;
					}
				}

				count += s;
			}

			sb.append(count).append("\n");
		}

		System.out.println(sb);
	}
}
