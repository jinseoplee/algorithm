import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		String[] arr = new String[n + 1]; // 번호 -> 이름
		Map<String, Integer> map = new HashMap<>(); // 이름 -> 번호

		for (int i = 1; i <= n; i++) {
			String name = br.readLine();
			map.put(name, i);
			arr[i] = name;
		}

		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			if (str.charAt(0) <= '9') {
				sb.append(arr[Integer.parseInt(str)]);
			} else {
				sb.append(map.get(str));
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}