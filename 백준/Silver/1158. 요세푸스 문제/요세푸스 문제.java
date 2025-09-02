import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("<");

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}

		int idx = 0;
		while (!list.isEmpty()) {
			idx = (idx + k - 1) % list.size();
			sb.append(list.remove(idx));
			if (!list.isEmpty()) {
				sb.append(", ");
			}

		}
		sb.append(">");

		System.out.println(sb);
	}
}