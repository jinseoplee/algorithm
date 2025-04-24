import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] pwd = { 'I', 'L', 'O', 'V', 'E', 'Y', 'O', 'N', 'S', 'E', 'I' };
		char c = br.readLine().charAt(0);

		int sum = 0;
		for (int i = 0; i < pwd.length; i++) {
			sum += Math.abs((pwd[i] - 'A') - (c - 'A'));
			c = pwd[i];
		}
		System.out.println(sum);
	}
}