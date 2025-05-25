import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n];
		int[] b = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}

		// a 배열을 오름차순으로 정렬한다
		Arrays.sort(a);

		// s의 최솟값을 만들기 위해 a의 가장 작은 값부터 b의 가장 큰 값부터 차례로 곱해서 더한다
		int s = 0;
		for (int i = 0; i < n; i++) {
			int maxValue = -1;
			int maxIdx = -1;

			for (int j = 0; j < n; j++) {
				if (b[j] != -1 && b[j] > maxValue) {
					maxValue = b[j];
					maxIdx = j;
				}
			}

			s += a[i] * b[maxIdx];
			b[maxIdx] = -1;
		}

		// 결과 출력
		System.out.println(s);
	}
}
