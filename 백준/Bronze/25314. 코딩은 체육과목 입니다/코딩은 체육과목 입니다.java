import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int cnt = n / 4;
		while (cnt-- > 0) {
			sb.append("long ");
		}
		sb.append("int");
		System.out.println(sb);
	}
}
