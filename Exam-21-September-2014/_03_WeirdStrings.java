import java.util.ArrayList;
import java.util.Scanner;


public class _03 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String text = input.nextLine().replaceAll("[\\\\/\\|\\(\\)\\s]+", "");
		String[] words = text.split("[^A-Za-z]+");
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		ArrayList<Integer> sums = new ArrayList<>();

		int maxSum = 0;
		int maxStartIndex = 0;
		int sum = 0;
		
		for (String word : words) {
			word = word.toLowerCase();
			for (int i = 0; i < word.length(); i++) {
				sum += alphabet.indexOf(word.charAt(i) + 1);
			}
			sums.add(sum);
			sum = 0;
		}
		
		for (int i = 0; i < sums.size() - 1; i++) {
			sum = sums.get(i) + sums.get(i + 1);
			if (sum >= maxSum) {
				maxSum = sum;
				maxStartIndex = i;
				sum = 0;
			}
		}
		System.out.println(words[maxStartIndex]);
		System.out.println(words[maxStartIndex + 1]);

	}

}
