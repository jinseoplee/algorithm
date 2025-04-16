import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		String c = br.readLine();

		// 숫자로 계산
		int numA = Integer.parseInt(a);
		int numB = Integer.parseInt(b);
		int numC = Integer.parseInt(c);

		System.out.println(numA + numB - numC); // 정수 연산
		System.out.println(Integer.parseInt(a + b) - numC);
	}
}