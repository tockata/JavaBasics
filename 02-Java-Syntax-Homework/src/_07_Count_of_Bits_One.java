import java.util.Scanner;


public class _07_Count_of_Bits_One {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		
		int ones = 0;
		
		while (number > 0) {
			int bit = number & 1;
			if (bit == 1) {
				ones++;
			}
			number >>= 1;
		}
		System.out.println(ones);

	}

}
