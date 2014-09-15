import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;


public class _16_SimpleExpression {

	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);
		Scanner input = new Scanner(System.in);
		String expression = input.nextLine();
		
		BigDecimal result = new BigDecimal(0.0);
		
		int startIndex = 0;
		int endIndex = 1;
		char tempSign;
		char sign = ' ';
		
		
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '-' || expression.charAt(i) == '+') {
				endIndex = i;
				tempSign = expression.charAt(i);
				String numberStr = expression.substring(startIndex, endIndex).trim();
				BigDecimal number = new BigDecimal(numberStr);
				if (startIndex == 0) {
					result = result.add(number);
				} else {
					switch (sign) {
					case '+': result = result.add(number); break;
					case '-': result = result.subtract(number);
					default: break;
					}
				}
				startIndex = endIndex + 1;
				sign = tempSign;
			} else if (i == expression.length() - 1) {
				String numberStr = expression.substring(startIndex).trim();
				BigDecimal number = new BigDecimal(numberStr);
				switch (sign) {
				case '+': result = result.add(number); break;
				case '-': result = result.subtract(number);
				default: break;
				}
			}
		}
		System.out.printf("%.7f", result);

	}

}
