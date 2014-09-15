import java.util.ArrayList;
import java.util.Scanner;


public class _14_StuckNumbers {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		ArrayList<Integer> numbers = new ArrayList<>();
		boolean sequenceFound = false;
		
		for (int i = 0; i < n; i++) {
			numbers.add(Integer.parseInt(input.next()));
		}
		
		for (int i = 0; i < numbers.size(); i++) {
			for (int j = 0; j < numbers.size(); j++) {
				for (int j2 = 0; j2 < numbers.size(); j2++) {
					for (int k = 0; k < numbers.size(); k++) {
						int a = numbers.get(i);
						int b = numbers.get(j);
						int c = numbers.get(j2);
						int d = numbers.get(k);
						
						if (a != b && b != c && c != d && d != a && a != c && b != d) {
							String left = a + "" + b;
							String right = c + "" + d;
							
							if (left.equals(right)) {
								System.out.println(a + "|" + b + "==" + c + "|" + d);
								sequenceFound = true;
							}
						}
					}
				}
			}
		}
		if (!sequenceFound) {
			System.out.println("No");
		}

	}

}
