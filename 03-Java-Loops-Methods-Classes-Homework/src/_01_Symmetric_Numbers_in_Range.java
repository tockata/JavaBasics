import java.util.Scanner;


public class _01_Symmetric_Numbers_in_Range {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int start = input.nextInt();
		int end = input.nextInt();
		
		for (int i = start; i <= end; i++) {
			String number = Integer.toString(i);
			boolean symmetric = isSymmetric(number);
			if (symmetric) {
				System.out.print(number + " ");
			}
		}

	}

	private static boolean isSymmetric(String number) {
		boolean isSymmetric = true;
		if (number.length() == 1) {
			return true;
		}
		else {
			for (int i = 0, j = number.length() - 1; i <= number.length() / 2; i++, j--) {
				if (number.charAt(i) != number.charAt(j)) {
					isSymmetric = false;
					break;
				} 
			}
		}
		return isSymmetric;
	}

}
