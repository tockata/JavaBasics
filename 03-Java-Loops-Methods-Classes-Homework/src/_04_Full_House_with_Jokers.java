//this problem is not solved yet

import java.util.ArrayList;


public class _04_Full_House_with_Jokers {

	public static void main(String[] args) {
		String[] faces = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		char[] suits = {'\u2660','\u2665', '\u2666', '\u2663'};
		ArrayList<String> threeCards = new ArrayList<String>();
		ArrayList<String> twoCards = new ArrayList<String>();
		ArrayList<String> fullHouses = new ArrayList<String>();
		ArrayList<String> fullHousesWithJoker = new ArrayList<String>();
		int count = 0;
		
		for (int i = 0; i < faces.length; i++) {
			generateThreeCards(faces[i], suits, threeCards);
			generateTwoCards(faces[i], suits, twoCards);
		}
		
		for (int i = 0; i < threeCards.size(); i++) {
			for (int j = 0; j < twoCards.size(); j++) {
				if (threeCards.get(i).charAt(0) != twoCards.get(j).charAt(0)) {
					String fullhouse = threeCards.get(i) + twoCards.get(j);
					fullHouses.add(fullhouse);
				}
			}
		}
		
		for (String fullHouse : fullHouses) {
			generateFullhousesWithJokers(fullHousesWithJoker, fullHouse);
		}
		

	}

	private static void generateFullhousesWithJokers(
			ArrayList<String> fullHousesWithJoker, String fullHouse) {
		String[] splittedFullHouse = {fullHouse.substring(0, 2), fullHouse.substring(2, 4),
			fullHouse.substring(4, 6), fullHouse.substring(6, 8), fullHouse.substring(8)};
		
	}

	private static void generateTwoCards(String face, char[] suits, ArrayList<String> twoCards) {
		twoCards.add(face + suits[0] + face + suits[1]);
		twoCards.add(face + suits[1] + face + suits[2]);
		twoCards.add(face + suits[2] + face + suits[3]);
		twoCards.add(face + suits[3] + face + suits[0]);
		twoCards.add(face + suits[0] + face + suits[2]);
		twoCards.add(face + suits[1] + face + suits[3]);
	}

	private static void generateThreeCards(String face, char[] suits, ArrayList<String> threeCards) {
		threeCards.add(face + suits[0] + face + suits[1] + face + suits[2]);
		threeCards.add(face + suits[1] + face + suits[2] + face + suits[3]);
		threeCards.add(face + suits[2] + face + suits[3] + face + suits[0]);
		threeCards.add(face + suits[0] + face + suits[2] + face + suits[3]);
	}

}
