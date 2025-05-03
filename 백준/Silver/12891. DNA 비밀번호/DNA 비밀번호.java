import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시간 제한 2초 
 * 1 <= p <= s <= 1,000,000
 * 
 * 슬라이딩 윈도우 = O(s)
 */
public class Main {
	static int s, p, answer;
	static char[] dna;
	static int a, c, g, t;
	static int aCnt, cCnt, gCnt, tCnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 처리
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());

		dna = br.readLine().toCharArray();

		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		// 슬라이딩 윈도우
		for (int i = 0; i < p; i++) {
			add(dna[i]);
		}

		make();

		for (int i = p; i < s; i++) {
			remove(dna[i - p]);
			add(dna[i]);
			make();
		}

		System.out.println(answer);
	}

	static void add(char c) {
		if (c == 'A') {
			aCnt++;
		} else if (c == 'C') {
			cCnt++;
		} else if (c == 'G') {
			gCnt++;
		} else if (c == 'T') {
			tCnt++;
		}
	}

	static void remove(char c) {
		if (c == 'A') {
			aCnt--;
		} else if (c == 'C') {
			cCnt--;
		} else if (c == 'G') {
			gCnt--;
		} else if (c == 'T') {
			tCnt--;
		}
	}

	static void make() {
		if (aCnt >= a && cCnt >= c && gCnt >= g && tCnt >= t) {
			answer++;
		}
	}
}