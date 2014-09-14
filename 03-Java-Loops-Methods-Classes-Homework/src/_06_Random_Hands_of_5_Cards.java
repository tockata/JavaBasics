import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class _06_Random_Hands_of_5_Cards {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n  = input.nextInt();
		
		String[] faces = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		char[] suits = {'\u2660','\u2665', '\u2666', '\u2663'};
		ArrayList<String> deckOfCards = new ArrayList<String>();
		
		for (int i = 0; i < faces.length; i++) {
			for (int j = 0; j < suits.length; j++) {
				String card = faces[i] + suits[j];
				deckOfCards.add(card);
			}
		}
		
		Random rnd = new Random();
		for (int i = 0; i < n; i++) {
			ArrayList<String> hand = generateHand(deckOfCards, rnd);
			printHand(hand);
		}

	}

	private static void printHand(ArrayList<String> hand) {
		for (String card : hand) {
			System.out.print(card + " ");
		}
		System.out.println();
		
	}

	private static ArrayList<String> generateHand(ArrayList<String> deckOfCards, Random rnd) {
		ArrayList<String> hand = new ArrayList<String>();
		for (int j = 0; j < 5; j++) {
			while (hand.size() < 5) {
				int index = rnd.nextInt(52);
				String card = deckOfCards.get(index);
				if (!hand.contains(card)) {
					hand.add(card);
				}
			}
		}
		return hand;
	}

}
