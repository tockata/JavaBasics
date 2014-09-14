import java.util.Scanner;


public class _02_Generate_3_Letter_Words {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String letters = input.nextLine();
		
		for (int i = 0; i < letters.length(); i++) {
			for (int j = 0; j < letters.length(); j++) {
				for (int k = 0; k < letters.length(); k++) {
					String result = letters.charAt(i) + "" + letters.charAt(j) + "" + letters.charAt(k); 
					System.out.print(result + " ");
				}
			}
		}

	}

}
