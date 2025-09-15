import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int tmp = b;

		for (int i = 0; i < 3; i++) {
			sb.append(a * (tmp % 10)).append("\n");
			tmp /= 10;
		}
		sb.append(a * b);

		System.out.println(sb);
	}
}
