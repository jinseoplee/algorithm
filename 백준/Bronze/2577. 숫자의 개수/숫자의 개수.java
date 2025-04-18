import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());

		String mul = String.valueOf(a * b * c);

		int[] frequency = new int[10]; // 0 ~ 9
		for (int i = 0; i < mul.length(); i++) {
			int num = mul.charAt(i) - '0';
			frequency[num]++;
		}

		for (int i = 0; i < 10; i++) {
			sb.append(frequency[i]).append("\n");
		}
		System.out.println(sb);
	}
}
