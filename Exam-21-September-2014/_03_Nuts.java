import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;


public class _04 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine();
		
		TreeMap<String, LinkedHashMap<String, Integer>> data = new TreeMap<>();
		
		for (int i = 0; i < n; i++) {
			String[] line = input.nextLine().split("\\s+");
			
			String company = line[0];
			String nuts = line[1];
			String amountStr = line[2].substring(0, line[2].length() - 2);
			int amount = Integer.parseInt(amountStr);
			
			if (!data.containsKey(company)) {
				data.put(company, new LinkedHashMap<String, Integer>());
			}
			
			Integer count = data.get(company).get(nuts);
			if (count == null) {
				count = 0;
			}
			data.get(company).put(nuts, count + amount);
		}
		
		for (String company : data.keySet()) {
			System.out.print(company + ": ");
			int count = 0;
			for (String nut : data.get(company).keySet()) {
				if (count == 0) {
					System.out.print(nut + "-" + data.get(company).get(nut) + "kg");
				} else {
					System.out.print(", " + nut + "-" + data.get(company).get(nut) + "kg");
				}
				count++;
			}
			System.out.println();
		}

	}

}
