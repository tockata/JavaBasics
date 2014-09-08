import java.util.Scanner;


public class _03_Points_inside_Figure {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String coordinates = input.nextLine();
		
		String[] point = coordinates.split(" ");
		float x = Float.parseFloat(point[0]);
		float y = Float.parseFloat(point[1]);
		
		if ((x >= 12.5 && x <= 22.5 && y >= 6 && y <= 8.5) ||
			((x >= 12.5 && x <= 17.5) || (x >= 20 && x <= 22.5)) && y >= 8.5 && y <= 13.5) {
			System.out.println("Inside");
		}
		else {
			System.out.println("Outside");
		}

	}

}
