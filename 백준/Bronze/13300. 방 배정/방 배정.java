import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] arr = new int[6][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken()) - 1;
			arr[y][s]++;
		}

		int count = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 2; j++) {
				count += (arr[i][j] + k - 1) / k;
			}
		}

		System.out.println(count);
	}
}
