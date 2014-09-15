import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class _12_Cards_Frequencies {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] cards = input.nextLine().split("\\W+");
		
		Map<String, Integer> cardsCount = new LinkedHashMap<String, Integer>();
		cardsCount = fillHashMap(cards, cardsCount);
		double sumOfValues = calcSumOfValues(cardsCount);
		
		printResult(cardsCount, sumOfValues);

	}

	public static void printResult(Map<String, Integer> cardsCount,
			double sumOfValues) {
		for (Map.Entry<String, Integer> card : cardsCount.entrySet()) {
			double frequency = (card.getValue() / sumOfValues) * 100;
			System.out.printf("%s -> %.2f%%", card.getKey(), frequency);
			System.out.println();
		}
	}

	private static double calcSumOfValues(Map<String, Integer> cardsCount) {
		double sumOfValues = 0;
		for (Map.Entry<String, Integer> card : cardsCount.entrySet()) {
			sumOfValues += card.getValue();
		}
		return sumOfValues;
	}

	public static Map<String, Integer> fillHashMap(String[] cards,	Map<String, Integer> cardsCount) {
		for (String card : cards) {
			Integer count = cardsCount.get(card);
			if (count == null) {
				count = 0;
			}
			cardsCount.put(card, count + 1);
		}
		return cardsCount;
	}

}
