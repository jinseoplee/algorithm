public class Main {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();

		boolean[] flag = new boolean[10001];

		for (int i = 1; i <= 10000; i++) {
			int n = i;
			int dn = n;

			// 각 자릿수를 더한다
			while (n != 0) {
				dn += n % 10;
				n /= 10;
			}

			if (dn <= 10000) {
				flag[dn] = true;
			}
		}

		for (int i = 1; i <= 10000; i++) {
			if (!flag[i]) {
				sb.append(i).append("\n");
			}
		}

		System.out.println(sb);
	}
}