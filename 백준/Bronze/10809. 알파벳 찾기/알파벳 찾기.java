import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] arr = new int[26];
		Arrays.fill(arr, -1);

		char[] word = br.readLine().toCharArray();
		for (int i = 0; i < word.length; i++) {
			char c = word[i]; // i번째 문자 가져오기
			if (arr[c - 'a'] == -1) {
				arr[c - 'a'] = i; // 첫 등장 위치 기록
			}
		}

		for (int i = 0; i < 26; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb);
	}
}