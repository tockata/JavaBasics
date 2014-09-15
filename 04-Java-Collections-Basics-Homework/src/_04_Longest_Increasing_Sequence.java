import java.util.Scanner;


public class _04_Longest_Increasing_Sequence {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String numbers = input.nextLine();
		String[] numbersArray = numbers.split(" ");
		
		int[] integers = new int[numbersArray.length];
		integers = convertToInt(numbersArray, integers);
		
		int maxCount = Integer.MIN_VALUE;
		int tempCount = 1;
		int maxEndIndex = 0;
		int tempEndIndex = 0;
		
		for (int i = 0; i < integers.length - 1; i++) {
			if (integers[i] < integers[i + 1]) {
				tempCount++;
				tempEndIndex = i + 1;
				if (i == integers.length - 2) {
					if (tempCount > maxCount) {
						maxCount = tempCount;
						maxEndIndex = tempEndIndex;
					}
					int startIndex = tempEndIndex - tempCount + 1;
					for (int j = startIndex; j <= tempEndIndex; j++) {
						System.out.print(integers[j] + " ");
					}
					System.out.println();
				}
			} else {
				if (tempCount > maxCount) {
					maxCount = tempCount;
					maxEndIndex = tempEndIndex;
				}
				int startIndex = tempEndIndex - tempCount + 1;
				for (int j = startIndex; j <= tempEndIndex; j++) {
					System.out.print(integers[j] + " ");
				}
				System.out.println();
				tempCount = 1;
				tempEndIndex = i + 1;
			}
		}
		
		int startIndex = maxEndIndex - maxCount + 1;
		System.out.print("Longest: ");
		for (int j = startIndex; j <= maxEndIndex; j++) {
			System.out.print(integers[j] + " ");
		}

	}

	private static int[] convertToInt(String[] numbersArray, int[] integers) {
		for (int i = 0; i < numbersArray.length; i++) {
			integers[i] = Integer.parseInt(numbersArray[i]);
		}
		return integers;
	}

}
