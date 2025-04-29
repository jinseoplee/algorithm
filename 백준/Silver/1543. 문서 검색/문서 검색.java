import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String doc = br.readLine();
		String word = br.readLine();

		int answer = 0;
		for (int i = 0; i < doc.length();) {
			if (doc.startsWith(word, i)) {
				answer++;
				i += word.length();
			} else {
				i++;
			}
		}

		System.out.println(answer);
	}
}
