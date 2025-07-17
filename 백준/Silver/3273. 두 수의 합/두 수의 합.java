import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int x = Integer.parseInt(br.readLine());

		boolean[] flag = new boolean[1000001];
		int count = 0;

		for (int i = 0; i < n; i++) {
			if ((1 <= x - arr[i] && x - arr[i] <= 1000000) && flag[x - arr[i]]) {
				count++;
			}
			flag[arr[i]] = true;
		}

		System.out.println(count);
	}
}
