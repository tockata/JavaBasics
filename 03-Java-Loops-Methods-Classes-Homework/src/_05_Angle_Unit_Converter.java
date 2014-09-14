import java.util.Scanner;


public class _05_Angle_Unit_Converter {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine();
		
		for (int i = 0; i < n; i++) {
			String query = input.nextLine();
			String[] splittedQuery = query.split(" ");
			if (splittedQuery[1].equals("deg")) {
				double radians = convertDegToRad(splittedQuery[0]);
				System.out.printf("%.6f rad", radians);
			} else {
				double degrees = convertRadToDeg(splittedQuery[0]);
				System.out.printf("%.6f deg", degrees);
			}
		}

	}

	private static double convertDegToRad(String deg) {
		double degrees = Double.parseDouble(deg);
		double rad = degrees * (Math.PI / 180);
		return rad;
	}
	
	private static double convertRadToDeg(String rad) {
		double radians = Double.parseDouble(rad);
		double deg = radians * (180 / Math.PI);
		return deg;
	}

}
