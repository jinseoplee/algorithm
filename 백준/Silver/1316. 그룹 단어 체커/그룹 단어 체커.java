import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int count = n;

		while (n-- > 0) {
			char[] word = br.readLine().toCharArray();
			boolean[] flag = new boolean[26]; // 알파벳 사용 여부

			flag[word[0] - 'a'] = true;
			for (int i = 1; i < word.length; i++) {
				if (word[i] != word[i - 1]) { // 이전 문자와 다른 문자인 경우
					if (flag[word[i] - 'a']) { // 이미 등장했던 문자라면 그룹 단어가 아니다
						count--;
						break;
					}
					flag[word[i] - 'a'] = true;
				}
			}
		}

		System.out.println(count);
	}
}