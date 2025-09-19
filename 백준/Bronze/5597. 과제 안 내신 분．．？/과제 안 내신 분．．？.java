import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		boolean[] flag = new boolean[30];

		for (int i = 0; i < 28; i++) {
			flag[Integer.parseInt(br.readLine()) - 1] = true;
		}

		for (int i = 0; i < 30; i++) {
			if (!flag[i]) {
				sb.append(i + 1).append("\n");
			}
		}
		System.out.println(sb);
	}
}
