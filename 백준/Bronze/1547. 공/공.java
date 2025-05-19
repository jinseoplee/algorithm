import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[4]; // 1, 2, 3
		arr[1] = 1;

		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int tmp = arr[x];
			arr[x] = arr[y];
			arr[y] = tmp;
		}

		int idx = 0;
		for (int i = 1; i <= 3; i++) {
			if (arr[i] == 1) {
				idx = i;
				break;
			}
		}

		System.out.println(idx);
	}
}