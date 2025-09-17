import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 0;
		int r = 1, c = 1;

		for (int i = 1; i <= 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n > max) {
					max = n;
					r = i;
					c = j;
				}
			}
		}

		System.out.println(max);
		System.out.println(r + " " + c);
	}
}
