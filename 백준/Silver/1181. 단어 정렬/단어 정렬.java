import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		Set<String> set = new HashSet<>();
		while (n-- > 0) {
			String w = br.readLine();
			set.add(w);
		}

		List<String> list = new ArrayList<>(set);
		list.sort((o1, o2) -> {
			if (o1.length() == o2.length()) {
				return o1.compareTo(o2);
			}
			return o1.length() - o2.length();
		});

		for (String w : list) {
			sb.append(w).append("\n");
		}
		System.out.println(sb);
	}
}