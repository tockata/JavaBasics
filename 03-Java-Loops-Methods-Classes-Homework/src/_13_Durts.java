import java.util.Scanner;


public class _13_Durts {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] centerString = input.nextLine().split("[\\s]+");
		double[] center = {Double.parseDouble(centerString[0]), Integer.parseInt(centerString[1])};
		double cX = center[0];
		double cY = center[1];
		double r = input.nextDouble();
		int n = input.nextInt();
		input.nextLine();
		String[] coordinatesString = input.nextLine().split("\\s+");
		double x, y;
		
		for (int i = 0; i < coordinatesString.length - 1; i += 2) {
			x = Double.parseDouble(coordinatesString[i]);
			y = Double.parseDouble(coordinatesString[i + 1]);
			
			if ((x >= cX - r / 2 && x <= cX + r / 2 && y >= cY - r && y <= cY + r) ||
				 x >= cX - r && x <= cX + r && y >= cY - r / 2 && y <= cY + r / 2) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}

	}

}
