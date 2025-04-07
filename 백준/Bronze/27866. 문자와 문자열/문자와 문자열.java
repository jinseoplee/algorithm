import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int i = Integer.parseInt(br.readLine()) - 1;
		for (int idx = 0; idx < s.length(); idx++) {
			if (idx == i) {
				System.out.println(s.charAt(i));
				break;
			}
		}
	}
}