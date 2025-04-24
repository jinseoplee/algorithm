import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			String name = br.readLine();
			if (name.equals("anj")) {
				System.out.println("뭐야;");
				return;
			}
		}
		System.out.println("뭐야?");
	}
}