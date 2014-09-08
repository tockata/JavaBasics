import java.util.Scanner;


public class _09_Points_inside_the_House {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String coordinatesString = input.nextLine();
		String[] splittedCoordinates = coordinatesString.split(" ");
		float x = Float.parseFloat(splittedCoordinates[0]);
		float y = Float.parseFloat(splittedCoordinates[1]);
				
		float firstPosition = (22.5f - 12.5f) * (y - 8.5f) - (8.5f - 8.5f) * (x - 12.5f);
		float secondPosition = (17.5f - 12.5f) * (y - 8.5f) - (3.5f - 8.5f) * (x - 12.5f);
		float thirdPosition = (22.5f - 17.5f) * (y - 3.5f) - (8.5f - 3.5f) * (x - 17.5f);
		
		if ((firstPosition <= 0 && secondPosition >= 0 && thirdPosition >= 0) ||
			(firstPosition >= 0 && y <= 13.5 && x >=12.5 && x <= 17.5) ||
			(firstPosition >= 0 && y <= 13.5 && x >= 20 && x <= 22.5)) {
			System.out.println("Inside");
		}
		else {
			System.out.println("Outside");
		}

	}

}
