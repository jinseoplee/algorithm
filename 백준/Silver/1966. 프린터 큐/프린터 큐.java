import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Document {
	int index, priority;

	Document(int index, int priority) {
		this.index = index;
		this.priority = priority;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			Queue<Document> printer = new LinkedList<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				printer.add(new Document(i, Integer.parseInt(st.nextToken())));
			}

			int order = 0;
			while (!printer.isEmpty()) {
				int maxPriority = getMaxPriority(printer);

				while (printer.peek().priority != maxPriority) {
					printer.offer(printer.poll());
				}

				Document printed = printer.poll();
				order++;

				if (printed.index == m) {
					sb.append(order).append("\n");
					break;
				}
			}
		}

		System.out.println(sb);
	}

	static int getMaxPriority(Queue<Document> printer) {
		int maxPriority = 0;
		for (Document document : printer) {
			maxPriority = Math.max(maxPriority, document.priority);
		}
		return maxPriority;
	}
}