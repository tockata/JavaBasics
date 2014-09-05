import java.util.Arrays;
import java.util.Scanner;


public class _08_SortArrayOfStrings {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int items = input.nextInt();
		input.nextLine();
		String[] towns = new String[items];
		
		for (int i = 0; i < items; i++) {
			towns[i] = input.nextLine();
		}
		Arrays.sort(towns);
		
		for (String town : towns) {
			System.out.println(town);
		}

	}

}
