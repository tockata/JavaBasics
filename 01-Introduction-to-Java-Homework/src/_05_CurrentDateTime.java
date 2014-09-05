import java.time.LocalDateTime;


public class _05_CurrentDateTime {

	public static void main(String[] args) {
		LocalDateTime currentDateTime = LocalDateTime.now();
		System.out.println(currentDateTime);
		
		//Formatted output:
		System.out.printf("%1$td/%1$tm/%1$tY %1$tH:%1$tM", LocalDateTime.now());
		
	}

}
