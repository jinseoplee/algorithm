import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int c = Integer.parseInt(br.readLine());
			// 손님에게 거스름돈을 최소 개수의 동전으로 주기 위해
			// 쿼터(25센트), 다임(10센트), 니켈(5센트), 페니(1센트) 순서로 최대한 많이 사용한다
			sb.append(c / 25).append(" ");
			c %= 25;
			sb.append(c / 10).append(" ");
			c %= 10;
			sb.append(c / 5).append(" ");
			c %= 5;
			sb.append(c / 1).append("\n");
		}

		// 결과 출력
		System.out.println(sb);
	}
}
