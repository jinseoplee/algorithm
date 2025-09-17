import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] s = br.readLine().toUpperCase().toCharArray();
		int[] freq = new int[26];
		for (char c : s) {
			freq[c - 'A']++;
		}

		int max = 0, idx = 0, cnt = 0;
		for (int i = 0; i < 26; i++) {
			if (freq[i] > max) {
				max = freq[i];
				idx = i;
				cnt = 1;
			} else if (freq[i] == max) {
				cnt++;
			}
		}

		System.out.println(cnt == 1 ? (char) (idx + 'A') : "?");
	}
}
