import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();
		int len = str.length();
		String[] arr = new String[len];

		for (int i = 0; i < len; i++) {
			arr[i] = str.substring(i);
		}

		Arrays.sort(arr);

		for (String s : arr) {
			sb.append(s).append("\n");
		}

		System.out.print(sb);
	}
}
