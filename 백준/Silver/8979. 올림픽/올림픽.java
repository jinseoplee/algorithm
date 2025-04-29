import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Country implements Comparable<Country> {
	int num, g, s, b;

	Country(int num, int g, int s, int b) {
		this.num = num;
		this.g = g;
		this.s = s;
		this.b = b;
	}

	@Override
	public int compareTo(Country o) {
		if (this.g != o.g) {
			return o.g - this.g;
		}
		if (this.s != o.s) {
			return o.s - this.s;
		}
		return o.b - this.b;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		List<Country> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new Country(num, g, s, b));
		}

		Collections.sort(list);

		int ranking = 1;
		for (int i = 0; i < n; i++) {
			Country curr = list.get(i);

			if (i > 0 && curr.compareTo(list.get(i - 1)) != 0) {
				ranking = i + 1;
			}

			if (curr.num == k) {
				System.out.println(ranking);
				return;
			}
		}
	}
}