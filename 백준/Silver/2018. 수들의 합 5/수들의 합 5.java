import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int l = 1;
		int r = 1;
		int s = 1;
		int c = 0;
		while (r <= n) {
			if (s < n) {
				s += ++r;
			} else if (s == n) {
				s += ++r;
				c++;
			} else { // s > n
				s -= l++;
			}
		}
		System.out.println(c);
	}
}