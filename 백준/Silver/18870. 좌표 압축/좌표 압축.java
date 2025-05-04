import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 시간 제한 2초 
 * 1 <= n <= 1,000,000 
 * -1,000,000,000 <= x <= 1,000,000,000
 * 
 * 시간 복잡도 O(n log n)
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] origin = new int[n];
		int[] sorted = new int[n];
		int compressedIndex = 0;
		Map<Integer, Integer> map = new HashMap<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			origin[i] = sorted[i] = Integer.parseInt(st.nextToken());
		}

		// 오름차순 정렬
		Arrays.sort(sorted);

		for (int i = 0; i < n; i++) {
			if (!map.containsKey(sorted[i])) {
				map.put(sorted[i], compressedIndex);
				compressedIndex++;
			}
		}

		for (int i = 0; i < n; i++) {
			sb.append(map.get(origin[i])).append(" ");
		}
		System.out.println(sb);
	}
}