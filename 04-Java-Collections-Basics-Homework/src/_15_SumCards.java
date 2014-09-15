import java.util.Scanner;


public class _15_SumCards {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] hand = input.nextLine().split("[ SHDC]+");
		int sum = 0;
		boolean sameCard = false;
		
		for (int i = 0; i < hand.length; i++) {
			String card = hand[i];
			if (i < hand.length - 1) {
				if (card.equals(hand[i + 1])) {
					switch (card) {
					case "J": sum += 12 * 2; break;
					case "Q": sum += 13 * 2; break;
					case "K": sum += 14 * 2; break;
					case "A": sum += 15 * 2; break;
					default: sum += Integer.parseInt(card) * 2; break;
					}
					sameCard = true;
				} else {
					if (sameCard) {
						switch (card) {
						case "J": sum += 12 * 2; break;
						case "Q": sum += 13 * 2; break;
						case "K": sum += 14 * 2; break;
						case "A": sum += 15 * 2; break;
						default: sum += Integer.parseInt(card) * 2; break;
						}
						sameCard = false;
					} else {
						switch (card) {
						case "J": sum += 12; break;
						case "Q": sum += 13; break;
						case "K": sum += 14; break;
						case "A": sum += 15; break;
						default: sum += Integer.parseInt(card); break;
						}
						sameCard = false;
					}
				}
				} else {
					if (sameCard) {
						switch (card) {
						case "J": sum += 12 * 2; break;
						case "Q": sum += 13 * 2; break;
						case "K": sum += 14 * 2; break;
						case "A": sum += 15 * 2; break;
						default: sum += Integer.parseInt(card) * 2; break;
						}
					} else {
						switch (card) {
						case "J": sum += 12; break;
						case "Q": sum += 13; break;
						case "K": sum += 14; break;
						case "A": sum += 15; break;
						default: sum += Integer.parseInt(card); break;
					}
				}
			}
		}
		System.out.println(sum);
	}

}
