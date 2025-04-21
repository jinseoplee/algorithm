import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int year = Integer.parseInt(br.readLine());
		boolean leapYear = (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
		System.out.println(leapYear ? 1 : 0);
	}
}