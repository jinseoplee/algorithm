import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int n = sc.nextInt();
		long[] arr = new long[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(new StringBuilder(sc.next()).reverse().toString());
		}

		// 오름차순 정렬
		Arrays.sort(arr);

		// 결과 출력
		for (long num : arr) {
			sb.append(num).append("\n");
		}
		System.out.println(sb);
	}
}
