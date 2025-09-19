import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String a = new StringBuilder(st.nextToken()).reverse().toString();
		String b = new StringBuilder(st.nextToken()).reverse().toString();
		int aNum = Integer.parseInt(a);
		int bNum = Integer.parseInt(b);
		System.out.println(Math.max(aNum, bNum));
	}
}
