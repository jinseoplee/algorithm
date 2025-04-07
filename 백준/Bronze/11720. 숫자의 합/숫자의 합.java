import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer.parseInt(br.readLine());

		char[] arr = br.readLine().toCharArray();
		int sum = 0;
		for (char c : arr) {
			sum += c - '0';
		}
		System.out.println(sum);
	}
}