import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Node implements Comparable<Node> {
	int num, score; // 문제 번호, 점수

	Node(int num, int score) {
		this.num = num;
		this.score = score;
	}

	@Override
	public int compareTo(Node o) {
		return o.score - this.score; // 점수를 기준으로 내림차순 정렬
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 리스트에 8개의 문제 번호와 점수를 저장한다
		List<Node> list = new ArrayList<>();
		for (int i = 1; i <= 8; i++) {
			int score = Integer.parseInt(br.readLine());
			list.add(new Node(i, score));
		}

		// 정렬
		Collections.sort(list);

		// 가장 높은 점수 5개의 합을 구한다
		// 합에 포함되는 문제 번호를 저장한다
		int sum = 0;
		int[] nums = new int[5];
		for (int i = 0; i < 5; i++) {
			Node node = list.get(i);
			sum += node.score;
			nums[i] = node.num;
		}

		Arrays.sort(nums); // 문제 번호를 오름차순 정렬

		sb.append(sum).append("\n");
		for (int i = 0; i < 5; i++) {
			sb.append(nums[i]).append(" ");
		}
		System.out.println(sb);
	}
}