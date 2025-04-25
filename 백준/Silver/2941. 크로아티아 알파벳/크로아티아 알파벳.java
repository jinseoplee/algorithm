import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();

		String[] alphabets = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
		for (String a : alphabets) {
			word = word.replace(a, ".");
		}

		System.out.println(word.length());
	}
}