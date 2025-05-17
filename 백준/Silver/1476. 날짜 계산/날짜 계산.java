import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1 <= e <= 15 
 * 1 <= s <= 28 
 * 1 <= m <= 19
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int targetE = Integer.parseInt(st.nextToken());
		int targetS = Integer.parseInt(st.nextToken());
		int targetM = Integer.parseInt(st.nextToken());

		int e = 1, s = 1, m = 1, y = 1;
		while (e != targetE || s != targetS || m != targetM) {
			e++;
			s++;
			m++;
			if (e > 15) e = 1;
			if (s > 28) s = 1;
			if (m > 19) m = 1;
			y++;
		}

		System.out.println(y);
	}
}