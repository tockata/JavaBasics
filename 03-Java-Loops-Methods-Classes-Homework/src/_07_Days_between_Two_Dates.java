import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class _07_Days_between_Two_Dates {

	public static void main(String[] args) throws ParseException {
		Scanner input = new Scanner(System.in);
		String firstDateString = input.nextLine();
		String secondDateString = input.nextLine();
		
		SimpleDateFormat pattern = new SimpleDateFormat("dd-MM-yyyy");
		Date firstDate = pattern.parse(firstDateString);
		Date secondDate = pattern.parse(secondDateString);
		//System.out.println(firstDate);
		//System.out.println(secondDate);
		
		long diff = secondDate.getTime() - firstDate.getTime();
		long diffDays = diff / (24 * 60 * 60 * 1000);
		System.out.println(diffDays);

	}

}
