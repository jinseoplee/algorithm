import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();

		int count = 0;
		boolean flag = true;

		for (int i = 0; i < str.length; i++) {
			char c = str[i];
			if (c == ' ') {
				flag = true;
			} else {
				if (flag) {
					flag = false;
					count++;
				}
			}
		}

		System.out.println(count);
	}
}
