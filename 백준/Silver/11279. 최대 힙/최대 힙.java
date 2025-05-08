import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 시간 제한 1초
 * 
 * 우선순위 큐
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 최대 힙
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				sb.append(pq.isEmpty() ? "0" : pq.poll()).append("\n");
			} else {
				pq.offer(x);
			}
		}

		// 결과 출력
		System.out.println(sb);
	}
}
