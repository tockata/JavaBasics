import java.util.Scanner;


public class _06_Formatting_Numbers {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		float b = input.nextFloat();
		float c = input.nextFloat();
		
		String aInBinaryString = Integer.toBinaryString(a);
		int aInBinary = Integer.parseInt(aInBinaryString);
		
		System.out.printf("|%-10X|%010d|%10.2f|%-10.3f|", a, aInBinary, b, c);

	}

}
