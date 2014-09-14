import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;


public class _15_StraightFlush {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String allCards = input.nextLine().toUpperCase();
		String[] cards = allCards.split("[, ]+");
		TreeMap<Character, ArrayList<Integer>> hand = new TreeMap<>();
		boolean straightFlishFound = false;
		
		for (String card : cards) {
			if (card.length() == 2) {
				if (!hand.containsKey(card.charAt(1))) {
					hand.put(card.charAt(1), new ArrayList<>());
				}
				switch (card.charAt(0)) {
				case 'J': hand.get(card.charAt(1)).add(11); break;
				case 'Q': hand.get(card.charAt(1)).add(12); break;
				case 'K': hand.get(card.charAt(1)).add(13); break;
				case 'A': hand.get(card.charAt(1)).add(14); break;
				default: hand.get(card.charAt(1)).add(Character.getNumericValue(card.charAt(0)));;
				}
			} else {
				if (!hand.containsKey(card.charAt(2))) {
					hand.put(card.charAt(2), new ArrayList<>());
				}
					hand.get(card.charAt(2)).add(10);
			}
			
		}
		for (Entry<Character, ArrayList<Integer>> hands : hand.entrySet()) {
			ArrayList<Integer> c = hands.getValue();
			Collections.sort(c);
			if (c.size() >= 5) {
				for (int i = 0; i < c.size() - 4; i++) {
					if (c.get(i + 4) - 1 == c.get(i + 3) && c.get(i + 3) - 1 == c.get(i + 2) &&
						c.get(i + 2) - 1 == c.get(i + 1) && c.get(i + 1) - 1 == c.get(i)) {
						System.out.print("[");
						for (int j = i; j < i + 5; j++) {
							if (j != i + 4) {
								switch (c.get(j)) {
								case 11: System.out.print("J" + hands.getKey() + ", "); break;
								case 12: System.out.print("Q" + hands.getKey() + ", "); break;
								case 13: System.out.print("K" + hands.getKey() + ", "); break;
								case 14: System.out.print("A" + hands.getKey() + ", "); break;
								default: System.out.print("" + c.get(j) + hands.getKey() + ", "); break;
								}

							} else {
								switch (c.get(j)) {
								case 11: System.out.print("J" + hands.getKey() + "]"); break;
								case 12: System.out.print("Q" + hands.getKey() + "]"); break;
								case 13: System.out.print("K" + hands.getKey() + "]"); break;
								case 14: System.out.print("A" + hands.getKey() + "]"); break;
								default: System.out.print("" + c.get(j) + hands.getKey() + "]"); break;
								}
							}
						}
						System.out.println();
						straightFlishFound = true;
					}
				}
			}
		}
		if (!straightFlishFound) {
			System.out.println("No Straight Flushes");
		}

	}

}
