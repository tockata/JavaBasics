import java.util.Scanner;


public class _01 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] startTime = input.nextLine().split(":");
		String[] endTime = input.nextLine().split(":");
		
		long startSeconds = Long.parseLong(startTime[0]) * 3600 + Long.parseLong(startTime[1]) * 60 + Long.parseLong(startTime[2]);
		long endSeconds = Long.parseLong(endTime[0]) * 3600 + Long.parseLong(endTime[1]) * 60 + Long.parseLong(endTime[2]);
		long diff = startSeconds - endSeconds;

		long hours = diff / 3600;
		diff = diff - hours * 3600;
		long minutes = diff / 60;
		long seconds = diff % 60;
		
		System.out.printf("%d:%02d:%02d", hours, minutes, seconds);

	}

}
