import java.util.ArrayList;
import java.util.Scanner;


public class _02 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int d = input.nextInt();
		input.nextLine();
		ArrayList<Integer> numbers = new ArrayList<>();
		String line = input.nextLine();
		int maxSum = Integer.MIN_VALUE;
		int a = 0;
		int b = 0;
		int c = 0;
		boolean magicSumFound = false;
		
		while (!line.equals("End")) {
			numbers.add(Integer.parseInt(line));
			line = input.nextLine();
		}
		
		for (int i = 0; i < numbers.size(); i++) {
			for (int j = i + 1; j < numbers.size(); j++) {
				for (int k = j + 1; k < numbers.size(); k++) {
					int sum = numbers.get(i) + numbers.get(j) + numbers.get(k);
					if (sum % d == 0) {
						if (maxSum < sum) {
							maxSum = sum;
							a = numbers.get(i);
							b = numbers.get(j);
							c = numbers.get(k);
							magicSumFound = true;
						}
					}
					
				}
			}
		}
		if (magicSumFound) {
			System.out.printf("(%d + %d + %d) %% %d = 0", a, b, c, d);
		} else {
			System.out.println("No");
		}

	}

}
