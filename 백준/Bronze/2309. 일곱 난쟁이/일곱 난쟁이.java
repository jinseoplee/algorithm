import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 아홉 난쟁이의 키를 모두 더한 후, 두 명을 제외했을 때 합이 100이 되는 조합을 찾는다. 
 * 정렬 + 브루트 포스 O(n log n + n^2)
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] h = new int[9];
		int sum = 0;

		for (int i = 0; i < 9; i++) {
			h[i] = Integer.parseInt(br.readLine());
			sum += h[i];
		}

		// 오름차순 정렬
		Arrays.sort(h);

		// 두 명을 제외했을 때 합이 100이 되는 조합을 찾는다
		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - h[i] - h[j] == 100) {
					for (int k = 0; k < 9; k++) {
						if (k != i && k != j) {
							System.out.println(h[k]);
						}
					}
					return;
				}
			}
		}
	}
}