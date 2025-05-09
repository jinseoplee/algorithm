import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			// 입력 처리
			String input = br.readLine();

			// 루프 탈출 조건
			if (input.equals("0")) {
				break;
			}

			String result = "yes";
			for (int i = 0; i < input.length() / 2; i++) {
				if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
					result = "no";
					break;
				}
			}
			sb.append(result).append("\n");
		}

		System.out.println(sb);
	}
}
