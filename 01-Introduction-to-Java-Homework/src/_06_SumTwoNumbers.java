import java.util.Scanner;


public class _06_SumTwoNumbers {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter first number: ");
		int a = input.nextInt();
		System.out.println("Enter second number: ");
		int b = input.nextInt();
		
		int sum = a + b;
		System.out.printf("The sum of %d and %d is: %d.", a, b, sum);

	}

}
