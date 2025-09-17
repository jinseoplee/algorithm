import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] words = new String[5];
		int maxLen = 0;

		for (int i = 0; i < 5; i++) {
			words[i] = br.readLine();
			maxLen = Math.max(maxLen, words[i].length());
		}

		for (int i = 0; i < maxLen; i++) {
			for (int j = 0; j < 5; j++) {
				if (i < words[j].length()) {
					sb.append(words[j].charAt(i));
				}
			}
		}

		System.out.println(sb);
	}
}
