import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Student implements Comparable<Student> {
	String name;
	int korean, english, math;

	Student(String name, int korean, int english, int math) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}

	@Override
	public int compareTo(Student o) {
		if (this.korean != o.korean) {
			return o.korean - this.korean;
		} else if (this.english != o.english) {
			return this.english - o.english;
		} else if (this.math != o.math) {
			return o.math - this.math;
		} else {
			return this.name.compareTo(o.name);
		}
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		List<Student> list = new ArrayList<>();

		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int korean = Integer.parseInt(st.nextToken());
			int english = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			list.add(new Student(name, korean, english, math));
		}

		Collections.sort(list);

		for (Student e : list) {
			sb.append(e.name).append("\n");
		}
		System.out.println(sb);
	}
}
