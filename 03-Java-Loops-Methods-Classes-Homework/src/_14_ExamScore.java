import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;


public class _14_ExamScore {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<String> inputs = new ArrayList<>();
		String line = input.nextLine();
		TreeMap<Integer, TreeMap<String, Double>> results = new TreeMap<>();
		int count = 0;
				
		while (true) {
			if (count > 3 && line.contains("---------")) {
				break;
			}
			count++;
			line = line.substring(1, line.length() - 1);
			inputs.add(line);
			line = input.nextLine();
		}
		inputs.remove(0);
		inputs.remove(0);
		inputs.remove(0);
				
		for (String data : inputs) {
			String[] rows = data.split("\\|");
			for (int i = 0; i < rows.length; i++) {
				rows[i] = rows[i].trim();
			}
			if (!results.containsKey(Integer.parseInt(rows[1]))) {
				results.put(Integer.parseInt(rows[1]), new TreeMap<>());
			}
			results.get(Integer.parseInt(rows[1])).put(rows[0], Double.parseDouble(rows[2]));
		}
		
		for (Entry<Integer, TreeMap<String, Double>> examScore : results.entrySet()) {
			double avg = 0;
			double sum = 0;
			double total = examScore.getValue().size();
			StringJoiner joiner = new StringJoiner(", ");
			for (Entry<String, Double> students : examScore.getValue().entrySet()) {
				sum += students.getValue();
				joiner.add(students.getKey());
			}
			avg = sum / total;
			String studentsList = joiner.toString();
			System.out.printf("%d -> [%s]; avg=%.2f", examScore.getKey(), studentsList, avg);
			System.out.println();
		}

	}

}
