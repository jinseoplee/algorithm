import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Set<String> set = new HashSet<>();
		List<String> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}

		for (int j = 0; j < m; j++) {
			String name = br.readLine();
			if (set.contains(name)) {
				list.add(name);
			}
		}

		Collections.sort(list);

		sb.append(list.size()).append("\n");
		for (String name : list) {
			sb.append(name).append("\n");
		}
		System.out.println(sb);
	}
}