import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class _08_Sum_Numbers_from_a_Text_File {

	public static void main(String[] args) {
		BufferedReader fileReader = null;
		try	 {
			fileReader = new BufferedReader(new FileReader("src/08_input.txt"));
			int sum = 0;
			while (true) {
				String line = fileReader.readLine();
				if (line == null) {
					break;
				}
				sum += Integer.parseInt(line);
			}
			System.out.println(sum);
		} catch (IOException ioex) {
			System.err.println("Error");
		}
		finally {
			try {
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
				System.err.println("Error closing the file.");
			}
		}

	}

}
