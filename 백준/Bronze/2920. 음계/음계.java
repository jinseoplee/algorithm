import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int prev = Integer.parseInt(st.nextToken());
		boolean ascending = true;
		boolean descending = true;

		for (int i = 0; i < 7; i++) {
			int current = Integer.parseInt(st.nextToken());

			if (prev + 1 != current) {
				ascending = false;
			}

			if (prev - 1 != current) {
				descending = false;
			}

			prev = current;
		}

		if (ascending) {
			System.out.println("ascending");
		} else if (descending) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
	}
}