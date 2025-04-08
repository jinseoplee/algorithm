import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		ArrayList<String>[] list = new ArrayList[201];
		for (int i = 1; i <= 200; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			list[age].add(name);
		}

		for (int i = 1; i <= 200; i++) {
			for (String name : list[i]) {
				sb.append(i).append(" ").append(name).append("\n");
			}
		}
		System.out.println(sb);
	}
}