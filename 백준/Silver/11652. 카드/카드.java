import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<Long, Integer> map = new HashMap<>(); // 숫자, 개수

		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			long num = Long.parseLong(br.readLine());
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		long findNum = 0;
		int maxCnt = 0;

		for (Map.Entry<Long, Integer> e : map.entrySet()) {
			if (e.getValue() > maxCnt) {
				maxCnt = e.getValue();
				findNum = e.getKey();
			} else if (e.getValue() == maxCnt) {
				findNum = Math.min(findNum, e.getKey());
			}
		}

		System.out.println(findNum);
	}
}
