import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] arr = new int[7][2];

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			arr[grade][gender]++;
		}

		int count = 0;
		for (int i = 1; i <= 6; i++) {
			for (int j = 0; j <= 1; j++) {
				count += arr[i][j] % k == 0 ? arr[i][j] / k : arr[i][j] / k + 1;
			}
		}

		System.out.println(count);
	}
}
