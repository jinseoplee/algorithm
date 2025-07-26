import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char[] str1 = st.nextToken().toCharArray();
			char[] str2 = st.nextToken().toCharArray();

			int[] cnt1 = new int[26];
			int[] cnt2 = new int[26];

			for (char c : str1) {
				cnt1[c - 'a']++;
			}

			for (char c : str2) {
				cnt2[c - 'a']++;
			}

			String result = "Possible";
			for (int i = 0; i < 26; i++) {
				if (cnt1[i] != cnt2[i]) {
					result = "Impossible";
					break;
				}
			}
			sb.append(result).append("\n");
		}

		System.out.println(sb);
	}
}
