import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class _06_Count_Specified_Word {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String text = input.nextLine().toLowerCase();
		String wordToSearch = input.nextLine();
		String[] splittedText = text.split("\\W+");
		Map<String, Integer> wordsCount = new HashMap<String, Integer>();
		
		for (String word : splittedText) {
			Integer count = wordsCount.get(word);
			if (count == null) {
				count = 0;
			}
			wordsCount.put(word, count + 1);
		}
		
		if (wordsCount.containsKey(wordToSearch)) {
			System.out.println(wordsCount.get(wordToSearch));
		} else {
			System.out.println(0);
		}
	}

}