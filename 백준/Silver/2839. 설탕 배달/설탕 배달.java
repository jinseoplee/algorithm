import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 시간 제한 1초
 * 
 * 3 <= n <= 5,000
 * 
 * 그리디
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int c = 0;

		while (n > 0) {
			if (n % 5 == 0) {
				c += n / 5;
				break;
			}
			n -= 3;
			c++;
		}

		System.out.println(n < 0 ? -1 : c);
	}
}
