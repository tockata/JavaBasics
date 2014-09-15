import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class _08_Extract_Emails {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String text = input.nextLine();
		
		Pattern emailPattern = Pattern.compile("[\\w]+[\\.-]*[\\w]+@[A-Za-z-]+-*[A-Za-z]\\.[A-Za-z]+\\.*[A-Za-z]+");
		Matcher matcher = emailPattern.matcher(text);
		
		while (matcher.find()) {
			System.out.println(matcher.group());
		}

	}

}
