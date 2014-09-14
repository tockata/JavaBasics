import java.util.ArrayList;
import java.util.Scanner;


public class _12_CognateWords {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String text = input.nextLine();
		
		String[] words = text.split("[\\W\\d]+");
		ArrayList<String> results = new ArrayList<>();
		
		if (words.length > 2) {
			for (int i = 0; i < words.length; i++) {
				for (int j = 0; j < words.length; j++) {
					for (int j2 = 0; j2 < words.length; j2++) {
						if ((words[i] + words[j]).equals(words[j2])) {
							if (!results.contains(words[i] + "|" + words[j] + "=" + words[j2])) {
								results.add(words[i] + "|" + words[j] + "=" + words[j2]);
							}
						}
					}
				}
			}
		}
		
		if (results.size() == 0) {
			System.out.println("No");
		} else {
			for (String result : results) {
				System.out.println(result);
			}
		}

	}

}
