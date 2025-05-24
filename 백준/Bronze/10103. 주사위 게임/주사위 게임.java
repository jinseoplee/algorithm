import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int cScore = 100, sScore = 100; // 창영이와 상덕이의 점수

		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cNum = Integer.parseInt(st.nextToken());
			int sNum = Integer.parseInt(st.nextToken());

			if (cNum > sNum) {
				sScore -= cNum;
			} else if (cNum < sNum) {
				cScore -= sNum;
			}
		}

		System.out.println(cScore);
		System.out.println(sScore);
	}
}