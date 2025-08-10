import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();

		int[] freq1 = new int[26];
		int[] freq2 = new int[26];

		for (char c : str1) {
			freq1[c - 'a']++;
		}

		for (char c : str2) {
			freq2[c - 'a']++;
		}

		int removalCount = 0;
		for (int i = 0; i < 26; i++) {
			removalCount += Math.abs(freq1[i] - freq2[i]);
		}
		System.out.println(removalCount);
	}
}