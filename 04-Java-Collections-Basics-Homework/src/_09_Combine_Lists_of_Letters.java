import java.util.ArrayList;
import java.util.Scanner;


public class _09_Combine_Lists_of_Letters {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] firstLine = input.nextLine().split(" ");
		String[] secondLine = input.nextLine().split(" ");
		
		ArrayList<Character> l1 = new ArrayList<Character>();
		ArrayList<Character> l2 = new ArrayList<Character>();
		
		l1 = addCharacters(firstLine, l1);
		l2 = addCharacters(secondLine, l2);
		ArrayList<Character> result = new ArrayList<Character>(l1);
		
		result = addCharactersFroml2(l1, l2, result);
		
		printResult(result, l1);

	}

	private static void printResult(ArrayList<Character> result, ArrayList<Character> l1) {
		for (Character character : result) {
			System.out.print(character + " ");
		}
	}

	private static ArrayList<Character> addCharactersFroml2(ArrayList<Character> l1, 
			ArrayList<Character> l2, ArrayList<Character> result) {
		for (Character character : l2) {
			if (!l1.contains(character)) {
				result.add(character);
			}
		}
		return result;
	}

	private static ArrayList<Character> addCharacters(String[] line, ArrayList<Character> list) {
		for (String character : line) {
			list.add(character.charAt(0));
		}
		return list;
	}

}
