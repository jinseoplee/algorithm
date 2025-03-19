import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int studentCount = Integer.parseInt(br.readLine());
		while (studentCount-- > 0) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			changeState(gender, num);
		}

		for (int i = 1; i <= n; i++) {
			sb.append(arr[i]).append(" ");
			if (i % 20 == 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	private static void changeState(int gender, int num) {
		if (gender == 1) {
			for (int i = num; i <= n; i += num) {
				arr[i] ^= 1;
			}
		} else {
			arr[num] ^= 1;
			int left = num - 1;
			int right = num + 1;
			while (left >= 1 && right <= n) {
				if (arr[left] != arr[right]) {
					break;
				}
				arr[left] ^= 1;
				arr[right] ^= 1;
				left--;
				right++;
			}
		}
	}
}