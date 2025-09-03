import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		List<Character> list = new LinkedList<>();
		for (char c : br.readLine().toCharArray()) {
			list.add(c);
		}

		ListIterator<Character> it = list.listIterator(list.size());

		int m = Integer.parseInt(br.readLine());
		while (m-- > 0) {
			String cmd = br.readLine();
			char c = cmd.charAt(0);

			switch (c) {
			case 'L':
				if (it.hasPrevious()) {
					it.previous();
				}
				break;
			case 'D':
				if (it.hasNext()) {
					it.next();
				}
				break;
			case 'B':
				if (it.hasPrevious()) {
					it.previous();
					it.remove();
				}
				break;
			case 'P':
				it.add(cmd.charAt(2));
				break;
			}
		}

		for (char c : list) {
			sb.append(c);
		}
		System.out.println(sb);
	}
}
