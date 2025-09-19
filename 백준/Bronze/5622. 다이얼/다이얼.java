import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] word = br.readLine().toCharArray();

		int[] dial = { 
				3, 3, 3, // A,B,C
				4, 4, 4, // D,E,F
				5, 5, 5, // G,H,I
				6, 6, 6, // J,K,L
				7, 7, 7, // M,N,O
				8, 8, 8, 8, // P,Q,R,S
				9, 9, 9, // T,U,V
				10, 10, 10, 10 // W,X,Y,Z
		};

		int time = 0;
		for (char c : word) {
			time += dial[c - 'A'];
		}
		System.out.println(time);
	}
}
